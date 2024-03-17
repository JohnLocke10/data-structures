package com.tolik.datastructures.stack;

import java.util.Iterator;
import java.util.Objects;
import java.util.StringJoiner;

public class ArrayStack<T> implements Stack<T> {
    private int size;
    private T[] array;

    public ArrayStack() {
        this.array = (T[]) new Object[10];
    }

    public ArrayStack(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
    }

    @Override
    public void push(T value) {
        ensureCapacity();
        array[size++] = value;
    }

    private void ensureCapacity() {
        if (array.length == size) {
            T[] extendedArray = (T[]) new Object[array.length * 2];
            System.arraycopy(array, 0, extendedArray, 0, size);
            array = extendedArray;
        }
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        return array[--size];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("The stack is empty!");
        }
        return array[size - 1];
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
        for (T object : this) {
            stringJoiner.add(String.valueOf(object));
        }
        return stringJoiner.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {

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
                throw new IllegalStateException("Invalid using of remove method for index: " + index);
            }
            validIndexToRemove = -1;
        }
    }
}
