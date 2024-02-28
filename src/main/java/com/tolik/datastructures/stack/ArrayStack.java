package com.tolik.datastructures.stack;

import java.util.Objects;
import java.util.StringJoiner;

public class ArrayStack implements Stack {
    private int size;
    private Object[] array;

    public ArrayStack() {
        this.array = new Object[10];
    }

    public ArrayStack(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    @Override
    public void push(Object value) {
        ensureCapacity();
        array[size++] = value;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            Object[] extendedArray = new Object[array.length * 2];
            System.arraycopy(array, 0, extendedArray, 0, size);
            array = extendedArray;
        }
    }

    @Override
    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        return array[--size];
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        return array[size - 1];
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(value, array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= size; i++) {
            array[i] = null;
            size--;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(array[i].toString());
        }
        return stringJoiner.toString();
    }
}
