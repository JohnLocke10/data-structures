package com.tolik.datastructures.queue;

public abstract class AbstractQueue implements Queue{
    int size = 0;
    Object[] array;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
