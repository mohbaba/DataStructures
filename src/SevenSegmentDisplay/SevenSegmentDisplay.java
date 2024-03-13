package SevenSegmentDisplay;

public class SevenSegmentDisplay {
    public static void checkInputLength(String input) {
        if (input.length() != 8){
            throw new IllegalArgumentException("Your input is not 8 digits");
        }
    }



    public static void checkInput(String input) {
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

    public static String display(String input){
        checkInput(input);
        checkInputLength(input);
        char [] charArray = input.toCharArray();
        StringBuilder binary = new StringBuilder();

        if (isOn(input)){
            binary.append(charArray[0] == '1' ? "# # # #": "       ").append("\n");
            binary.append(charArray[5] == '1' ? "#     ": "      ");
            binary.append(charArray[1] == '1' ? "#": "").append("\n");
            binary.append(charArray[6] == '1' ? "# # # #": "       ").append("\n");
            binary.append(charArray[4] == '1' ? "#     ": "       ");
            binary.append(charArray[2] == '1' ? "#": "    ").append("\n");;
            binary.append(charArray[3] == '1' ? "# # # #": "       ").append("\n");

        }
        return binary.toString();
    }
}
