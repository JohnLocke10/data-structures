package com.tolik.datastructures.queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static com.tolik.datastructures.queue.AbstractQueue.QUEUE_IS_EMPTY;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractQueueTest {
    Queue<String> queue;

    abstract Queue<String> getQueue();

    @BeforeEach
    public void setUp() {
        queue = getQueue();
    }

    @Test
    @DisplayName("Check enqueue, dequeue, and change size work correctly")
    public void checkEnqueueDequeueAndChangeSizeWorkCorrectly() {
        queue.enqueue("A");
        queue.enqueue("B");
        assertEquals(2, queue.size());
        assertEquals("A", queue.dequeue());
        assertEquals("B", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Check push and peek")
    public void checkPushAndPeek() {
        queue.enqueue("C");
        queue.enqueue("D");
        assertEquals(2, queue.size());
        assertEquals("C", queue.peek());
        assertEquals("C", queue.peek());
        assertEquals(2, queue.size());
    }

    @Test
    @DisplayName("Check isEmpty returns true on empty queue")
    public void checkIsEmptyReturnTrueOnEmptyQueue() {
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Check isEmpty works correctly after peek and dequeue")
    public void checkIsEmptyWorksCorrectlyAfterPeekAndDequeue() {
        queue.enqueue("K");
        assertFalse(queue.isEmpty());
        queue.peek();
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Check throw IllegalStateException when peek on empty queue")
    public void checkThrowIllegalStateExceptionWhenPeekOnEmptyQueue() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            queue.peek();
        });
        assertEquals(QUEUE_IS_EMPTY, actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw IllegalStateException when dequeue on empty queue")
    public void checkThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            queue.dequeue();
        });
        assertEquals(QUEUE_IS_EMPTY, actualException.getMessage());
    }

    @Test
    @DisplayName("Check contains returns false on empty queue")
    public void checkContainsReturnFalseOnEmptyQueue() {
        assertFalse(queue.contains("L"));
    }

    @Test
    @DisplayName("Check contains works correctly after peek and dequeue")
    public void checkContainsWorksCorrectlyAfterPeekAndDequeue() {
        queue.enqueue("M");
        assertTrue(queue.contains("M"));
        queue.peek();
        assertTrue(queue.contains("M"));
        queue.dequeue();
        assertFalse(queue.contains("M"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        queue.enqueue(null);
        assertTrue(queue.contains(null));
    }

    @Test
    @DisplayName("Check contains returns false when there is no such element")
    public void checkContainsReturnFalseWhenThereIsNoSuchElement() {
        queue.enqueue("A");
        assertFalse(queue.contains("N"));
    }

    @Test
    @DisplayName("Check clear after enqueue")
    public void checkClearAfterEnqueue() {
        queue.enqueue("P");
        queue.enqueue("R");
        assertEquals(2, queue.size());
        queue.clear();
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("check iterator adds letters in correct order")
    public void checkIteratorAddsLettersInCorrectOrder() {
        queue.enqueue("H");
        queue.enqueue("E");
        queue.enqueue("L");
        queue.enqueue("L");
        queue.enqueue("O");
        String actualString = "";
        for (Object object : queue) {
            actualString += object;
        }
        assertEquals("HELLO", actualString);
    }

    @Test
    @DisplayName("check toString adds letters in correct order")
    public void checkToStringAddsLettersInCorrectOrder() {
        queue.enqueue("H");
        queue.enqueue("O");
        queue.enqueue("L");
        queue.enqueue("A");
        String actualString = queue.toString();
        assertEquals("[H,O,L,A]", actualString);
    }

    @Test
    @DisplayName("check iterator remove all elements in non empty queue")
    public void checkIteratorRemoveAllElementsInNonEmptyQueue() {
        queue.enqueue("J");
        queue.enqueue("B");
        queue.enqueue("L");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("check iterator remove the only one element")
    public void checkIteratorRemoveTheOnlyOneElement() {
        queue.enqueue("I");
        assertEquals(1, queue.size());
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertFalse(queue.contains("I"));
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("check iterator remove throws exception when no next method called")
    public void checkIteratorRemoveThrowsExceptionWhenNoNextMethodCalled() {
        queue.enqueue("R");
        assertEquals(1, queue.size());
        Iterator<String> iterator = queue.iterator();
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            iterator.remove();
        });
        assertEquals("Invalid using of remove method", actualException.getMessage());
    }

    @Test
    @DisplayName("check iterator remove throws exception when call for the same element")
    public void checkIteratorRemoveThrowsExceptionWhenCallForTheSameElement() {
        queue.enqueue("S");
        assertEquals(1, queue.size());
        Iterator<String> iterator = queue.iterator();
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                iterator.remove();
            }
        });
        assertEquals("Invalid using of remove method", actualException.getMessage());
    }
}