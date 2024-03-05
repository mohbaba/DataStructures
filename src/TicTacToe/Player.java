package TicTacToe;

public class Player {
    private final int id ;
    private final String name;
    public boolean isFirstPlayer;
    public Player(int id,boolean isFirstPlayer,String name) {
        this.name = name;
        this.id = id;
        this.isFirstPlayer = isFirstPlayer;
    }

    public int getId() {
        return id;
    }

    public void play(int position, TicTacToe game){
        game.markBoard(position,getId());
    }

    public String toString(){
        return this.name;
    }
}
