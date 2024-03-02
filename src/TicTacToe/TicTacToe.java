package TicTacToe;

import TicTacToe.Exceptions.InvalidMoveException;

import java.util.Arrays;

public class TicTacToe {
    public Player player1;
    public Player player2;
    BoardPosition[][] board;



    public TicTacToe(){

        player1 = new Player(1,true);
        player2 = new Player(2,false);

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

    public void markBoard(int position, int playerNumber) {
        if (isValidMove(position)){
            int row = (position - 1) / 3;
            int column = (position - 1) % 3;
            if (playerNumber == 1){
                if (isSpaceEmpty(row,column))board[row][column] = BoardPosition.X;
                else throw new InvalidMoveException("Space is already filled");
            }else {
                if (isSpaceEmpty(row,column))board[row][column] = BoardPosition.O;
                else throw new InvalidMoveException("Space is already filled");
            }
        }

    }
}

