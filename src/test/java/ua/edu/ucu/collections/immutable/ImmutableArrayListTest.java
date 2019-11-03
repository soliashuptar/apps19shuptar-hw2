package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    @Test
    public void testAddNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.add(5);
        Object[] expArr = new Object[] {5};
        assertArrayEquals(FinalArr.toArray(), expArr);

    }

    @Test
    public void testAdd() {
        Object[] arr = {1, 2, 7, 8, 9, 0};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(89);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, 0, 89};
        assertArrayEquals(FinalArr.toArray(), expArr);

    }

    @Test
    public void testAddTypes() {
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.add(5);
//        Object[] expArr = new Object[] {5};
        assertNotEquals(immArr, FinalArr);

    }

    @Test
    public void testAddImmutability() {
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.add(5);
//        Object[] expArr = new Object[] {5};
        assertNotEquals(immArr.toArray(), FinalArr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        ImmutableList FinalArr = immArr.add(0, 5);
    }

    @Test
    public void testAddIndexWithArguments() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(0, 89);
        Object[] expArr = new Object[] {89, 1, 2, 7, 8, 9, -78};
        assertArrayEquals(FinalArr.toArray(), expArr);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexWithArgumentsLargeIndex() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(6, 89);
    }

    @Test
    public void testAddIndexImmutability() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.add(0, 89);
        Object[] expArr = new Object[] {89, 1, 2, 7, 8, 9, -78};
//        Object[] expArr = new Object[] {5};
        assertNotEquals(immArr.toArray(), FinalArr.toArray());
    }

    @Test
    public void testAddAllNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList FinalArr = immArr.addAll(arr);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test
    public void testAddAllWithArguments() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object[] arrToAdd = {63, 0};
        ImmutableList FinalArr = immArr.addAll(arrToAdd);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, -78, 63, 0};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test
    public void testAddAllWithEmptyToAdd() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object[] arrToAdd = {};
        ImmutableList FinalArr = immArr.addAll(arrToAdd);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList FinalArr = immArr.addAll(0, arr);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexNoArgumentsLargeIndex() {
        ImmutableList immArr = new ImmutableArrayList();
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList FinalArr = immArr.addAll(1, arr);
        Object[] expArr = new Object[] {1, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test()
    public void testAddAllEmptyToEmpty() {
        ImmutableList immArr = new ImmutableArrayList();
        Object[] arr = {};
        ImmutableList FinalArr = immArr.addAll(arr);
        Object[] expArr = new Object[] {};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexEmptyToEmpty() {
        ImmutableList immArr = new ImmutableArrayList();
        Object[] arr = {};
        ImmutableList FinalArr = immArr.addAll(0, arr);
        Object[] expArr = new Object[] {};
        assertArrayEquals(expArr, FinalArr.toArray());

    }


    @Test
    public void testAddAllIndexWithArguments() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object[] arrToAdd = {63, 0};
        ImmutableList FinalArr = immArr.addAll(1, arrToAdd);
        Object[] expArr = new Object[] {1, 63, 0, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexWithArgumentsLargeIndex() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object[] arrToAdd = {63, 0};
        ImmutableList FinalArr = immArr.addAll(6, arrToAdd);
        Object[] expArr = new Object[] {1, 63, 0, 2, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test
    public void testGet() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object realValue = immArr.get(2);
        Object expValue = 7;
        assertEquals(expValue, realValue);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        Object realValue = immArr.get(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetLargeIndex() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        Object realValue = immArr.get(8);
    }

    @Test
    public void testRemove() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.remove(1);
        Object[] expArr = new Object[] {1, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveLargeIndex() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.remove(10);

    }

    @Test
    public void testSet() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.set(1, 52);
        Object[] expArr = new Object[] {1, 52, 7, 8, 9, -78};
        assertArrayEquals(expArr, FinalArr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetLargeIndex() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList FinalArr = immArr.set(52, 52);
    }

    @Test
    public void testIndexOf() {
        Object[] arr = {1, 2, 7, 8, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        int realValue = immArr.indexOf(7);
        int expValue = 2;
        assertEquals(expValue, realValue);

    }
    @Test
    public void testIndexOfSameValues() {
        Object[] arr = {1, 2, 7, 7, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        int realValue = immArr.indexOf(7);
        int expValue = 2;
        assertEquals(expValue, realValue);

    }

    @Test
    public void testIndexOfNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        int realValue = immArr.indexOf(7);
        int expValue = -1;
        assertEquals(expValue, realValue);

    }


    @Test
    public void testIndexOfNotFound() {
        Object[] arr = {1, 2, 7, 7, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        int realValue = immArr.indexOf(8);
        int expValue = -1;
        assertEquals(expValue, realValue);
    }

    @Test
    public void testSize() {
        Object[] arr = {1, 2, 7, 7, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        int realValue = immArr.size();
        int expValue = 5;
        assertEquals(expValue, realValue);
    }

    @Test
    public void testSizeNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        int realValue = immArr.size();
        int expValue = 0;
        assertEquals(expValue, realValue);
    }

    @Test
    public void testClear() {
        Object[] arr = {1, 2, 7, 7, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        ImmutableList realValue = immArr.clear();
        ImmutableList expValue = new ImmutableArrayList();
        assertArrayEquals(expValue.toArray(), realValue.toArray());

    }

    @Test
    public void testIsEmpty() {
        Object[] arr = {1, 2, 7, 7, 9, -78};
        ImmutableList immArr = new ImmutableArrayList(arr);
        boolean realValue = immArr.isEmpty();
        boolean expValue = false;
        assertEquals(expValue, realValue);

    }

    @Test
    public void testIsEmptyNoArguments() {
        ImmutableList immArr = new ImmutableArrayList();
        boolean realValue = immArr.isEmpty();
        boolean expValue = true;
        assertEquals(expValue, realValue);
    }

    @Test
    public void testToString() {
        Object[] arr = {1, 2, 7};
        ImmutableList immArr = new ImmutableArrayList(arr);
        String expValue = "1, 2, 7";
        assertEquals(expValue, immArr.toString());
    }




















}
