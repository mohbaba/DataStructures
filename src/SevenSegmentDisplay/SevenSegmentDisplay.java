package SevenSegmentDisplay;

import java.util.Arrays;

public class SevenSegmentDisplay {
    private final String[][] board = new String[5][4];

    public SevenSegmentDisplay(){
        for (String[] strings : board) {
            Arrays.fill(strings, " ");
        }
    }
    public static void checkInputLength(String input) {
        if (input.length() != 8){
            throw new IllegalArgumentException("Your input is not 8 digits");
        }
    }



    public static void validateBinaryInput(String input) {
        char [] charArray = input.toCharArray();
        for (char character : charArray) {
            if (character != '0' && character != '1') throw new IllegalArgumentException("Enter " +
                    "only 0s and 1s");

        }
    }


    public static boolean isOn(String input) {
        char [] charArray = input.toCharArray();
        return charArray[7] == '1';
    }
    
    public  void populateB(){
        for (int row = 0; row < 3; row++) {
//            for (int column = 0; column < board[row].length; column++) {
                board[row][board[row].length - 1] = "#";
//            }

        }

    }

    public  void populateC(){
        for (int row = 3; row < board.length; row++) {
//            for (int column = 0; column < board[row].length; column++) {
                board[row][board[row].length - 1] = "#";
//            }

        }
    }

    public void populateE(){
        for (int row = 3; row < board.length; row++) {
            board[row][0] = "#";
        }
    }

    public void populateF(){
        for (int row = 0; row < 3; row++) {
            board[row][0] = "#";
        }
    }
    
    public String[] populateAD(){
        return new String[]{"#", "#", "#", "#"};
    }

    public  String display(String input){
        validateBinaryInput(input);
        checkInputLength(input);
        char [] charArray = input.toCharArray();
        StringBuilder binary = new StringBuilder();

        if (isOn(input)){
            if (charArray[0] == '1')board[0] = populateAD();
            if (charArray[1] == '1')populateB();
            if (charArray[2] == '1')populateC();
            if (charArray[3] == '1')board[4] = populateAD();
            if (charArray[4] == '1')populateE();
            if (charArray[5] == '1')populateF();
        }
        for (String[] row : board) {
            StringBuilder rowString = new StringBuilder();
            for (String element : row) {
                rowString.append(element);
            }
            binary.append(rowString.toString()).append("\n");
        }
        return binary.toString();
    }
}
