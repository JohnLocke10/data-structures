package com.tolik.datastructure.stack;

import com.tolik.datastructures.queue.ArrayQueue;
import com.tolik.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayStackTest {

    @Test
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
    public void testIsEmptyReturnTrueOnNewStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testisEmptyReturnFalseOnStackWithData() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("ABC");
        assertFalse(arrayStack.isEmpty());
    }

    @Test
    public void testIsEmptyReturnTrueOnStackAfterClear() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        arrayStack.push("B");
        arrayStack.clear();
        assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        assertTrue(arrayStack.contains("A"));
    }

    @Test
    public void checkContainsWorksCorrectlyWithNullValue() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push(null);
        assertTrue(arrayStack.contains(null));
    }

    @Test
    public void testContainsReturnFalse() {
        ArrayStack arrayStack = new ArrayStack();
        arrayStack.push("A");
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    public void testContainsReturnFalseOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertFalse(arrayStack.contains("G"));
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPopOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertThrows(IllegalStateException.class, () -> {
            arrayStack.pop();
        });
    }

    @Test
    public void testThrowIllegalStateExceptionWhenPeekOnEmptyStack() {
        ArrayStack arrayStack = new ArrayStack();
        assertThrows(IllegalStateException.class, () -> {
            arrayStack.peek();
        });
    }
}
