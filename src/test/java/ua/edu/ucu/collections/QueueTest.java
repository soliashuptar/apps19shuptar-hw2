package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    
    @Test
    public void testPeek() {
        Queue queue1 = new Queue();
        queue1.enqueue(1);
        queue1.enqueue(2);
        assertEquals(1, queue1.peek());
    }

    @Test
    public void testDequeue() {
        Queue queue1 = new Queue();
        queue1.enqueue(1);
        queue1.enqueue(3);
        assertEquals(1, queue1.dequeue());

    }
    
}
