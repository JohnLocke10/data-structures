package com.tolik.datastructures.stack;

public interface Stack<T> extends Iterable<T> {
    public void push(T value);

    public T pop();

    T peek();

    boolean contains(T value);

    public int size();

    boolean isEmpty();

    void clear();

    String toString();
}
