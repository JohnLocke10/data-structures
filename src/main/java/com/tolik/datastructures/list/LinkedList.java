package com.tolik.datastructures.list;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private Node<T> tail;

    @Override
    public void add(T value, int index) {
        validateIndexToAdd(index);
        Node<T> newNode = new Node<>(value);
        if (size == 0) {
            head = tail = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node<T> findedNode = findNode(index);
            newNode.next = findedNode;
            newNode.prev = findedNode.prev;
            findedNode.prev.next = newNode;
            findedNode.prev = newNode;
        }
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T deletedValue;
        if (size == 1) {
            deletedValue = head.value;
            head = null;
            tail = null;
        } else if (index == 0) {
            deletedValue = head.value;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            deletedValue = tail.value;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> findedNode = findNode(index);
            deletedValue = findedNode.value;
            findedNode.next.prev = findedNode.prev;
            findedNode.prev.next = findedNode.next;
        }
        size--;
        return deletedValue;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node<T> findedNode = findNode(index);
            return findedNode.value;
        }
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        T oldValue;
        if (index == 0) {
            oldValue = head.value;
            head.value = value;
        } else if (index == size - 1) {
            oldValue = tail.value;
            tail.value = value;
        } else {
            Node<T> findedNode = findNode(index);
            oldValue = findedNode.value;
            findedNode.value = value;
        }
        return oldValue;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int indexOf(Object value) {
        Node<T> currentNode = head;
        for (int i = 0; i < size; i++) {
            if (Objects.equals(currentNode.value, value)) {
                return i;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node<T> currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(currentNode.value, value)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
    }

    private Node<T> findNode(int index) {
        if (index <= size / 2) {
            return findStartingFromHead(index);
        } else {
            return findStartingFromTail(index);
        }
    }

    private Node<T> findStartingFromHead(int index) {
        Node<T> currentNode = head;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node<T> findStartingFromTail(int index) {
        Node<T> currentNode = tail;
        for (int i = size - 1; i > index; i--) {
            currentNode = currentNode.prev;
        }
        return currentNode;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> currentNode = head;
        private Node<T> validNodeToRemove = null;

        @Override
        public boolean hasNext() {
            return (validNodeToRemove = currentNode) != null;
        }

        @Override
        public T next() {
            T value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }

        @Override
        public void remove() {
            if (Objects.equals(currentNode, validNodeToRemove)) {
                if (size == 1) {
                    head = null;
                    tail = null;
                } else if (Objects.equals(currentNode, head)) {
                    head = head.next;
                    head.prev = null;
                }
                currentNode = head;
                size--;
            } else {
                throw new IllegalStateException("Invalid using of remove method");
            }
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        public Node(T value) {
            this.value = value;
        }
    }

}
