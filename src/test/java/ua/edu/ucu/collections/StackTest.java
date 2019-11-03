package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    @Test
    public void testPeek() {
        Stack stack1 = new Stack();
        stack1.push(2);
        stack1.push(4);
        assertEquals(4, stack1.peek());
    }

    @Test
    public void testPop() {
        Stack stack1 = new Stack();
        stack1.push(2);
        stack1.push(4);
        assertEquals(4, stack1.pop());
    }
    
}
