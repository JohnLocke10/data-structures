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

    @SuppressWarnings("unchecked")
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
            @SuppressWarnings("unchecked")
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
        private boolean canBeRemoved;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            canBeRemoved = true;
            return array[index++];
        }

        @Override
        public void remove() {
            if (!canBeRemoved) {
                throw new IllegalStateException("Invalid using of remove method");
            }
            System.arraycopy(array, index, array, index - 1, size - index);
            size--;
            index = index - 1;
            canBeRemoved = false;
        }
    }
}

