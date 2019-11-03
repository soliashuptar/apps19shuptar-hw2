package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {

    private Node head;

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
        head = node;

    }

    public ImmutableLinkedList(Node h) {
        head = h;
    }


    public ImmutableList add(Object e){
        Node start = head;
        if (start.data == null) {
            start = new Node(e);
            return new ImmutableLinkedList(start);
        }
        Node temp = start;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(e);
        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node start = new Node(e);
            start.next = head;
            return new ImmutableLinkedList(start);
        }

        Node start = head;
        Node temp = start;
        int ind = 0;

        while (temp.next != null) {
            if (ind == index - 1) {
                Node el = temp.next;
                temp.next = new Node(e);
                temp = temp.next;
                temp.next = el;
            } else {
                temp = temp.next;
//                temp.next = el;
            }
            ind += 1;
        }

        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableList addAll(Object[] c) {

        Node start = head;
        int ind = 0;
        if (start.data == null) {
            start =  new Node(c[0]);
            ind += 1;

        }
        Node temp = start;
        while (temp.next != null) {
            temp = temp.next;
        }
        for (int i = ind; i < c.length; i ++) {
            temp.next = new Node(c[i]);
            temp = temp.next;
        }

        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node start = head;
        Node temp = start;
        int ind = 0;

        while (temp.next != null) {
            if (ind == index - 1) {
                Node el = temp.next;
                for (int i = 0; i < c.length; i ++) {
                    temp.next = new Node(c[i]);
                    temp = temp.next;
                }
                temp.next = el;
            } else {
                temp = temp.next;
//                temp.next = el;
            }
            ind += 1;
        }


        return new ImmutableLinkedList(start);
    }

    @Override
    public Object get(int index) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node temp = head;
        int ind = 0;
        Object result = null;
        while (temp.next != null) {
            if (ind == index) {
                result = temp.data;
            }
            temp = temp.next;
            ind += 1;
        }
        return result;
    }

    @Override
    public ImmutableList remove(int index) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
//            Node start = new Node(e);
            Node start = head.next;
            return new ImmutableLinkedList(start);
        }
        int ind = 0;
        Node start = head;
        Node temp = start;
        if (index == size() - 1) {
            for (int i = 1; i < size(); i ++) {
                if (ind == index - 1) {
                    temp.next = temp.next.next;

                    temp = temp.next;
                } else {
                    temp = temp.next;
                }
                ind += 1;
            }
        } else {
            while (temp.next != null) {
                if (ind == index - 1) {
                    temp.next = temp.next.next;

                    temp = temp.next;
                } else {
                    temp = temp.next;
                }
                ind += 1;
            }
        }
        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            Node start = new Node(e);
            start.next = head.next;
            return new ImmutableLinkedList(start);
        }

        Node start = head;
        Node temp = start;
        int ind = 0;

        while (temp.next != null) {
            if (ind == index - 1) {
                Node el = temp.next.next;
                temp.next = new Node(e);

                temp = temp.next;
                temp.next = el;
            } else{
                temp = temp.next;
            }
            ind += 1;
        }
        return new ImmutableLinkedList(start);
    }

    @Override
    public int indexOf(Object e) {
        if (head.data == null) {
            throw new IndexOutOfBoundsException();
        }
        int ind = 0;

        Node temp = head;
        while (temp.next != null) {
            if (temp.data == e) {
                return ind;
            }
            temp = temp.next;
            ind += 1;
        }
        return -1;
    }

    @Override
    public int size() {
        int size = 0;
        Node current =  head;
        while (current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return head.data == null;
    }

    @Override
    public Object[] toArray() {
        Node current = head;
        Object[] newArr = new Object[size()];

        int ind = 0;
        newArr[ind] = current.data;
        ind += 1;
        while (current.next != null) {

            current = current.next;
            newArr[ind] = current.data;
            ind += 1;

        }
        for (int i = 0; i < newArr.length; i ++) {
            System.out.println(newArr[i]);
        }
        return newArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        if (head.data == null) {
            Node start = new Node(e);
            return new ImmutableLinkedList(start);
        } else {
            Node prevHead = head;
            Node start = new Node(e);
            start.next = prevHead;
            return new ImmutableLinkedList(start);

        }
    }

    public ImmutableLinkedList addLast(Object e) {
        return (ImmutableLinkedList) add(e);
    }

    public Object getFirst() {
        return head.data;

    }

    public Object getLast() {
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data;
    }

    public ImmutableLinkedList removeFirst() {
        return (ImmutableLinkedList) remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return (ImmutableLinkedList) remove((size() - 1));
    }


}
