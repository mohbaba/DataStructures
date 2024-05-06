package TurtleGraphicsTest;

import TurtleGraphics.Position;
import TurtleGraphics.Turtle;
import org.junit.jupiter.api.Test;

import static TurtleGraphics.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

    @Test
    public void testThatTurtlePenIsUp(){
        Turtle turtle = new Turtle();
        assertTrue(turtle.isPenUp());
    }

    @Test
    public void testThatTurtlePenIsDown(){
        Turtle turtle = new Turtle();
        assertTrue(turtle.isPenUp());
        turtle.penDown();
        assertFalse(turtle.isPenUp());
    }

    @Test
    public void testThatTurtleCanTurnLeft(){
        Turtle turtle = new Turtle();
        assertSame(EAST,turtle.getTurtleDirection());
        turtle.turnLeft();
        assertSame(NORTH, turtle.getTurtleDirection());
    }

    @Test
    public void turtleTurnsLeftTwice_TurtleDirectionIsWestTest(){
        Turtle turtle = new Turtle();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(WEST, turtle.getTurtleDirection());
    }

    @Test
    public void turtleTurnsLeftThrice_TurtleDirectionIsSouthTest(){
        Turtle turtle = new Turtle();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.turnLeft();
        assertSame(SOUTH, turtle.getTurtleDirection());
    }

    @Test
    public void turtleTurnsRight_TurtleDirectionIsSouthTest(){
        Turtle turtle = new Turtle();
        turtle.turnRight();
        assertSame(SOUTH,turtle.getTurtleDirection());
    }

    @Test
    public void turtleMovesFiveStepsEast_TurtlePositionChangesTest(){
        Turtle turtle = new Turtle();
        turtle.move(5);
        assertEquals(new Position(0,4),turtle.checkPosition());
    }

    @Test
    public void turtleMovesFiveStepsSouth_TurtlePositionChangesTest(){
        Turtle turtle = new Turtle();
        turtle.turnRight();
        turtle.move(5);
        assertEquals(new Position(4,0),turtle.checkPosition());
    }

    @Test
    public void turtleMovesFiveStepsWest_TurtlePositionChangesTest(){
        Turtle turtle = new Turtle();
        turtle.turnLeft();
        turtle.turnLeft();
        turtle.move(5);
        assertEquals(new Position(4,0),turtle.checkPosition());
    }

}
