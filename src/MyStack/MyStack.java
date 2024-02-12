package MyStack;

import java.util.EmptyStackException;

public class MyStack {
    private int numberOfElements;
    private boolean isDynamic;
    private int length;
    private int[] intArray;

    public MyStack(int length){
        if (length < 0) {
            throw new IllegalArgumentException("Size Of Stack Cannot be Negative!");
        }
        isDynamic = false;
        this.length = length;
        intArray = new int[length];
    }

    public MyStack(){
        isDynamic = true;
        this.length = 10;
        intArray = new int[length];
    }


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

    private void resize(int[] array){
        int[] newArray = new int[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        intArray = newArray;
    }
    public void push(int element) {
        boolean isArrayFull = intArray.length == numberOfElements;
        if (isDynamic) {
            if (isArrayFull) {
                resize(this.intArray);
                addElement(intArray,element);
            }else {
                addElement(intArray, element);
            }

        }else {
            if (isArrayFull) {
                throw new StackOverflowError();
            }
            addElement(intArray, element);
        }


    }

    public int getSize() {

        return numberOfElements;
    }


    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty!");
        }
        return intArray[numberOfElements-1];
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int poppedElement = intArray[numberOfElements-1];
        intArray[numberOfElements-1] = 0;
        numberOfElements--;

        return poppedElement;
    }

    public int search(int element) {
        if (numberOfElements == 0) {
            throw new EmptyStackException();
        }
        for (int index = 0; index < numberOfElements; index++) {
            if (intArray[index] == element) {
                return numberOfElements - (index +1);
            }
        }
        return 0;
    }
}
