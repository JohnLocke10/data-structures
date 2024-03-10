package com.tolik.datastructures.queue;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedQueue extends AbstractQueue {

    private Node head;

    @Override
    public void enqueue(Object value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node currentNode = head;
            for (int i = 1; i < size; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;

    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        Object result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        return head.value;
    }

    @Override
    public boolean contains(Object value) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.value, value)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(currentNode.value));
            currentNode = currentNode.next;
        }
        return stringJoiner.toString();
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
