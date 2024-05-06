package TurtleGraphics;
import static TurtleGraphics.Direction.*;

public class Turtle {
    private boolean isPenUp = true;
    private Direction currentDirection = EAST;
    private Position currentPosition = new Position(0,0) ;

    public boolean isPenUp(){
        return isPenUp;
    }

    public void penDown() {
        isPenUp = false;
    }

    public Direction getTurtleDirection() {

        return currentDirection;
    }

    public void turnLeft() {
        currentDirection = currentDirection.turnLeft();
    }

    public void turnRight() {
        currentDirection = currentDirection.turnRight();
    }

    public void move(int numberOfSteps) {

        switch (currentDirection){
            case EAST -> moveEastWard(numberOfSteps);
            case SOUTH -> moveSouthWard(numberOfSteps);
        }

    }

    private void moveEastWard(int numberOfSteps){
        int currentRow = currentPosition.getCurrentRow();
        int currentColumn = currentPosition.getCurrentColumn() + numberOfSteps - 1;
        currentPosition = new Position(currentRow, currentColumn);
    }
    private void moveSouthWard(int numberOfSteps){
        int currentRow = currentPosition.getCurrentRow() + numberOfSteps - 1;
        int currentColumn = currentPosition.getCurrentColumn() + numberOfSteps -1;
        currentPosition = new Position(currentRow, currentColumn);
    }


    public Position checkPosition() {
        return currentPosition;
    }
}
