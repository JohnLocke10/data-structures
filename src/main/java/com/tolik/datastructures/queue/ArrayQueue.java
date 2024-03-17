package com.tolik.datastructures.queue;

import java.util.Iterator;
import java.util.Objects;

public class ArrayQueue<T> extends AbstractQueue<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private int leftIndex = 0;
    private int rightIndex = 0;

    public ArrayQueue() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public void enqueue(T value) {
        ensureCapacityAndExtendArray();
        array[rightIndex++] = value;
        updateSize();
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        T elementToReturn = array[leftIndex];
        leftIndex++;
        updateSize();

        return elementToReturn;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException(QUEUE_IS_EMPTY);
        }
        return array[leftIndex];
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
        for (int i = leftIndex; i < rightIndex; i++) {
            array[i] = null;
        }
        leftIndex = 0;
        rightIndex = 0;
        updateSize();
    }

    private void updateSize() {
        size = rightIndex - leftIndex;
    }

    private void ensureCapacityAndExtendArray() {
        reorganiseElements();
        if (rightIndex == array.length) {
            T[] extendedArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, leftIndex, extendedArray, 0, size);
            array = extendedArray;
            leftIndex = 0;
            rightIndex = size;
            updateSize();
        }
    }

    private void reorganiseElements() {
        System.arraycopy(array, leftIndex, array, 0, size);
        leftIndex = 0;
        rightIndex = size;
        updateSize();
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }

    private class ArrayQueueIterator implements Iterator<T> {
        private int index = 0;
        private int validIndexToRemove = -1;

        @Override
        public boolean hasNext() {
            return (validIndexToRemove = index) < size;
        }

        @Override
        public T next() {
            return array[index++];
        }

        @Override
        public void remove() {
            if (validIndexToRemove == index) {
                System.arraycopy(array, index + 1, array, index, size - index);
                size--;
            } else {
                throw new IllegalStateException("Invalid using of remove method");
            }
            validIndexToRemove = -1;
        }
    }
}

