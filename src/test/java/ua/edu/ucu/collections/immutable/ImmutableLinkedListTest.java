package ua.edu.ucu.collections.immutable;

import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {

    @Test
    public void testAdd() {

        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList lastArr = LinkedLst.add(8);
        Object[] expArray = new Object[] {8};
        assertArrayEquals(expArray, lastArr.toArray());

    }

    @Test
    public void testAddTwoValues() {
//given
        ImmutableList LinkedLst = new ImmutableLinkedList();
      //when
        ImmutableList newArr = LinkedLst.add(8);
        ImmutableList lastArr = newArr.add(19);
        Object[] expArray = new Object[] {8, 19};
//        Object [] arr = LinkedLst.toArray();
//        System.out.println(arr);
        //expect
        assertArrayEquals(expArray, lastArr.toArray());

    }

    @Test
    public void testAddTwoValuesImmutability() {

        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList newLst = LinkedLst.add(8);
//        ImmutableList new2 = LinkedLst.add(19);
        Object[] expArray = new Object[] {8};
        assertNotEquals(LinkedLst, newLst);

    }

    @Test
    public void testAddIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList newLst = LinkedLst.add(8);
        ImmutableList new2 = newLst.add(19);
        Object[] expArray = new Object[] {8, 7, 19};
        ImmutableList finalArr = new2.add(1, 7);
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexError() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList newLst = LinkedLst.add(8);
        ImmutableList new2 = newLst.add(19);
        ImmutableList finalArr = new2.add(3, 7);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddIndexErrorEmptyList() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
//        ImmutableList newLst = LinkedLst.add(8);
//        ImmutableList new2 = newLst.add(19);
        ImmutableList finalArr = LinkedLst.add(0, 7);
    }

    @Test
    public void testAddIndexZeroIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.add(0, 7);
        Object[] expArray = new Object[] {7, 8, 19, 38};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testAddIndexLastIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.add(2, 7);
        Object[] expArray = new Object[] {8, 19, 7, 38};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testAddAll() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        Object[] arrToADd = new Object[] {9, 5, 83};
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.addAll(arrToADd);
        Object[] expArray = new Object[] {8, 19, 38, 9, 5, 83};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testAddAllToEmpty() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        Object[] arrToADd = new Object[] {9, 5, 83};
        ImmutableList finalArr = LinkedLst.addAll(arrToADd);
        Object[] expArray = new Object[] {9, 5, 83};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testAddAllIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        Object[] arrToADd = new Object[] {9, 5, 83};
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.addAll(1, arrToADd);
        Object[] expArray = new Object[] {8, 9, 5, 83, 19, 38};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddAllIndexToZeroIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        Object[] arrToADd = new Object[] {9, 5, 83};
//        ImmutableList new1 = LinkedLst.add(8);
//        ImmutableList new2 = new1.add(19);
//        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = LinkedLst.addAll(0, arrToADd);
//        Object[] expArray = new Object[] {8, 9, 5, 83, 19, 38};
//        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testGet() {

        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        Object realValue = new3.get(1);
        Object expValue = 19;
        assertEquals(expValue, realValue);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexError() {

        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        Object realValue = new3.get(3);
//        Object expValue = 19;
//        assertEquals(expValue, realValue);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetIndexErrorEmptyList() {

        ImmutableList LinkedLst = new ImmutableLinkedList();
        Object realValue = LinkedLst.get(3);

    }

    @Test
    public void testSet() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.set(1, 89);
        Object[] expArray = new Object[] {8, 89, 38};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testSetZeroIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.set(0, 89);
        Object[] expArray = new Object[] {89, 19, 38};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testRemove() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.remove(1);
        Object[] expArray = new Object[] {8, 38};
        assertArrayEquals(expArray, finalArr.toArray());

    }

    @Test
    public void testRemoveLastIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.remove(2);
        Object[] expArray = new Object[]{8, 19};
        assertArrayEquals(expArray, finalArr.toArray());
    }

    @Test
    public void testRemoveZeroIndex() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        ImmutableList finalArr = new3.remove(0);
        Object[] expArray = new Object[] {19, 38};
        assertArrayEquals(expArray, finalArr.toArray());

    }

    @Test
    public void testIndexOf() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        int expValue = 1;
        assertEquals(expValue, new3.indexOf(19));

    }

    @Test
    public void testIndexOfFirstEl() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        int expValue = 0;
        assertEquals(expValue, new3.indexOf(8));

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOfEmptyLinkedList() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        int realValue = LinkedLst.indexOf(8);
    }

    @Test
    public void testClear() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        Object[] expValue = {};
        assertArrayEquals(expValue, new3.clear().toArray());

    }

    @Test
    public void testisEmpty() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        ImmutableList new1 = LinkedLst.add(8);
        ImmutableList new2 = new1.add(19);
        ImmutableList new3 = new2.add(38);
        boolean expValue = false;
        assertEquals(expValue, new3.isEmpty());

    }

    @Test
    public void testisEmptyWithEmpty() {
        ImmutableList LinkedLst = new ImmutableLinkedList();
        boolean expValue = true;
        assertEquals(expValue, LinkedLst.isEmpty());

    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        Object[] expValue = {25};
        assertArrayEquals(expValue, Arr.addFirst(25).toArray());

    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        Object[] expValue = {5, 25};
        assertArrayEquals(expValue, Arr1.addLast(25).toArray());

    }

    @Test
    public void testGetFirst() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        Object expValue = 5;
        assertEquals(expValue, Arr1.getFirst());

    }

    @Test
    public void testGetFirstWithEmpty() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
//        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        Object expValue = null;
        assertEquals(expValue, Arr.getFirst());

    }

    @Test
    public void testGetLast() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        Object expValue = 5;
        assertEquals(expValue, Arr1.getLast());

    }

    @Test
    public void testGetLastMoreValues() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        ImmutableLinkedList Arr2 = Arr1.addLast(25);
        Object expValue =  25;
        assertEquals(expValue, Arr2.getLast());

    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        ImmutableLinkedList Arr2 = Arr1.addLast(25);
        Object[] expValue =  {25};
        assertArrayEquals(expValue, Arr2.removeFirst().toArray());

    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        ImmutableLinkedList Arr2 = Arr1.addLast(25);
        ImmutableLinkedList Arr3 = Arr2.addFirst(73);
        Object[] expValue =  {73, 5};
        assertArrayEquals(expValue, Arr3.removeLast().toArray());

    }

    @Test
    public void testAddFirstMoreValues() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        ImmutableLinkedList Arr2 = Arr1.addLast(25);
        ImmutableLinkedList Arr3 = Arr2.addFirst(73);
        Object[] expValue =  {73, 5, 25};
        assertArrayEquals(expValue, Arr3.toArray());


    }

    @Test
    public void testToString() {
        ImmutableLinkedList Arr = new ImmutableLinkedList();
        ImmutableLinkedList Arr1 = Arr.addFirst(5);
        ImmutableLinkedList Arr2 = Arr1.addLast(25);
        ImmutableLinkedList Arr3 = Arr2.addFirst(73);
        String expValue =  "73, 5, 25";
        assertEquals(expValue, Arr3.toString());


    }


























}
