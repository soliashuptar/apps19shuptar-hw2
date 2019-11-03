package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public class ImmutableArrayList implements ImmutableList {

    private Object[] ImmArr;
    private int size;

    public void isValid(int index) throws IndexOutOfBoundsException {
        if (size == 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public ImmutableArrayList(){
        ImmArr = new Object[1];
        size = 0;
    }

    public ImmutableArrayList(Object[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        ImmArr = Arrays.copyOf(arr, arr.length);
        size = arr.length;

    }

    @Override
    public ImmutableList add(Object e) {
        size += 1;
        Object[] newArr = Arrays.copyOf(ImmArr, size);
        newArr[size - 1] = e;
//        ImmutableArrayList[]
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        isValid(index);
        size += 1;
        Object[] arr = new Object[size];
        int ind = 0;
        for (int i = 0; i < size; i++) {
            if ( i == index) {
                arr[i] = null;
            } else {
                arr[i] = ImmArr[ind];
                ind += 1;
            }
        }
        arr[index] = e;
        return new ImmutableArrayList(arr);
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        if (size == 0 && c.length == 0) {
            return new ImmutableArrayList();
        }
        Object[] newArr = Arrays.copyOf(ImmArr, size + c.length);
        int ind = 0;
        for (int i = size; i < newArr.length; i ++) {
            newArr[i] = c[ind];
            ind += 1;
        }

        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        isValid(index);
        Object[] arr = new Object[size + c.length];
        int indOfSourceArr = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                System.arraycopy(c, 0, arr, i, c.length);
                i += c.length - 1;
            } else {
                arr[i] = ImmArr[indOfSourceArr];
                indOfSourceArr += 1;
            }
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public Object get(int index) {
        isValid(index);
//        if (size == 0 || index >= size) {
//            throw new IndexOutOfBoundsException();
//        }


        return ImmArr[index];
    }

    @Override
    public ImmutableList remove(int index) {
        isValid(index);

        Object[] newArr = new Object[size - 1];
        int ind = 0;
        for (int i = 0; i < size; i ++) {
            if (i != index) {
                newArr[ind] = ImmArr[i];
                ind += 1;
            }
        }
//        System.out.println("ImmArr" + Integer.toString(index) + Integer.toString(index));
//        System.arraycopy(ImmArr, 0, newArr, 0, index);
//        System.arraycopy(ImmArr, index + 1, newArr, index + 1, size - index + 1);
        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        isValid(index);

        Object[] newArr = Arrays.copyOf(ImmArr, size);
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i ++) {
            if (ImmArr[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        if (size == 0) {
            return size;
        }
        return size - 1;
    }

    @Override
    public ImmutableList clear() {
        return new ImmutableArrayList();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr = Arrays.copyOf(ImmArr, size);
        return newArr;
    }
}
