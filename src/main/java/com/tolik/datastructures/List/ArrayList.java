package com.tolik.datastructures.List;

import java.util.Objects;
import java.util.StringJoiner;

public class ArrayList extends AbstractList {

    private static final int DEFAULT_INITIAL_CAPACITY = 10;
    private Object[] array;

    public ArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.array = new Object[capacity];
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public void add(Object value, int index) {
        checkIfIndexIsPositiveAndLessThanSize(index);
        ensureCapacityAndExtendArray();
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public Object remove(int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        Object removedValue = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return removedValue;
    }

    @Override
    public Object get(int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        checkIfIndexIsPositiveAndLessThanRightBound(index);
        Object oldValue = array[index];
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
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i > 0; i--) {
            if (Objects.equals(array[i], value)) {
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(array[i]));
        }
        return stringJoiner.toString();
    }

    private void ensureCapacityAndExtendArray() {
        if (size > array.length * 0.75) {
            Object[] extendedArray = new Object[array.length * 2];
            System.arraycopy(array, 0, extendedArray, 0, size);
            array = extendedArray;
        }
    }

}
