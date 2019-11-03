package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList StackLst;

    public Stack() {
        StackLst = new ImmutableLinkedList();
    }

    public Object peek() {
        return StackLst.getLast();
    }

    public Object pop() {
        Object res = peek();
        StackLst = StackLst.removeFirst();
        return res;
    }

    public void push(Object e) {
        StackLst = StackLst.addLast(e);
    }
    
}
