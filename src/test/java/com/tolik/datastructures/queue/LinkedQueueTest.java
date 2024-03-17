package com.tolik.datastructures.queue;

public class LinkedQueueTest extends AbstractQueueTest {

    @Override
    Queue<String> getQueue() {
        return new LinkedQueue<>();
    }
}
