package TicTacToe;

import java.util.Arrays;

public class TicTacToe {
    private final Player[] players;
    BoardPosition[][] board = new BoardPosition[3][3];

    public TicTacToe(){

        Player player1 = new Player(1);
        Player player2 = new Player(2);

        players = new Player[2];
        players[0] = player1;
        players[1] = player2;
        populateBoard();

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

