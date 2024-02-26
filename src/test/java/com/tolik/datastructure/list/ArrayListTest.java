package com.tolik.datastructure.list;

import com.tolik.datastructures.List.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @Test
    @DisplayName("Check add value and remove it from the list")
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
    @DisplayName("Check add values by index and get these values")
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
    @DisplayName("Check add value between existing values and get by index")
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
    @DisplayName("Check throw exception when add to index bigger than size")
    public void checkThrowExceptionWhenAddToIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("J");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("K", 2);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when add to negative index")
    public void checkThrowExceptionWhenAddToNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("S");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.add("T", -1);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check remove value by positive index in the correct range")
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
    @DisplayName("Check throw exception when remove value by index bigger than size")
    public void checkThrowExceptionWhenRemoveValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("P");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    public void checkThrowExceptionWhenRemoveValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("R");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(-2);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when remove value by negative index")
    public void checkThrowExceptionGetValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("U");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.get(-2);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when get value by index bigger than size")
    public void checkThrowExceptionWhenGetValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("Y");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.remove(1);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check set to the valid range in array")
    public void checkSetToTheValidRangeInArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("E");
        assertEquals("E", arrayList.get(0));
        arrayList.set("X", 0);
        assertEquals("X", arrayList.get(0));
    }

    @Test
    @DisplayName("Check throw exception set value by negative index")
    public void checkThrowExceptionSetValueByNegativeIndex() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("B", -2);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when set value by index bigger than size")
    public void checkThrowExceptionWhenSetValueByIndexBiggerThanSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("C");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayList.set("D", 1);
        });
        assertEquals("Index should be a positive number less than array size",
                actualException.getMessage());
    }

    @Test
    @DisplayName("Check array is empty when clear after add")
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
    @DisplayName("Check array is not empty after add value")
    public void checkArrayIsNotEmptyAfterAddValue() {
        ArrayList arrayList = new ArrayList();
        assertTrue(arrayList.isEmpty());
        arrayList.add("S");
        assertFalse(arrayList.isEmpty());
    }

    @Test
    @DisplayName("Check contains returns true after add")
    public void checkContainsReturnTrueAfterAdd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("G");
        assertTrue(arrayList.contains("G"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        assertTrue(arrayList.contains(null));
    }

    @Test
    @DisplayName("Check contains after get and remove")
    public void checkContainsAfterGetAndRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("J");
        arrayList.get(0);
        assertTrue(arrayList.contains("J"));
        arrayList.remove(0);
        assertFalse(arrayList.contains("J"));
    }

    @Test
    @DisplayName("Check contains returns false on empty array")
    public void checkContainsReturnFalseOnEmptyArray() {
        ArrayList arrayList = new ArrayList();
        assertFalse(arrayList.contains("T"));
    }

    @Test
    @DisplayName("Check contains returns false after clear")
    public void checkContainsReturnFalseAfterClear() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("F");
        arrayList.clear();
        assertFalse(arrayList.contains("F"));
    }

    @Test
    @DisplayName("Check index of existing value")
    public void checkIndexOfExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("L");
        arrayList.add("M");
        arrayList.add("L");
        assertEquals(1, arrayList.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of existing value")
    public void checkLastIndexOfExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("W");
        arrayList.add("I");
        arrayList.add("W");
        arrayList.add("O");
        assertEquals(2, arrayList.lastIndexOf("W"));
    }

    @Test
    @DisplayName("Check index of for non-existing value")
    public void checkIndexOfForNonExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("K");
        assertEquals(-1, arrayList.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of for non-existing value")
    public void checkLastIndexOfForNonExistingValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("C");
        assertEquals(-1, arrayList.indexOf("P"));
    }

    @Test
    @DisplayName("Check index of and last index of for empty array")
    public void checkIndexOfAndLastIndexOfForEmptyArray() {
        ArrayList arrayList = new ArrayList();
        assertEquals(-1, arrayList.indexOf("N"));
        assertEquals(-1, arrayList.lastIndexOf("N"));
    }

    @Test
    @DisplayName("Check add over initial capacity")
    public void checkAddOverInitialCapacity() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add("X");
        arrayList.add("Y");
        assertEquals(2, arrayList.size());
        assertEquals("X", arrayList.get(0));
        assertEquals("Y", arrayList.get(1));
    }

}
