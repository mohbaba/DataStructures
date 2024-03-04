package TicTacToe;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

    }
    public static void print(String prompt){
        JOptionPane.showMessageDialog(null,prompt);
    }

    public static String input(String prompt){
        return JOptionPane.showInputDialog(prompt);
    }

    public void displayBoard(){
        JFrame frame = new JFrame("Tic Tac Toe");
        JPanel panel = new JPanel();

        frame.add(panel);
    }
}
