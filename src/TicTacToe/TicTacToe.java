package TicTacToe;

import TicTacToe.Exceptions.InvalidMoveException;

import java.util.Arrays;

public class TicTacToe {
    public Player player1;
    public Player player2;
    private final BoardPosition[][] board;
    private Player winner;
    private int playerHasPlayed = 2;



    public TicTacToe(String name1, String name2){

        player1 = new Player(1,true,name1);
        player2 = new Player(2,false,name2);

        board = new BoardPosition[3][3];
        populateBoard();

    }

    public void populateBoard(){
        for (BoardPosition[] boardPositions : board) {
            Arrays.fill(boardPositions, BoardPosition.EMPTY);
        }
    }





    public BoardPosition[][] getBoard() {
        return board;
    }

    private boolean isValidMove(int position){
        if (position < 1 || position > 9)throw new InvalidMoveException("Invalid move! enter " +
                "number between 1 and 9");
        return true;
    }

    private boolean isSpaceEmpty(int row, int column){
        return board[row][column] == BoardPosition.EMPTY;
    }

    private void player2Play(int row, int column){
        if (isSpaceEmpty(row,column)){
            board[row][column] = BoardPosition.O;
            playerHasPlayed = 2;

        }
        else throw new InvalidMoveException("Space is already filled");
    }

    private void player1Play(int row, int column){
        if (isSpaceEmpty(row,column)){
            board[row][column] = BoardPosition.X;
            playerHasPlayed = 1;
        }
        else throw new InvalidMoveException("Space is already filled");
    }

    public Player getWinner() {
        return winner;
    }
    public void markBoard(int position, int playerNumber) {
        if (isValidMove(position)){
            int row = (position - 1) / 3;
            int column = (position - 1) % 3;
            if (playerNumber == 1){
                if (playerHasPlayed == 2){
                    if (!checkWinner()) player1Play(row, column);


                }else throw new InvalidMoveException("Not Your Turn");

            }else {
                if (playerHasPlayed == 1){
                    if (!checkWinner()) player2Play(row,column);
                }else throw new InvalidMoveException("Not Your Turn");

            }


        }

    }

    public boolean isDraw(){
        for (BoardPosition[] boardPositions : board) {
            for (BoardPosition boardPosition : boardPositions) {
                if (boardPosition == BoardPosition.EMPTY) {
                    return false;
                }
                if (checkWinner())return false;
            }
        }
        return true;
    }

    public boolean checkWinner() {
        for (int number = 0; number < 3; number++) {
            if (checkRow(number, BoardPosition.X)) {
                winner = player1;
                return true;
            }
            if ( checkRow(number, BoardPosition.O)){
                winner = player2;
                return true;
            }
            if (checkColumn(number, BoardPosition.X)) {
                winner = player1;
                return true;
            }
            if (checkColumn(number, BoardPosition.O)){
                winner = player2;
                return true;
            }
        }
        if (checkDiagonal(BoardPosition.X)){
            winner = player1;
            return true;
        }
        if (checkDiagonal(BoardPosition.O)){
            winner = player2;
            return true;
        }
        return false;
    }

    private boolean checkRow(int row, BoardPosition marker) {
        return (board[row][0] == marker && board[row][1] == marker && board[row][2] == marker);
    }

    private boolean checkColumn(int column, BoardPosition marker) {
        return (board[0][column] == marker && board[1][column] == marker && board[2][column] == marker);
    }

    private boolean checkDiagonal(BoardPosition marker) {
        boolean mainDiagonal = (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker);
        boolean reverseDiagonal = (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker);

        if (mainDiagonal) return true;
        else return reverseDiagonal;
    }

}

