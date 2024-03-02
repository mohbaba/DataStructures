package TicTacToe;

public class Player {
    private static int id ;
    public Player() {
        ++id;
    }

    public int getId() {
        return id;
    }
}
