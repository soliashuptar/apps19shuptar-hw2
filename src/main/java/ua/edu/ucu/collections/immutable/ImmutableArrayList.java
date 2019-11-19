package ua.edu.ucu.collections.immutable;

public final class ImmutableArrayList implements ImmutableList {

    final private Object[] immArr;
    private int size;

    public ImmutableArrayList() {
        immArr = new Object[0];
        size = 0;
    }


    public ImmutableArrayList(Object[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }
        immArr = java.util.Arrays.copyOf(arr, arr.length);
        size = arr.length;

    }

    @Override
    public ImmutableArrayList add(Object e) {
        return addAll(size, new Object[]{e});
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        isValid(index);
        Object[] arr = new Object[size + c.length];
        
        int indOfSourceArr = 0;
        for (int i = 0; i < arr.length; ) {
            if (i == index) {
                System.arraycopy(c, 0, arr, i, c.length);
                i += c.length;
            } else {
                arr[i] = immArr[indOfSourceArr];
                indOfSourceArr += 1;
                i += 1;
            }
        }
        return new ImmutableArrayList(arr);
    }

    @Override
    public Object get(int index) {
        isValid(index);

        return immArr[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        isValid(index);

        Object[] newArr = new Object[size - 1];
        int ind = 0;

        for (int i = 0; i < size; i++) {
            if (i != index) {
                newArr[ind] = immArr[i];
                ind += 1;
            }
        }

        return new ImmutableArrayList(newArr);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        isValid(index);

        Object[] newArr = java.util.Arrays.copyOf(immArr, size);
        newArr[index] = e;
        return new ImmutableArrayList(newArr);
    }

    @Override
    public int indexOf(Object e) {

        for (int i = 0; i < size; i++) {
            if (immArr[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableArrayList clear() {
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
        Object[] newArr = java.util.Arrays.copyOf(immArr, size);
        return newArr;
    }

    @Override
    public String toString() {
        Object[] newArr = java.util.Arrays.copyOf(immArr, size);
        if (size == 0) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            s.append(newArr[i].toString()).append(", ");
        }
        s.append(newArr[size - 1].toString());
        return s.toString();
    }

    private void isValid(int index) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException();
        }
        if(index < 0){
            throw new IllegalArgumentException();
        }
    }
}
