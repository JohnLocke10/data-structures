package com.tolik.datastructures.queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayQueueTest extends AbstractQueueTest {

    @Override
    Queue<String> getQueue() {
        return new ArrayQueue<>();
    }

    @Test
    @DisplayName("Check changing capacity for queue with many empty buckets")
    public void checkChangingCapacityForQueueWithManyEmptyBuckets() {
        for (int i = 0; i <= 11; i++) {
            queue.enqueue("S");
            assertEquals("S", queue.dequeue());
            assertEquals(0, queue.size());
        }
        queue.enqueue("B");
        assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("Check enqueue over initial capacity, peek, and dequeue")
    public void checkEnqueueOverInitialCapacityPeekAndDequeue() {
        queue = new ArrayQueue<>(2);
        queue.enqueue("E");
        queue.enqueue("F");
        queue.enqueue("G");
        assertEquals(3, queue.size());
        assertEquals("E", queue.peek());
        assertEquals("E", queue.peek());
        assertEquals("E", queue.dequeue());
        assertEquals("F", queue.dequeue());
        assertEquals("G", queue.dequeue());
        assertEquals(0, queue.size());
    }

    @Test
    @DisplayName("Check enqueue over initial capacity, dequeue, and enqueue again")
    public void checkEnqueueOverInitialCapacityDequeueAndEnqueueAgain() {
        queue = new ArrayQueue<>(1);
        queue.enqueue("S");
        queue.enqueue("T");
        assertEquals(2, queue.size());
        assertEquals("S", queue.dequeue());
        assertEquals("T", queue.dequeue());
        assertEquals(0, queue.size());
        queue.enqueue("U");
        assertEquals(1, queue.size());
        assertEquals("U", queue.peek());
        assertEquals(1, queue.size());
    }
}