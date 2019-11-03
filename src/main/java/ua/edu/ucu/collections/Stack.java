package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList stackLst;

    public Stack() {
        stackLst = new ImmutableLinkedList();
    }

    public Object peek() {
        return stackLst.getLast();
    }

    public Object pop() {
        Object res = peek();
        stackLst = stackLst.removeFirst();
        return res;
    }

    public void push(Object e) {
        stackLst = stackLst.addLast(e);
    }
    
}
