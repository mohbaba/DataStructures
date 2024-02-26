package QueueTests;

import ArrayList.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Queue.MyQueue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyQueueTest {

//    @BeforeEach
//    public void testThatQueueIsEmptyWhenCreated(){
//        MyQueue queue = new MyQueue();
//        assertTrue(queue.isEmpty());
//
//    }

    @Test
    public void testThatQueueIsEmpty(){
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.isEmpty());
    }

    @Test
    public void testThatQueueIsNotEmpty() {
        MyQueue queue = new MyQueue();
        assertTrue(queue.isEmpty());

        queue.add("mohbaba");
        assertFalse(queue.isEmpty());
    }
}
