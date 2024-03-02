package com.tolik.datastructures.List;

import java.util.Objects;
import java.util.StringJoiner;

public class LinkedList extends AbstractList {
    private Node head;
    private Node tail;

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkIfIndexIsPositiveAndLessThanSize(index);
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
            Node currentNode = head;
            for (int i = 1; i < size - 1; i++) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            newNode.prev = currentNode;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        Object deletedValue;
        if (size == 1) {
            deletedValue = head.value;
            head = null;
            tail = null;
        } else if (index == 0) {
            deletedValue = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            deletedValue = tail.value;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node currentNode = head;
            for (int i = 1; i < size - 1; i++) {
                currentNode = currentNode.next;
            }
            deletedValue = currentNode.value;
            currentNode.next.prev = currentNode.prev;
            currentNode.prev.next = currentNode.next;
        }
        size--;
        return deletedValue;
    }

    @Override
    public Object get(int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        if (index == 0) {
            return head.value;
        } else if (index == size - 1) {
            return tail.value;
        } else {
            Node currentNode = head;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }
    }

    @Override
    public Object set(Object value, int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        Object oldValue;
        if (index == 0) {
            oldValue = head.value;
            head.value = value;
        } else if (index == size - 1) {
            oldValue = tail.value;
            tail.value = value;
        } else {
            Node currentNode = head;
            for (int i = 1; i <= index; i++) {
                currentNode = currentNode.next;
            }
            oldValue = currentNode.value;
            currentNode.value = value;
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
        if (Objects.isNull(currentNode)) {
            return -1;
        } else if (Objects.equals(currentNode.value, value)) {
            return 0;
        }
        for (int i = 1; i < size; i++) {
            currentNode = currentNode.next;
            if (Objects.equals(currentNode.value, value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node currentNode = tail;
        if (Objects.isNull(currentNode)) {
            return -1;
        } else if (Objects.equals(currentNode.value, value)) {
            return size - 1;
        }
        for (int i = size - 2; i > 0; i--) {
            currentNode = currentNode.prev;
            if (Objects.equals(currentNode.value, value)) {
                return i;
            }
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

}
