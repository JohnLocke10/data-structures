package com.tolik.datastructures.queue;

import java.util.Iterator;
import java.util.Objects;

public class LinkedQueue<T> extends AbstractQueue<T> {

    private Node<T> head;

    @Override
    public void enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> currentNode = head;
            for (int i = 1; i < size; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        T result = head.value;
        head = head.next;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        return head.value;
    }

    @Override
    public boolean contains(T value) {
        for (T object : this) {
            if (Objects.equals(object, value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedQueueIterator();
    }

    private class LinkedQueueIterator implements Iterator<T> {
        private Node<T> currentNode = head;
        private boolean canBeRemoved;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T value = currentNode.value;
            currentNode = currentNode.next;
            canBeRemoved = true;
            return value;
        }

        @Override
        public void remove() {
            if (!canBeRemoved) {
                throw new IllegalStateException("Invalid using of remove method");
            }
            head = (size == 1 ? null : currentNode);
            currentNode = head;
            size--;
            canBeRemoved = false;
        }

    }

    private static class Node<T> {
        private final T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
