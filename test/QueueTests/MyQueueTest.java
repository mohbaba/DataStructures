package QueueTests;

import ArrayList.MyArrayList;
import Queue.MyQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class MyQueueTest {
    private MyQueue queue;

    @BeforeEach
    public void testThatQueueIsEmptyWhenCreated(){
        queue = new MyQueue();
        assertTrue(queue.isEmpty());

    }

    @Test
    public void testThatQueueIsEmpty(){

        assertTrue(queue.isEmpty());
    }

    @Test
    public void testThatQueueIsNotEmpty() {
        assertTrue(queue.isEmpty());

        queue.add(5);
        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThatOneItemCanBeAddedToQueue(){

        assertTrue(queue.isEmpty());

        queue.add(2);
        assertEquals(1,queue.getSize());

        assertFalse(queue.isEmpty());
    }

    @Test
    public void testThatTwoItemsCanBeAddedToListAndOneCanBeRemoved(){

        assertTrue(queue.isEmpty());

        queue.add(1);
        queue.add(2);
        assertEquals(2,queue.getSize());

        queue.remove();
        assertEquals(1,queue.getSize());
        assertFalse(queue.isEmpty());

    }

    @Test
    public void removeElementFromEmptyList_ThrowsExceptionTest(){
        assertThrows(NoSuchElementException.class,()->queue.remove());
    }


}
