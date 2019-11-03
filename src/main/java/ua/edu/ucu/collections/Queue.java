package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList Lst;

    public Queue() {
        Lst = new ImmutableLinkedList();
    }

    public Object peek() {
        return Lst.getLast();
    }

    public Object dequeue() {
        Object res = peek();
        Lst = Lst.removeLast();
        return res;
    }

    public void enqueue(Object e) {
        Lst = Lst.addFirst(e);
    }

    
}
