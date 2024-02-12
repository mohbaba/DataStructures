import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import MyStack.MyStack;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class MyStackTest {
    MyStack myStack;

    @BeforeEach
    public void setup(){
        myStack = new MyStack();
    }
    @Test
    public void testMyStackIsEmptyUponCreation(){
        assertTrue(myStack.isEmpty());
    }

    @Test
    public void testStackIsNotEmptyAfterAddingElements(){
        myStack.push(1);
        assertFalse(myStack.isEmpty());
    }

    @Test
    public void testGetSizeOfStackAfterPushingOneElement(){
        myStack.push(1);
        assertFalse(myStack.isEmpty());

        assertEquals(1,myStack.getSize());
    }

    @Test
    public void testGetSizeOfStackAfterPushingTwoElement(){
        myStack.push(1);
        myStack.push(2);
        assertFalse(myStack.isEmpty());

        assertEquals(2,myStack.getSize());
    }

    @Test
    public void testLengthWhenNumberOfElementsInStackIsZero (){
        MyStack myStack1 = new MyStack(5);
//        myStack.setLength(5);
        assertEquals(0,myStack1.getSize());

    }

    @Test
    public void throwExceptionWhenSizeOfStackIsSetToLessThanZeroTest (){
        assertThrows(IllegalArgumentException.class,()-> new MyStack(-1));
//        assertDoesNotThrow(IllegalArgumentException.class,()-> new MyStack(-1));

    }

    @Test
    public void peekAtTheTopMostElementTest(){
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        assertEquals(3,myStack.peek());
    }

    @Test
    public void peekAtTheTopMostElementTestInAnEmptyStack(){
    assertThrows(IllegalStateException.class,()->myStack.peek());
    }

    @Test
    public void stackOverflowsWhenMoreItemsInANonDynamicStackThanSizeSetWhenStackWasCreated(){
        MyStack myStack1 = new MyStack(5);
        for (int index = 0; index < 5; index++) {
            myStack1.push(index + 1);
        }
        assertThrows(StackOverflowError.class,()->myStack1.push(5));
    }

    @Test
    public void popAnElementFromStackTest(){
        for (int index = 0; index < 5; index++) {
            myStack.push(index + 1);
        }
        assertEquals(5,myStack.pop());
        assertEquals(4,myStack.pop());
        assertEquals(3,myStack.pop());


    }

    @Test
    public void getSizeOfStackAfterPoppingAnElementFromStackTest(){
        for (int index = 0; index < 5; index++) {
            myStack.push(index + 1);
        }
        assertEquals(5,myStack.pop());

        assertEquals(4,myStack.getSize());

        assertEquals(4,myStack.pop());
        assertEquals(3,myStack.pop());

        assertEquals(2,myStack.getSize());

    }

    @Test
    public void throwsEmptyStackExceptionWhenPoppingAnEmptyElement(){
        MyStack myStack1 = new MyStack();
        assertTrue(myStack1.isEmpty());
        assertThrows(EmptyStackException.class,()->myStack1.pop());
    }

    @Test
    public void searchEmptyStackForElement_ThrowsEmptyStackExceptionTest(){
        MyStack myStack1 = new MyStack();
        assertThrows(EmptyStackException.class,()->myStack1.search(2));
    }

    @Test
    public void searchStackForElement_ReturnsDistanceOfElementsToTheTop(){
        for (int index = 0; index < 5; index++) {
            myStack.push(index + 1);
        }

        assertEquals(2,myStack.search(3));
        assertEquals(3,myStack.search(2));

    }

    @Test
    public void pushElementToAFullFixedLengthStack_ThrowsStackOverFlowTest(){
        MyStack myStack1 = new MyStack(5);
        for (int index = 0; index < 5; index++) {
            myStack1.push(index + 1);
        }

        assertThrows(StackOverflowError.class,()->myStack1.push(6));

    }

    @Test
    public void testResizeStackIfSizeExceedsPredefinedSize(){
        MyStack myStack = new MyStack();
        for (int index = 0; index < 5; index++) {
            myStack.push(index + 1);
        }

        myStack.push(6);
        myStack.push(7);

        assertEquals(7,myStack.getSize());

    }












}
