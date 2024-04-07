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
        private Node<T> validNodeToRemove = null;

        @Override
        public boolean hasNext() {
            return (validNodeToRemove = currentNode) != null;
        }

        @Override
        public void remove() {
            if (!Objects.equals(currentNode, validNodeToRemove)) {
                throw new IllegalStateException("Invalid using of remove method");
            }
            head = currentNode.next;
            currentNode = head;
            size--;
        }

        @Override
        public T next() {
            T value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }
}
