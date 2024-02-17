package MySet;

import java.util.Objects;

public class MySet {
    private int numberOfElements;
    private int[] intArray = new int[5];
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public void add(int element) {
        intArray[numberOfElements] = element;
        numberOfElements++;

    }

    public int getSize() {

        return numberOfElements;
    }

    public void remove(int element) {

        for (int index = 0; index < intArray.length; index++) {
            if (Objects.equals(intArray[index], element)){
                intArray[index] = intArray[index + 1];
                numberOfElements--;
                break;
            }
        };

    }

    public int get(int element) {
        if (element < 1) {
            throw new IllegalArgumentException("Negative Indexing Not Allowed");
        }else if (element > numberOfElements) {
            throw new IllegalArgumentException("Argument Exceeds Set Length");
        }
        return intArray[element - 1];
    }
}
