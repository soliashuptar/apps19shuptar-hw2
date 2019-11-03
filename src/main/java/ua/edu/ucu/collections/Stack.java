package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    private ImmutableLinkedList Lst;

    public Stack() {
        Lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return Lst.getLast();
    }

    public Object pop() {
        Object res = peek();
        Lst = Lst.removeFirst();
        return res;
    }

    public void push(Object e) {
        Lst = Lst.addLast(e);
    }
    
}
