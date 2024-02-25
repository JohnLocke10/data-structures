package com.tolik.datastructure.queue;

import com.tolik.datastructures.queue.ArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void checkEnqueueDequeueAndChangeSizeWorkCorrectly() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("A");
        arrayQueue.enqueue("B");
        assertEquals(2, arrayQueue.size());
        assertEquals("A", arrayQueue.dequeue());
        assertEquals("B", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
    }

    @Test
    public void checkChangingCapacityForQueueWithManyEmptyBuckets() {
        ArrayQueue arrayQueue = new ArrayQueue();
        for (int i = 0; i <= 11; i++) {
            arrayQueue.enqueue("S");
            assertEquals("S", arrayQueue.dequeue());
            assertEquals(0, arrayQueue.size());
        }
        arrayQueue.enqueue("B");
        assertEquals(1, arrayQueue.size());
    }

    @Test
    public void checkPushAndPeek() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("C");
        arrayQueue.enqueue("D");
        assertEquals(2, arrayQueue.size());
        assertEquals("C", arrayQueue.peek());
        assertEquals("C", arrayQueue.peek());
        assertEquals(2, arrayQueue.size());
    }

    @Test
    public void checkEnqueueOverInitialCapacityPeekAndDequeueWorkCorrectly() {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.enqueue("E");
        arrayQueue.enqueue("F");
        arrayQueue.enqueue("G");
        assertEquals(3, arrayQueue.size());
        assertEquals("E", arrayQueue.peek());
        assertEquals("E", arrayQueue.peek());
        assertEquals("E", arrayQueue.dequeue());
        assertEquals("F", arrayQueue.dequeue());
        assertEquals("G", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
    }

    @Test
    public void checkEnqueueOverInitialCapacityDequeueAndEnqueueAgain() {
        ArrayQueue arrayQueue = new ArrayQueue(1);
        arrayQueue.enqueue("S");
        arrayQueue.enqueue("T");
        assertEquals(2, arrayQueue.size());
        assertEquals("S", arrayQueue.dequeue());
        assertEquals("T", arrayQueue.dequeue());
        assertEquals(0, arrayQueue.size());
        arrayQueue.enqueue("U");
        assertEquals(1, arrayQueue.size());
        assertEquals("U", arrayQueue.peek());
        assertEquals(1, arrayQueue.size());
    }

    @Test
    public void checkIsEmptyReturnTrueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void checkIsEmptyWorksCorrectlyAfterPeekAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("K");
        assertFalse(arrayQueue.isEmpty());
        arrayQueue.peek();
        assertFalse(arrayQueue.isEmpty());
        arrayQueue.dequeue();
        assertTrue(arrayQueue.isEmpty());
    }

    @Test
    public void checkThrowIllegalStateExceptionWhenPeekOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.peek();
        });
    }

    @Test
    public void checkThrowIllegalStateExceptionWhenDequeueOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertThrows(IllegalStateException.class, () -> {
            arrayQueue.dequeue();
        });
    }

    @Test
    public void checkContainsReturnFalseOnEmptyQueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        assertFalse(arrayQueue.contains("L"));
    }

    @Test
    public void checkContainsWorksCorrectlyAfterPeekAndDequeue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("M");
        assertTrue(arrayQueue.contains("M"));
        arrayQueue.peek();
        assertTrue(arrayQueue.contains("M"));
        arrayQueue.dequeue();
        assertFalse(arrayQueue.contains("M"));
    }

    @Test
    public void checkClearAfterEnqueue() {
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("P");
        arrayQueue.enqueue("R");
        assertEquals(2, arrayQueue.size());
        arrayQueue.clear();
        assertEquals(0, arrayQueue.size());
        assertTrue(arrayQueue.isEmpty());
    }
}
