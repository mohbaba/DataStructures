package TurtleGraphics;

public class Position {
    private int currentRow;
    private int currentColumn;
    public Position(int currentRow, int currentColumn) {
        this.currentRow = currentRow;
        this.currentColumn = currentColumn;
    }

    public int getCurrentRow() {
        return currentRow;
    }

    public int getCurrentColumn() {
        return currentColumn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Position position) {
            return (currentRow == position.currentRow && currentColumn == position.currentColumn);
        }
        return false;
    }
}
