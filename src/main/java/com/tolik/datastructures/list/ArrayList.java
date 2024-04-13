package com.tolik.datastructures.list;

import java.util.Iterator;
import java.util.Objects;

public class ArrayList<T> extends AbstractList<T> {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private T[] array;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value, int index) {
        validateIndexToAdd(index);
        ensureCapacityAndExtendArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        validateIndex(index);
        T removedValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedValue;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        validateIndex(index);
        T oldValue = array[index];
        array[index] = value;
        return oldValue;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    private void ensureCapacityAndExtendArray() {
        if (size == array.length - 1) {
            @SuppressWarnings("unchecked")
            T[] extendedArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, extendedArray, 0, size);
            array = extendedArray;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int index = 0;
        boolean canBeRemoved;

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
