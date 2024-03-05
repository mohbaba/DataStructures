package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static final TicTacToe game = new TicTacToe();
    public static void main(String[] args) {

        displayBoard();
    }
    public static void print(String prompt){
        JOptionPane.showMessageDialog(null,prompt);
    }

    public static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }

    public static void displayBoard(){
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
}
