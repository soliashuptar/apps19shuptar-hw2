package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {

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

            Node curNode;
            for (int i = 1; i < arr.length; i++) {
                curNode = new Node(arr[i]);
                node.next = curNode;
                node = curNode;
            }

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
        if (checkHead()) {
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
        if (checkHead() || checkIndex(index)) {
            temp();
        }
        if (index == 0) {
            Node start = new Node(e);
            start.next = head;
            return new ImmutableLinkedList(start);
        }

        Node start = head;
        Node temp = start;
        Node el;
        int ind = 0;
        while (temp.next != null) {
            if (ind == index - 1) {
                el = temp.next;
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
    public ImmutableLinkedList addAll(Object[] c) {

        Node start = head;
        int ind = 0;
        if (checkHead()) {
            start = new Node(c[0]);
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
        if (checkHead() || checkIndex(index)) {
            temp();
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
            }
            ind += 1;
        }

        return new ImmutableLinkedList(start);
    }

    @Override
    public Object get(int index) {
        if (checkIndex(index)) {
            temp();
        }
        Node temp = head;
        int ind = 0;
        while (ind != index) {
            temp = temp.next;
            ind += 1;
        }
        return temp.data;
    }

    @Override
    public ImmutableLinkedList remove(int index) {

        ImmutableLinkedList copyArr = copyOf(this);

        if (checkHead() || checkIndex(index)) {
            temp();
        }

        if (index == 0) {
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
                temp = temp.next;
                ind += 1;
            }
            nd = temp.next.next;
            temp.next = nd;
        }
        return copyArr;

    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        if (checkHead() || checkIndex(index)) {
            temp();
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
        if (checkHead()) {
            temp();
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
        Node current = head;
        if (checkHead()) {
            return 0;
        }

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
        return checkHead();
    }

    @Override
    public Object[] toArray() {
        Node current = head;
        Object[] newArr = new Object[size()];

        int ind = 0;
        if (current.data != null) {

            newArr[ind] = current.data;
        } else {
            return new Object[]{};
        }

        ind += 1;
        while (current.next != null) {

            current = current.next;
            if (current.data != null) {
                newArr[ind] = current.data;
            }

            ind += 1;
        }

        return newArr;
    }

    @Override
    public String toString() {
//        toArray();
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
        if (checkHead()) {
            Node start = new Node(e);
            return new ImmutableLinkedList(start);
        } else {
            ImmutableLinkedList newArr = ImmutableLinkedList.copyOf(this);
            Node prevHead = head;
            newArr.head = new Node(e);
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

    private static void temp() {
        throw new IndexOutOfBoundsException();
    }

    private boolean checkHead() {
        return head.data == null;
    }

    private boolean checkIndex(int index) {
        return index >= size();
    }


}
