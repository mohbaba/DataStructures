
package ArrayList;

import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList {
    private int numberOfElements;
    private int[] integerArray = new int[3];
    private double[] doubleArray = new double[3];
    private char[] charArray = new char[3];
    private boolean[] booleanArray = new boolean[3];

    private String[] stringArray = new String[3];
    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    private void addElement(String[] array,String element){
        array[numberOfElements] = element;
        numberOfElements++;
    }

    private void addElement(int[] array,int element){
        array[numberOfElements] = element;
        numberOfElements++;
    }

    private void addElement(double[] array,double element){
        array[numberOfElements] = element;
        numberOfElements++;
    }

    private void addElement(char[] array,char element){
        array[numberOfElements] = element;
        numberOfElements++;
    }

    private void addElement(boolean[] array,boolean element){
        array[numberOfElements] = element;
        numberOfElements++;
    }
    public void add(String element) {
        if (this.stringArray.length == numberOfElements) {
            resize(this.stringArray);
            addElement(stringArray,element);
        }else {
            addElement(stringArray, element);
        }
    }

    public int getSize() {
        return  numberOfElements;
    }

    public void remove(String element) {
        for (int index = 0; index < stringArray.length; index++) {
            if (Objects.equals(stringArray[index], element)){
                stringArray[index] = stringArray[index + 1];
                numberOfElements--;
                break;
            }
        };

    }

    public void remove(int element) {
        if (element < 1 || element > numberOfElements) {
            throw new IllegalArgumentException("Argument exceeded length of array!");
        }
        for (int index = 0; index < stringArray.length; index++) {
            if (index == element-1) {
                stringArray[index] = stringArray[index + 1];
                numberOfElements--;

            }

        }
    }

    public String get(int index) {
        if (index < 1  || index > numberOfElements){
            throw new ArrayIndexOutOfBoundsException("Index not within range");
        }

        return stringArray[index-1];
    }

    private void resize(String[] array){
        String[] newArray = new String[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        stringArray = newArray;
    }

    private void resize(int[] array){
        int[] newArray = new int[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        integerArray = newArray;
    }

    private void resize(double[] array){
        double[] newArray = new double[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        doubleArray = newArray;
    }

    private void resize(char[] array){
        char[] newArray = new char[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        charArray = newArray;
    }

    private void resize(boolean[] array){
        boolean[] newArray = new boolean[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        booleanArray = newArray;
    }


}
