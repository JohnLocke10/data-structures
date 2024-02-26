package com.tolik.datastructure.list;

import com.tolik.datastructures.List.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    public void checkAddValueAndRemoveItFromTheList() {
        ArrayList arrayList = new ArrayList();
        assertEquals(0, arrayList.size());
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        assertEquals(3, arrayList.size());
        arrayList.remove(2);
        assertEquals(2, arrayList.size());
        arrayList.remove(0);
        assertEquals(1, arrayList.size());
        assertEquals("B", arrayList.get(0));
        arrayList.remove(0);
        assertEquals(0, arrayList.size());
    }

    @Test
    public void checkAddValuesByIndexAndGetTheseValues() {
        ArrayList arrayList = new ArrayList();
        assertEquals(0, arrayList.size());
        arrayList.add("C", 0);
        arrayList.add("D", 1);
        assertEquals(2, arrayList.size());
        assertEquals("C", arrayList.get(0));
        assertEquals("D", arrayList.get(1));
        assertEquals(2, arrayList.size());
    }

    @Test
    public void checkAddValueBetweenExistingValuesAndGetByIndex() {
        ArrayList arrayList = new ArrayList();
        assertEquals(0, arrayList.size());
        arrayList.add("I");
        arrayList.add("F");
        assertEquals(2, arrayList.size());
        arrayList.add("G", 1);
        assertEquals(3, arrayList.size());
        assertEquals("I", arrayList.get(0));
        assertEquals("G", arrayList.get(1));
        assertEquals("F", arrayList.get(2));
    }

    @Test
    public void checkThrowExceptionWhenAddToIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("J");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("K", 2);
        });
    }

    @Test
    public void checkThrowExceptionWhenAddToNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("S");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("T", -1);
        });
    }

    @Test
    public void checkRemoveValueByPositiveIndexInTheCorrectRange() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("M");
        arrayList.add("N");
        arrayList.add("O");
        assertEquals(3, arrayList.size());
        arrayList.remove(1);
        assertEquals(2, arrayList.size());
        assertEquals("M", arrayList.get(0));
        assertEquals("O", arrayList.get(1));
    }

    @Test
    public void checkThrowExceptionWhenRemoveValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("P");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
        });
    }

    @Test
    public void checkThrowExceptionWhenRemoveValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("R");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-2);
        });
    }

    @Test
    public void checkThrowExceptionGetValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("U");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-2);
        });
    }

    @Test
    public void checkThrowExceptionWhenGetValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Y");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
        });
    }

    @Test
    public void checkSetToTheValidRangeInArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("E");
        assertEquals("E", arrayList.get(0));
        arrayList.set("X", 0);
        assertEquals("X", arrayList.get(0));
    }

    @Test
    public void checkThrowExceptionSetValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("B", -2);
        });
    }

    @Test
    public void checkThrowExceptionWhenSetValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("C");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("D", 1);
        });
    }

    @Test
    public void checkArrayIsEmptyWhenClearAfterAdd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("P");
        arrayList.add("R");
        assertEquals(2, arrayList.size());
        arrayList.clear();
        assertEquals(0, arrayList.size());
        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void checkArrayIsNotEmptyAfterAddValue() {
        ArrayList arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
        arrayList.add("S");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    public void checkContainsReturnTrueAfterAdd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("G");
        assertTrue(arrayList.contains("G"));
    }

    @Test
    public void checkContainsAfterGetAndRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("J");
        arrayList.get(0);
        assertTrue(arrayList.contains("J"));
        arrayList.remove(0);
        assertFalse(arrayList.contains("J"));
    }

    @Test
    public void checkContainsReturnFalseOnEmptyArray() {
        ArrayList arrayList = new ArrayList();
        assertFalse(arrayList.contains("T"));
    }

    @Test
    public void checkContainsReturnFalseAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("F");
        arrayList.clear();
        assertFalse(arrayList.contains("F"));
    }

    @Test
    public void checkIndexOfExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("L");
        arrayList.add("M");
        arrayList.add("L");
        assertEquals(1, arrayList.indexOf("L"));
    }

    @Test
    public void checkLastIndexOfExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("W");
        arrayList.add("I");
        arrayList.add("W");
        arrayList.add("O");
        assertEquals(2, arrayList.lastIndexOf("W"));
    }

    @Test
    public void checkIndexOfForNonExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("K");
        assertEquals(-1, arrayList.indexOf("L"));
    }

    @Test
    public void checkLastIndexOfForNonExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("C");
        assertEquals(-1, arrayList.indexOf("P"));
    }

    @Test
    public void checkIndexOfAndLastIndexOfForEmptyArray() {
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.indexOf("N"));
        assertEquals(-1, arrayList.lastIndexOf("N"));
    }

    @Test
    public void checkAddOverInitialCapacity() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("X");
        arrayList.add("Y");
        assertEquals(2, arrayList.size());
        assertEquals("X", arrayList.get(0));
        assertEquals("Y", arrayList.get(1));
    }

}
