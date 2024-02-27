package com.tolik.datastructures.List;

import java.util.Objects;

public class ArrayList implements List {

    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[10];
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
        checkIfIndexToAddIsLessThanSize(index);
        ensureCapacityAndExtendArray();
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = value;
        size++;
    }

    private void ensureCapacityAndExtendArray() {
        if (size > array.length * 0.75) {
            Object[] extendedArray = new Object[array.length * 2];
            for (int i = 0; i < size; i++) {
                extendedArray[i] = array[i];
            }
            array = extendedArray;
        }
    }

    private void checkIfIndexToAddIsLessThanSize(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(
                            "Index should be a positive number less than array size! Array size: %d .Actual index: %d",
                            size, index));
        }
    }

    private void checkIfIndexIsLessThanRightBound(int index, int rightBound) {
        if (index < 0 || index > rightBound) {
            throw new IndexOutOfBoundsException(
                    String.format("Index should be a positive number less than last right value index. Right index: %d "
                            + ".Actual index: ", rightBound, index))
                    ;
        }
    }

    @Override
    public Object remove(int index) {
        checkIfIndexIsLessThanRightBound(index, size - 1);
        Object removedValue = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedValue;
    }

    @Override
    public Object get(int index) {
        checkIfIndexIsLessThanRightBound(index, size - 1);
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        checkIfIndexIsLessThanRightBound(index, size - 1);
        array[index] = value;
        return value;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
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

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);

            if (i != size - 1) {
                stringBuilder.append(", ");
            } else {
                stringBuilder.append("");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
