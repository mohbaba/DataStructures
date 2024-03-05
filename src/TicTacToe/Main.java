package TicTacToe;

import TicTacToe.Exceptions.InvalidMoveException;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        mainApp();
    }
    public static void print(String prompt){
        JOptionPane.showMessageDialog(null,prompt);
    }

    public static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }

    public static void displayBoard(TicTacToe game){
        JFrame frame = new JFrame("Tic Tac Toe");
        JPanel panel = new JPanel(new GridLayout(3,3));

        for (int row = 0; row < game.getBoard().length; row++) {
            for (int column = 0; column < game.getBoard()[row].length; column++) {
                String mark = game.getBoard()[row][column] == BoardPosition.EMPTY ? " " :
                        game.getBoard()[row][column].toString();
                JLabel box = new JLabel(mark);
                box.setHorizontalAlignment(JLabel.CENTER);
                box.setVerticalAlignment(JLabel.CENTER);

                box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(box);
            }
        }

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

    }

    private static void setGame(TicTacToe game,String player1, String player2){
        while (!game.checkWinner() || !game.isDraw()){
            displayBoard(game);
            int move1 = Integer.parseInt(input(player1+" Enter position between 1 and 9: "));
            game.player1.play(move1,game);
            displayBoard(game);
            int move2 = Integer.parseInt(input(player2+" Enter position between 1 and 9: "));
            game.player2.play(move2,game);
            displayBoard(game);

        }
        winCondition(game);

    }

    private static void winCondition(TicTacToe game){
        if (game.checkWinner()){
            print("Congratulations!!! "+game.getWinner().toString()+ " you win!!!!!1");
        } else if (game.isDraw()) {
            String continueGamePrompt =
                    input("The game is a draw, play again?(yes / no)").toLowerCase();
            if (continueGamePrompt.equals("yes"))mainApp();
            else if (continueGamePrompt.equals("no")) {
                print("See you later!");
                System.exit(0);
            }else {
                print("You no dey hear word, bye-bye sha");
            }
        }
    }

    public static void mainApp(){
        String player1 = input("Player One Enter your name: ");
        String player2 = input("Player Two Enter your name: ");
        TicTacToe game = new TicTacToe(player1,player2);
        print(player1.toUpperCase()+" plays first ");
        print("Enter 1-9 to select to play in on the board. Good Luck!!!");
        try{
            setGame(game, player1, player2);
        }catch (InvalidMoveException e){
            print(e.getMessage());
            setGame(game, player1, player2);
        }catch (Exception e){
            print(e.getMessage());
            mainApp();
        }
    }
}
