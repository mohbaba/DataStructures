package SevenSegmentDisplay;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SevenSegmentDisplay display = new SevenSegmentDisplay();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter combination you'd like to display: ");
            String input = scanner.next();
            System.out.println(display.display(input));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
