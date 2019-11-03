package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList queueLst;

    public Queue() {
        queueLst = new ImmutableLinkedList();
    }

    public Object peek() {
        return queueLst.getLast();
    }

    public Object dequeue() {
        Object res = peek();
        queueLst = queueLst.removeLast();
        return res;
    }

    public void enqueue(Object e) {
        queueLst = queueLst.addFirst(e);
    }

    
}
