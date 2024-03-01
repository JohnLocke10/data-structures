package com.tolik.datastructures.queue;

import java.util.Objects;
import java.util.StringJoiner;

public class ArrayQueue implements Queue {
    private int leftIndex = 0;
    private int rightIndex = 0;
    private int size = 0;
    private Object[] array;

    public ArrayQueue() {
        this.array = new Object[10];
    }

    public ArrayQueue(int capacity) {
        this.array = new Object[capacity];
    }

    @Override
    public void enqueue(Object value) {
        ensureCapacityAndExtendArray();
        array[rightIndex++] = value;
        updateSize();
    }

    private void updateSize() {
        size = rightIndex - leftIndex;
    }

    private void ensureCapacityAndExtendArray() {
        if (array.length * 0.75 < size || rightIndex == array.length) {
            Object[] extendedArray = new Object[array.length * 2];
            System.arraycopy(array, leftIndex, extendedArray, 0, size);
            array = extendedArray;
            leftIndex = 0;
            rightIndex = size;
            updateSize();
        }
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty!");
        }
        Object elementToReturn = array[leftIndex];
        leftIndex++;
        updateSize();

        return elementToReturn;
    }

    @Override
    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The Queue is empty!");
        }
        return array[leftIndex];
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
    public boolean contains(Object value) {
        for (int i = leftIndex; i < rightIndex; i++) {
            if (Objects.equals(value, array[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = leftIndex; i < rightIndex; i++) {
            array[i] = null;
        }
        leftIndex = 0;
        rightIndex = 0;
        updateSize();
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = leftIndex; i < rightIndex; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        return stringJoiner.toString();
    }
}

