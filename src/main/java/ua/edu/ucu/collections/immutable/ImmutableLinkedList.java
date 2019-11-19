package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableLinkedList implements ImmutableList {

    private Node head;

    static class Node {

        private Object data;
        private Node next;

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

    public ImmutableLinkedList(Object[] arr) {
        if (arr.length >= 1) {
            Node node = new Node(arr[0]);
            this.head = node;

            Node curNode = node;
            for (int i = 1; i < arr.length; i++) {
                curNode = new Node(arr[i]);
                node.next = curNode;
                node = curNode;
            }

//            this.tail = curNode;
        }
    }

    public ImmutableLinkedList(Node h) {
        head = h;
    }

    private static ImmutableLinkedList copyOf(ImmutableLinkedList list) {
        return new ImmutableLinkedList(list.toArray());
    }


    public ImmutableLinkedList add(Object e) {
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
    public ImmutableLinkedList add(int index, Object e) {
//        System.out.println("COPYYY");
//        System.out.println(copyOf(this));
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
        Node el;
        Node nd;
        int ind = 0;
//        System.out.println(temp.next.data + "to add");

        while (temp.next != null) {
            if (ind == index - 1) {
//                System.out.println("Im here");
                el = temp.next;
                temp.next = new Node(e);
                temp = temp.next;
                temp.next = el;
//                temp = temp.next;
//                nd = new Node(e);
//                nd.next = temp.next;
//                temp.next = nd;

            } else {
                temp = temp.next;
//                temp.next = el;
            }
            ind += 1;
        }
//        System.out.println(Arrays.toString(new ImmutableLinkedList(start).toArray()));


        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {

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

        for (int i = ind; i < c.length; i++) {
            temp.next = new Node(c[i]);
            temp = temp.next;
        }

        return new ImmutableLinkedList(start);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node start = head;
        Node temp = start;
        int ind = 0;

        while (temp.next != null) {
            if (ind == index - 1) {
                Node el = temp.next;

                for (int i = 0; i < c.length; i++) {
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
//        System.out.println("Size blet" + size());
//        System.out.println(index + "forl " + size());
//        System.out.println(head.data);
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
//        if (head.data && head.next)

//        Node temp = head;
//        int ind = 0;
//        Object result = temp.data;
//        while (temp != null) {
//            try {
//                System.out.println("EL" + temp.data);
//                temp = temp.next;
//            }
//            catch (NullPointerException ignored) {
//                break;
//            }
//            System.out.println("EL" + temp.data);
//            temp = temp.next;
//        }
        Node temp = head;
        int ind = 0;
        Object result = temp.data;
//        System.out.println(temp.data == null);
        while (ind != index) {
//            System.out.println(temp.data);
//            if (ind == index) {
//                result = temp.data;
//            }
            temp = temp.next;
            ind += 1;
        }
        return temp.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {
//        System.out.println("COPYYY");
        ImmutableLinkedList copyArr = copyOf(this);
//        System.out.println(copyOf(this));

        if (head.data == null || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
//            Node start = new Node(e);
            Node start = copyArr.head.next;
            return new ImmutableLinkedList(start);
        }
        int ind = 0;
        Node start = copyArr.head;
        Node temp = start;
        Node nd;
        if (index == size() - 1) {

            for (int i = 1; i < size(); i++) {
                if (ind == index - 1) {
                    temp.next = temp.next.next;

                    temp = temp.next;
                } else {
                    temp = temp.next;
                }
                ind += 1;
            }
        } else {
            while (ind != index - 1) {
//                if (ind == index - 1) {
//                    temp.next = temp.next.next;

                    temp = temp.next;
                    ind += 1;
//                } else {
//                    temp = temp.next;
                }
            nd = temp.next.next;
            temp.next = nd;


//                ind += 1;
            }
        return copyArr;
//        return new ImmutableLinkedList(start);
        }
//        return new ImmutableLinkedList(start);
//    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
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
            } else {
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
            if (temp.data.equals(e)) {
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
        if (head.data == null) {
            return 0;
        }
//        System.out.println("size here" + head.data);
        while (current != null) {
            size += 1;
            current = current.next;
        }
        return size;
    }

    @Override
    public ImmutableLinkedList clear() {
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
        if (current.data != null) {
//            System.out.println("Yed its true");
            newArr[ind] = current.data;
        } else {
            return new Object[]{};
        }
//        newArr[ind] = current.data;
        ind += 1;
        while (current.next != null) {

            current = current.next;
            if (current.data != null){
                newArr[ind] = current.data;
            }
//            newArr[ind] = current.data;
            ind += 1;
        }

//        for (int i = 0; i < newArr.length; i++) {
//            System.out.println(newArr[i]);
//        }
        return newArr;
    }

    @Override
    public String toString() {
        toArray();
        StringBuilder s = new StringBuilder();
        Node temp = head;
        while (temp.next != null) {
            s.append(temp.data);
            s.append(", ");
            temp = temp.next;
        }
        s.append(getLast());
        return s.toString();

    }

    public ImmutableLinkedList addFirst(Object e) {
        if (head.data == null) {
            Node start = new Node(e);
            return new ImmutableLinkedList(start);
        } else {
            ImmutableLinkedList newArr = ImmutableLinkedList.copyOf(this);
            Node prevHead = head;
            newArr.head  = new Node(e);
            newArr.head.next = prevHead;
            return newArr;

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
        return (ImmutableLinkedList) remove(size() - 1);
    }


}
