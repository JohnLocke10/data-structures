package com.tolik.datastructure.list;

import com.tolik.datastructures.List.ArrayList;
import com.tolik.datastructures.List.LinkedList;
import com.tolik.datastructures.List.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    private List linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new LinkedList();
    }

    @Test
    @DisplayName("Check add value and remove it from the list")
    public void checkAddValueAndRemoveItFromTheList() {
        assertEquals(0, linkedList.size());
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        assertEquals(3, linkedList.size());
        linkedList.remove(2);
        assertEquals(2, linkedList.size());
        linkedList.remove(0);
        assertEquals(1, linkedList.size());
        assertEquals("B", linkedList.get(0));
        linkedList.remove(0);
        assertEquals(0, linkedList.size());
    }

    @Test
    @DisplayName("Check add values by index and get these values")
    public void checkAddValuesByIndexAndGetTheseValues() {
        assertEquals(0, linkedList.size());
        linkedList.add("C", 0);
        linkedList.add("D", 1);
        assertEquals(2, linkedList.size());
        assertEquals("C", linkedList.get(0));
        assertEquals("D", linkedList.get(1));
        assertEquals(2, linkedList.size());
    }

    @Test
    @DisplayName("Check add value between existing values and get by index")
    public void checkAddValueBetweenExistingValuesAndGetByIndex() {
        assertEquals(0, linkedList.size());
        linkedList.add("I");
        linkedList.add("F");
        assertEquals(2, linkedList.size());
        linkedList.add("G", 1);
        assertEquals(3, linkedList.size());
        assertEquals("I", linkedList.get(0));
        assertEquals("G", linkedList.get(1));
        assertEquals("F", linkedList.get(2));
    }

    @Test
    @DisplayName("Check throw exception when add to index bigger than size")
    public void checkThrowExceptionWhenAddToIndexBiggerThanSize() {
        linkedList.add("J");
        int indexToAdd = 2;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("K", 2);
        });
        String expectedException =
                String.format(
                        "Index should be a positive number less than array size! Array size: %d. Actual index: %d",
                        linkedList.size(), indexToAdd);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when add to negative index")
    public void checkThrowExceptionWhenAddToNegativeIndex() {
        linkedList.add("S");
        int indexToAdd = -1;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add("T", indexToAdd);
        });
        String expectedException =
                String.format(
                        "Index should be a positive number less than array size! Array size: %d. Actual index: %d",
                        linkedList.size(), indexToAdd);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check remove value by positive index in the correct range")
    public void checkRemoveValueByPositiveIndexInTheCorrectRange() {
        linkedList.add("M");
        linkedList.add("N");
        linkedList.add("O");
        assertEquals(3, linkedList.size());
        linkedList.remove(1);
        assertEquals(2, linkedList.size());
        assertEquals("M", linkedList.get(0));
        assertEquals("O", linkedList.get(1));
    }

    @Test
    @DisplayName("Check throw exception when remove value by index bigger than size")
    public void checkThrowExceptionWhenRemoveValueByIndexBiggerThanSize() {
        linkedList.add("P");
        int indexToRemove = 1;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(indexToRemove);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToRemove);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    public void checkThrowExceptionWhenRemoveValueByNegativeIndex() {
        linkedList.add("R");
        int indexToRemove = -2;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.remove(indexToRemove);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToRemove);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when remove value by negative index")
    public void checkThrowExceptionGetValueByNegativeIndex() {
        linkedList.add("U");
        int indexToGet = -2;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(indexToGet);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToGet);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when get value by index bigger than size")
    public void checkThrowExceptionWhenGetValueByIndexBiggerThanSize() {
        linkedList.add("Y");
        int indexToGet = 1;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(indexToGet);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToGet);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check set to the valid range in array")
    public void checkSetToTheValidRangeInArray() {
        linkedList.add("E");
        assertEquals("E", linkedList.get(0));
        linkedList.set("X", 0);
        assertEquals("X", linkedList.get(0));
    }

    @Test
    @DisplayName("Check throw exception set value by negative index")
    public void checkThrowExceptionSetValueByNegativeIndex() {
        linkedList.add("A");
        int indexToSet = -2;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.set("B", -2);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToSet);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when set value by index bigger than size")
    public void checkThrowExceptionWhenSetValueByIndexBiggerThanSize() {
        linkedList.add("C");
        int indexToSet = 1;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.set("D", 1);
        });
        String expectedException =
                String.format("Index should be a positive number less than last right value index. Right index: %d "
                        + ".Actual index: %d", linkedList.size() - 1, indexToSet);
        assertEquals(expectedException, actualException.getMessage());
    }

    @Test
    @DisplayName("Check array is empty when clear after add")
    public void checkArrayIsEmptyWhenClearAfterAdd() {
        linkedList.add("P");
        linkedList.add("R");
        assertEquals(2, linkedList.size());
        linkedList.clear();
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @Test
    @DisplayName("Check array is not empty after add value")
    public void checkArrayIsNotEmptyAfterAddValue() {
        assertTrue(linkedList.isEmpty());
        linkedList.add("S");
        assertFalse(linkedList.isEmpty());
    }

    @Test
    @DisplayName("Check contains returns true after add")
    public void checkContainsReturnTrueAfterAdd() {
        linkedList.add("G");
        assertTrue(linkedList.contains("G"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        linkedList.add(null);
        assertTrue(linkedList.contains(null));
    }

    @Test
    @DisplayName("Check contains after get and remove")
    public void checkContainsAfterGetAndRemove() {
        linkedList.add("J");
        linkedList.get(0);
        assertTrue(linkedList.contains("J"));
        linkedList.remove(0);
        assertFalse(linkedList.contains("J"));
    }

    @Test
    @DisplayName("Check contains returns false on empty array")
    public void checkContainsReturnFalseOnEmptyArray() {
        assertFalse(linkedList.contains("T"));
    }

    @Test
    @DisplayName("Check contains returns false after clear")
    public void checkContainsReturnFalseAfterClear() {
        linkedList.add("F");
        linkedList.clear();
        assertFalse(linkedList.contains("F"));
    }

    @Test
    @DisplayName("Check index of existing value")
    public void checkIndexOfExistingValue() {
        linkedList.add("A");
        linkedList.add("L");
        linkedList.add("M");
        linkedList.add("L");
        assertEquals(1, linkedList.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of existing value")
    public void checkLastIndexOfExistingValue() {
        linkedList.add("W");
        linkedList.add("I");
        linkedList.add("W");
        linkedList.add("O");
        assertEquals(2, linkedList.lastIndexOf("W"));
    }

    @Test
    @DisplayName("Check index of for non-existing value")
    public void checkIndexOfForNonExistingValue() {
        linkedList.add("K");
        assertEquals(-1, linkedList.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of for non-existing value")
    public void checkLastIndexOfForNonExistingValue() {
        linkedList.add("C");
        assertEquals(-1, linkedList.indexOf("P"));
    }

    @Test
    @DisplayName("Check index of and last index of for empty array")
    public void checkIndexOfAndLastIndexOfForEmptyArray() {
        assertEquals(-1, linkedList.indexOf("N"));
        assertEquals(-1, linkedList.lastIndexOf("N"));
    }
}
