package TicTacToeTests;

import TicTacToe.Player;
import TicTacToe.BoardPosition;
import TicTacToe.TicTacToe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicTacToeTest {
    private TicTacToe game;
    private final BoardPosition[][] testBoard = {{BoardPosition.EMPTY,BoardPosition.EMPTY,
            BoardPosition.EMPTY},{BoardPosition.EMPTY, BoardPosition.EMPTY,BoardPosition.EMPTY},
            {BoardPosition.EMPTY,BoardPosition.EMPTY,BoardPosition.EMPTY}};

    @BeforeEach
    public void setup(){
         game = new TicTacToe();
    }

    @AfterEach
    public void tearDown(){
        game.populateBoard();
    }

    @Test
    public void testThatTicTacToeGameHasTwoPlayersAtStartOfGame(){
        Player[] players = game.getPlayers();
        assertEquals(2,players.length);
    }

    @Test
    public void testThatBoardIsEmptyWhenGameIsStarted(){
        BoardPosition[][] board = game.getBoard();
        assertArrayEquals(testBoard,board);
    }

    @Test
    public void testThatPlayerOneCanPlayXOnTheBoard(){

    }
}
