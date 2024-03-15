package com.tolik.datastructures.stack;

public interface Stack extends Iterable {
    public void push(Object value);

    public Object pop();

    Object peek();

    boolean contains(Object value);

    public int size();

    boolean isEmpty();

    void clear();

    String toString();
}
