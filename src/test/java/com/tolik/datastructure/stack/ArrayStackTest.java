package com.tolik.datastructure.stack;

import com.tolik.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
    @DisplayName("Test push and pop work correctly and change size")
    public void testPushAndPopWorkCorrectlyAndChangeSize() {
        ArrayStack arrayStack = new ArrayStack();
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
        ArrayStack arrayStack = new ArrayStack(2);
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.push("C");
        assertEquals(3, arrayStack.size());
        assertEquals("C", arrayStack.pop());
        assertEquals("B", arrayStack.pop());
        assertEquals("A", arrayStack.pop());
        assertEquals(0, arrayStack.size());
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test push and peek")
    public void testPushAndPeek() {
        ArrayStack arrayStack = new ArrayStack();
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
        ArrayStack arrayStack = new ArrayStack();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test isEmpty returns false on stack with data")
    public void testisEmptyReturnFalseOnStackWithData() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("ABC");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test isEmpty returns true on stack after clear")
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    @DisplayName("Test contains return true")
    public void testContainsReturnTrue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        assertTrue(arrayStack.contains("A"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(null);
        assertTrue(arrayStack.contains(null));
    }

    @Test
    @DisplayName("Test contains return false")
    public void testContainsReturnFalse() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    @DisplayName("Test contains return false")
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    @DisplayName("Test throw IllegalStateException when pop on empty stack")
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
        assertEquals("The stack is empty!", actualException.getMessage());
    }

    @Test
    @DisplayName("Test throw IllegalStateException when peek on empty stack")
    public void testThrowIllegalStateExceptionWhenPeekOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            arrayStack.peek();
        });
        assertEquals("The stack is empty!", actualException.getMessage());
    }
}
