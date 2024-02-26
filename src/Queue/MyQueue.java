package Queue;



public class MyQueue {
    private int numberOfElements;
    private boolean isDynamic;
    private int length;
    private int[] intArray = new int[3];


    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    private void addElement(int[] array,int element){
        array[numberOfElements] = element;
        numberOfElements++;
    }

    public void add(int element) {
        if (this.intArray.length == numberOfElements) {
            resize(this.intArray);
            addElement(intArray,element);
        }else {
            addElement(intArray, element);
        }
    }
    private void resize(int[] array){
        int[] newArray = new int[array.length * 2];

        for (int index = 0; index < array.length; index++) {
            newArray[index] = array[index];
        }
        intArray = newArray;
    }
}
