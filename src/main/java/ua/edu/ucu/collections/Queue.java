package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    private ImmutableLinkedList QueueLst;

    public Queue() {
        QueueLst = new ImmutableLinkedList();
    }

    public Object peek() {
        return QueueLst.getLast();
    }

    public Object dequeue() {
        Object res = peek();
        QueueLst = QueueLst.removeLast();
        return res;
    }

    public void enqueue(Object e) {
        QueueLst = QueueLst.addFirst(e);
    }

    
}
