package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private Node head;
    private int size;

    static class Node {

        Object data;
        Node next;

        Node(Object value) {
            data = value;
            next = null;
        }

    }

    public ImmutableLinkedList() {
        Node node = new Node(null);
        node.next = null;

    }

//    public ImmutableLinkedList(Object arr[]) {
//        head = new Node(arr[0]);
//        Node current = head.next;
//
//        for (int i = 0; i < arr.length; i ++) {
//            current = arr[i];
//            current = current.next;
//
//        }



//    }

    public ImmutableList add(Object e){

        return null;
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return null;
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return null;
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        return null;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public ImmutableList remove(int index) {
        return null;
    }

    @Override
    public ImmutableList set(int index, Object e) {
        return null;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public ImmutableList clear() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

}
