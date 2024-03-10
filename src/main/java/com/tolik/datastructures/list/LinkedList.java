package com.tolik.datastructures.list;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {
    private Node head;
    private Node tail;

    @Override
    public void add(Object value, int index) {
        validateIndexToAdd(index);
        Node newNode = new Node(value);
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
            Node findedNode = findNode(index);
            newNode.next = findedNode;
            newNode.prev = findedNode.prev;
            findedNode.prev.next = newNode;
            findedNode.prev = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        validateIndex(index);
        Object deletedValue;
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
            Node findedNode = findNode(index);
            deletedValue = findedNode.value;
            findedNode.next.prev = findedNode.prev;
            findedNode.prev.next = findedNode.next;
        }
        size--;
        return deletedValue;
    }

    @Override
    public Object get(int index) {
        validateIndex(index);
        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node findedNode = findNode(index);
            return findedNode.value;
        }
    }

    @Override
    public Object set(Object value, int index) {
        validateIndex(index);
        Object oldValue;
        if (index == 0) {
            oldValue = head.value;
            head.value = value;
        } else if (index == size - 1) {
            oldValue = tail.value;
            tail.value = value;
        } else {
            Node findedNode = findNode(index);
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
        Node currentNode = head;
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
        Node currentNode = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(currentNode.value, value)) {
                return i;
            }
            currentNode = currentNode.prev;
        }
        return -1;
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

    private Node findNode(int index) {
        if (index <= size / 2) {
            return findStartingFromHead(index);
        } else {
            return findStartingFromTail(index);
        }
    }

    private Node findStartingFromHead(int index) {
        Node currentNode = head;
        for (int i = 1; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    private Node findStartingFromTail(int index) {
        Node currentNode = tail;
        for (int i = size - 1; i > index; i--) {
            currentNode = currentNode.prev;
        }
        return currentNode;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator {
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
        private Node prev;

        public Node(Object value) {
            this.value = value;
        }
    }

}
