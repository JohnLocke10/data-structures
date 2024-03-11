package com.tolik.datastructures.queue;

import java.util.StringJoiner;

public abstract class AbstractQueue implements Queue {
    public static final String QUEUE_IS_EMPTY = "The Queue is empty!";
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

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Object object : this) {
            stringJoiner.add(String.valueOf(object));
        }
        return stringJoiner.toString();
    }
}
