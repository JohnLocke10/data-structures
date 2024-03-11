package com.tolik.datastructures.stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    private ArrayStack arrayStack;

    @BeforeEach
    public void setUp() {
        arrayStack = new ArrayStack();
    }

    @Test
    @DisplayName("Test push and pop work correctly and change size")
    public void testPushAndPopWorkCorrectlyAndChangeSize() {
        arrayStack.push("A");
        arrayStack.push("B");
        assertEquals(2, arrayStack.size());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test push over initial capacity and pop work correctly and change size")
    public void testPushOverInitialCapacityAndPopWorkCorrectlyAndChangeSize() {
        ArrayStack arrayStackWithCapacity = new ArrayStack(2);
        arrayStackWithCapacity.push("A");
        arrayStackWithCapacity.push("B");
        arrayStackWithCapacity.push("C");
        assertEquals(3, arrayStackWithCapacity.size());
        assertEquals("C", arrayStackWithCapacity.pop());
        assertEquals("B", arrayStackWithCapacity.pop());
        assertEquals("A", arrayStackWithCapacity.pop());
        assertEquals(0, arrayStackWithCapacity.size());
        assertTrue(arrayStackWithCapacity.isEmpty());
    }

    @Test
    @DisplayName("Test push and peek")
    public void testPushAndPeek() {
        arrayStack.push("A");
        arrayStack.push("B");
        assertEquals(2, arrayStack.size());
        assertEquals("B", arrayStack.peek());
        assertEquals("B", arrayStack.peek());
        assertEquals(2, arrayStack.size());
    }

    @Test
    @DisplayName("Test isEmpty returns true on new stack")
    public void testIsEmptyReturnTrueOnNewStack() {
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test isEmpty returns false on stack with data")
    public void testisEmptyReturnFalseOnStackWithData() {
        arrayStack.push("ABC");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test isEmpty returns true on stack after clear")
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test contains return true")
    public void testContainsReturnTrue() {
        arrayStack.push("A");
        assertTrue(arrayStack.contains("A"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        arrayStack.push(null);
        assertTrue(arrayStack.contains(null));
    }

    @Test
    @DisplayName("Test contains return false")
    public void testContainsReturnFalse() {
        arrayStack.push("A");
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    @DisplayName("Test contains return false on empty stack")
    public void testContainsReturnFalseOnEmptyStack() {
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    @DisplayName("Test throw IllegalStateException when pop on empty stack")
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
        assertEquals("The stack is empty!", actualException.getMessage());
    }

    @Test
    @DisplayName("Test throw IllegalStateException when peek on empty stack")
    public void testThrowIllegalStateExceptionWhenPeekOnEmptyStack() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            arrayStack.peek();
        });
        assertEquals("The stack is empty!", actualException.getMessage());
    }

    @Test
    @DisplayName("check iterator adds letters in correct order")
    public void checkIteratorAddsLettersInCorrectOrder() {
        arrayStack.push("H");
        arrayStack.push("E");
        arrayStack.push("L");
        arrayStack.push("L");
        arrayStack.push("O");
        String actualString = "";
        for (Object object : arrayStack) {
            actualString += object;
        }
        assertEquals("HELLO", actualString);
    }

    @Test
    @DisplayName("check toString adds letters in correct order")
    public void checkToStringAddsLettersInCorrectOrder() {
        arrayStack.push("H");
        arrayStack.push("O");
        arrayStack.push("L");
        arrayStack.push("A");
        String actualString = arrayStack.toString();
        assertEquals("[H,O,L,A]", actualString);
    }


}
