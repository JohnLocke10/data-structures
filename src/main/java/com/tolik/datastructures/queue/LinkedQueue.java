package com.tolik.datastructures.queue;

import java.util.Iterator;
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
        for (Object object : this) {
            Objects.equals(object, value);
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator {
        private int index = 0;
        private Node currentNode = head;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public Object next() {
            Object value = currentNode.value;
            currentNode = currentNode.next;
            index++;
            return value;
        }
    }

    private static class Node {
        private Object value;
        private Node next;

        public Node(Object value) {
            this.value = value;
        }
    }
}
