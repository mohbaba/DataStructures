package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
    private final Player[] players;
    BoardPosition[][] board;

    public TicTacToe(){

        Player player1 = new Player();
        Player player2 = new Player();

        players = new Player[2];
        board = new BoardPosition[3][3];

        populateBoard();
        players[0] = player1;
        players[1] = player2;

    }

    public void populateBoard(){
        for (BoardPosition[] boardPositions : board) {
            Arrays.fill(boardPositions, BoardPosition.EMPTY);
        }
    }



    public Player[] getPlayers() {

        return players;
    }

    public BoardPosition[][] getBoard() {
        return board;
    }
}

