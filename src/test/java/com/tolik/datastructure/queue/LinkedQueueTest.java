package com.tolik.datastructure.queue;

import com.tolik.datastructures.queue.LinkedQueue;
import com.tolik.datastructures.queue.Queue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedQueueTest {
    private Queue linkedQueue;

    @BeforeEach
    public void setUp() {
        linkedQueue = new LinkedQueue();
    }

    @Test
    @DisplayName("Check enqueue, dequeue, and change size work correctly")
    public void checkEnqueueDequeueAndChangeSizeWorkCorrectly() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B");
        assertEquals(2, linkedQueue.size());
        assertEquals("A", linkedQueue.dequeue());
        assertEquals("B", linkedQueue.dequeue());
        assertEquals(0, linkedQueue.size());
    }

    @Test
    @DisplayName("Check push and peek")
    public void checkPushAndPeek() {
        linkedQueue.enqueue("C");
        linkedQueue.enqueue("D");
        assertEquals(2, linkedQueue.size());
        assertEquals("C", linkedQueue.peek());
        assertEquals("C", linkedQueue.peek());
        assertEquals(2, linkedQueue.size());
    }

    @Test
    @DisplayName("Check isEmpty returns true on empty queue")
    public void checkIsEmptyReturnTrueOnEmptyQueue() {
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    @DisplayName("Check isEmpty works correctly after peek and dequeue")
    public void checkIsEmptyWorksCorrectlyAfterPeekAndDequeue() {
        linkedQueue.enqueue("K");
        assertFalse(linkedQueue.isEmpty());
        linkedQueue.peek();
        assertFalse(linkedQueue.isEmpty());
        linkedQueue.dequeue();
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    @DisplayName("Check throw IllegalStateException when peek on empty queue")
    public void checkThrowIllegalStateExceptionWhenPeekOnEmptyQueue() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            linkedQueue.peek();
        });
        assertEquals("The Queue is empty!", actualException.getMessage());
    }

    @Test
    @DisplayName("Check throw IllegalStateException when dequeue on empty queue")
    public void checkThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        IllegalStateException actualException = assertThrows(IllegalStateException.class, () -> {
            linkedQueue.dequeue();
        });
        assertEquals("The Queue is empty!", actualException.getMessage());
    }

    @Test
    @DisplayName("Check contains returns false on empty queue")
    public void checkContainsReturnFalseOnEmptyQueue() {
        assertFalse(linkedQueue.contains("L"));
    }

    @Test
    @DisplayName("Check contains works correctly after peek and dequeue")
    public void checkContainsWorksCorrectlyAfterPeekAndDequeue() {
        linkedQueue.enqueue("M");
        assertTrue(linkedQueue.contains("M"));
        linkedQueue.peek();
        assertTrue(linkedQueue.contains("M"));
        linkedQueue.dequeue();
        assertFalse(linkedQueue.contains("M"));
    }

    @Test
    @DisplayName("Check contains works correctly with null value")
    public void checkContainsWorksCorrectlyWithNullValue() {
        linkedQueue.enqueue(null);
        assertTrue(linkedQueue.contains(null));
    }

    @Test
    @DisplayName("Check clear after enqueue")
    public void checkClearAfterEnqueue() {
        linkedQueue.enqueue("P");
        linkedQueue.enqueue("R");
        assertEquals(2, linkedQueue.size());
        linkedQueue.clear();
        assertEquals(0, linkedQueue.size());
        assertTrue(linkedQueue.isEmpty());
    }
}
