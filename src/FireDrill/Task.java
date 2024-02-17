package FireDrill;


public class Task {
    public static int[] convertToBinary(int[] inputArray) {
        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] % 2 == 0) inputArray[index] = 0;
            else inputArray[index] = 1;
        }
        return inputArray;
    }

    public static boolean[] convertToBoolean(int[] inputArray) {
        boolean[] newArray = new boolean[inputArray.length];
        for (int index = 0; index < newArray.length; index++) {
            newArray[index] = inputArray[index] % 2 != 0;
        }
        return newArray;
    }
    public static int[] convertToBoolean() {

        return new int[10];
    }
}
