package com.tolik.datastructures.queue;

public interface Queue<T> extends Iterable<T> {
    public void enqueue(T value);

    public T dequeue();

    T peek();

    public int size();

    boolean isEmpty();

    boolean contains(T value);

    void clear();

    //[A,B,C] if size = 3
    String toString();
}
