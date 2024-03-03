package TicTacToeTests;

import TicTacToe.Exceptions.InvalidMoveException;
import TicTacToe.Player;
import TicTacToe.BoardPosition;
import TicTacToe.TicTacToe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testThatBoardIsEmptyWhenGameIsStarted(){
        BoardPosition[][] board = game.getBoard();
        assertArrayEquals(testBoard,board);
    }

    @Test
    public void testThatPlayerOneCanPlayXOnTheBoard(){
        BoardPosition[][] board = game.getBoard();

        game.player1.play(1,game);
        assertEquals(BoardPosition.X,board[0][0]);
    }

    @Test
    public void testThatPlayerTwoCanPlayXOnTheBoard(){
        BoardPosition[][] board = game.getBoard();

        game.player1.play(5,game);
        game.player2.play(1,game);
        assertNotEquals(BoardPosition.X,board[0][0]);
        assertEquals(BoardPosition.O,board[0][0]);
    }

    @Test
    public void testThatPlayerCannotPlayInFilledSpace__ThrowsExceptionIfTried(){

        game.player1.play(2,game);
        game.player2.play(3,game);
        assertThrows(InvalidMoveException.class,()->game.player1.play(3,game));
    }

    @Test
    public void testThatPlayerCannotPlayTwiceInARow__ThrowsExceptionIfTried(){

        game.player1.play(2,game);
        game.player2.play(3,game);
        game.player1.play(5,game);
        game.player2.play(9,game);

        assertThrows(InvalidMoveException.class,()->game.player2.play(4,game));
    }

    @Test
    public void testThatPlayerCannotEnterIncorrectNumberPosition__ThrowsExceptionIfTried(){
        assertThrows(InvalidMoveException.class,()->game.player1.play(10,game));
    }

    @Test
    public void testThatPlayerTwoCannotPlayFirst__ThrowsExceptionIfTried(){
        assertThrows(InvalidMoveException.class,()->game.player2.play(4,game));
    }

    @Test
    public void testThatPlayerWinsGame(){
        game.player1.play(2,game);
        game.player2.play(3,game);
        game.player1.play(5,game);
        game.player2.play(9,game);
        game.player1.play(8,game);
        assertTrue(game.checkWinner());
        assertNotNull(game.getWinner());

    }

    @Test
    public void testDrawAfterAllTheSpacesAreFilled(){
        game.player1.play(5,game);
        game.player2.play(3,game);
        game.player1.play(9,game);
        game.player2.play(1,game);
        game.player1.play(2,game);
        game.player2.play(8,game);
        game.player1.play(7,game);
        game.player2.play(6,game);
        game.player1.play(4,game);
        assertTrue(game.isDraw());
    }

    @Test
    public void testThatIfThereIsWinnerAndBoardISFilled_DrawShouldBeFalse(){
        game.player1.play(1,game);
        game.player2.play(3,game);
        game.player1.play(2,game);
        game.player2.play(4,game);
        game.player1.play(5,game);
        game.player2.play(7,game);
        game.player1.play(6,game);
        game.player2.play(9,game);
        game.player1.play(8,game);
        assertFalse(game.isDraw());
    }
}
