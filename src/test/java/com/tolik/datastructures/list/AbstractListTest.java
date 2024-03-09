package com.tolik.datastructures.list;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractListTest {

    private List list;

    abstract List getList();

    @BeforeEach
    public void setUp() {
        list = getList();
    }

    @Test
    @DisplayName("Check add value and remove it from the list")
    public void checkAddValueAndRemoveItFromTheList() {
        assertEquals(0, list.size());
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        assertEquals(4, list.size());
        assertEquals("C", list.remove(2));
        assertEquals(3, list.size());
        assertEquals("D", list.remove(2));
        assertEquals(2, list.size());
        assertEquals("A", list.remove(0));
        assertEquals(1, list.size());
        assertEquals("B", list.get(0));
        assertEquals("B", list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Check add values by index and get these values")
    public void checkAddValuesByIndexAndGetTheseValues() {
        assertEquals(0, list.size());
        list.add("C", 0);
        list.add("D", 1);
        assertEquals(2, list.size());
        assertEquals("C", list.get(0));
        assertEquals("D", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    @DisplayName("Check add value between existing values and get by index")
    public void checkAddValueBetweenExistingValuesAndGetByIndex() {
        assertEquals(0, list.size());
        list.add("I");
        list.add("F");
        assertEquals(2, list.size());
        list.add("G", 1);
        assertEquals(3, list.size());
        assertEquals("I", list.get(0));
        assertEquals("G", list.get(1));
        assertEquals("F", list.get(2));
    }

    @Test
    @DisplayName("Check throw exception when add to index bigger than size")
    public void checkThrowExceptionWhenAddToIndexBiggerThanSize() {
        list.add("J");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("K", 2);
        });
        assertEquals("Index should be in range from 0(inclusive) till list.size(exclusive)!" +
                " List size: 1. Actual index: 2", actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when add to negative index")
    public void checkThrowExceptionWhenAddToNegativeIndex() {
        list.add("S");
        int indexToAdd = -1;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add("T", indexToAdd);
        });
        assertEquals("Index should be in range from 0(inclusive) till list.size(exclusive)!" +
                " List size: 1. Actual index: -1", actualException.getMessage());
    }

    @Test
    @DisplayName("Check remove value by positive index in the correct range")
    public void checkRemoveValueByPositiveIndexInTheCorrectRange() {
        list.add("M");
        list.add("N");
        list.add("O");
        assertEquals(3, list.size());
        assertEquals("N", list.remove(1));
        assertEquals(2, list.size());
        assertEquals("M", list.get(0));
        assertEquals("O", list.get(1));
    }

    @Test
    @DisplayName("Check throw exception when remove value by index bigger than right bound")
    public void checkThrowExceptionWhenRemoveValueByIndexBiggerThanRightBound() {
        list.add("P");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(1);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: 1", actualException.getMessage());
    }

    @Test
    public void checkThrowExceptionWhenRemoveValueByNegativeIndex() {
        list.add("R");
        int indexToRemove = -2;
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.remove(indexToRemove);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: -2", actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when remove value by negative index")
    public void checkThrowExceptionGetValueByNegativeIndex() {
        list.add("U");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(-2);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: -2", actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when get value by index bigger than size")
    public void checkThrowExceptionWhenGetValueByIndexBiggerThanSize() {
        list.add("Y");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(1);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: 1", actualException.getMessage());
    }

    @Test
    @DisplayName("Check returned and updated value when set to the valid range in array")
    public void checkReturnedAndUpdatedValueWhenSetToTheValidRangeInArray() {
        list.add("O");
        list.add("E");
        list.add("P");
        assertEquals("E", list.get(1));
        Object actualOldValue = list.set("X", 1);
        assertEquals("E", actualOldValue);
        assertEquals("X", list.get(1));
    }

    @Test
    @DisplayName("Check returned and updated value when set to zero index")
    public void checkReturnedAndUpdatedValueWhenSetToZeroIndex() {
        list.add("G");
        list.add("J");
        assertEquals("G", list.get(0));
        Object actualOldValue = list.set("Y", 0);
        assertEquals("G", actualOldValue);
        assertEquals("Y", list.get(0));
    }

    @Test
    @DisplayName("Check returned and updated value when set to the end of list")
    public void checkReturnedAndUpdatedValueWhenSetToTheEndOfList() {
        list.add("L");
        list.add("M");
        assertEquals("M", list.get(1));
        Object actualOldValue = list.set("U", 1);
        assertEquals("M", actualOldValue);
        assertEquals("U", list.get(1));
    }

    @Test
    @DisplayName("Check throw exception set value by negative index")
    public void checkThrowExceptionSetValueByNegativeIndex() {
        list.add("A");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("B", -2);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: -2", actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw exception when set value by index bigger than size")
    public void checkThrowExceptionWhenSetValueByIndexBiggerThanSize() {
        list.add("C");
        IndexOutOfBoundsException actualException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.set("D", 1);
        });
        assertEquals("Index should be from 0(inclusive) till last right value index(exclusive)." +
                " Right index: 0 .Actual index: 1", actualException.getMessage());
    }

    @Test
    @DisplayName("Check array is empty when clear after add")
    public void checkArrayIsEmptyWhenClearAfterAdd() {
        list.add("P");
        list.add("R");
        assertEquals(2, list.size());
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Check array is not empty after add value")
    public void checkArrayIsNotEmptyAfterAddValue() {
        assertTrue(list.isEmpty());
        list.add("S");
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Check contains returns true after add")
    public void checkContainsReturnTrueAfterAdd() {
        list.add("G");
        assertTrue(list.contains("G"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        list.add(null);
        assertTrue(list.contains(null));
    }

    @Test
    @DisplayName("Check contains after get and remove")
    public void checkContainsAfterGetAndRemove() {
        list.add("J");
        list.get(0);
        assertTrue(list.contains("J"));
        assertEquals("J", list.remove(0));
        assertFalse(list.contains("J"));
    }

    @Test
    @DisplayName("Check contains returns false on empty array")
    public void checkContainsReturnFalseOnEmptyArray() {
        assertFalse(list.contains("T"));
    }

    @Test
    @DisplayName("Check contains returns false after clear")
    public void checkContainsReturnFalseAfterClear() {
        list.add("F");
        list.clear();
        assertFalse(list.contains("F"));
    }

    @Test
    @DisplayName("Check index of existing value")
    public void checkIndexOfExistingValue() {
        list.add("A");
        list.add("L");
        list.add("M");
        list.add("L");
        assertEquals(1, list.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of existing value")
    public void checkLastIndexOfExistingValue() {
        list.add("W");
        list.add("I");
        list.add("W");
        list.add("O");
        assertEquals(2, list.lastIndexOf("W"));
    }

    @Test
    @DisplayName("Check last index of for zero index")
    public void checkLastIndexOfForZeroIndex() {
        list.add("Zero");
        list.add("P");
        list.add("R");
        list.add("S");
        assertEquals(0, list.lastIndexOf("Zero"));
    }

    @Test
    @DisplayName("Check index of for non-existing value")
    public void checkIndexOfForNonExistingValue() {
        list.add("K");
        assertEquals(-1, list.indexOf("L"));
    }

    @Test
    @DisplayName("Check last index of for non-existing value")
    public void checkLastIndexOfForNonExistingValue() {
        list.add("C");
        assertEquals(-1, list.indexOf("P"));
    }

    @Test
    @DisplayName("Check index of and last index of for empty array")
    public void checkIndexOfAndLastIndexOfForEmptyArray() {
        assertEquals(-1, list.indexOf("N"));
        assertEquals(-1, list.lastIndexOf("N"));
    }
}
