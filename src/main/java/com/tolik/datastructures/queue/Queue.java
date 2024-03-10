package com.tolik.datastructures.queue;

public interface Queue extends Iterable{
    public void enqueue(Object value);
    public Object dequeue();
    Object peek();
    public int size();
    boolean isEmpty();
    boolean contains(Object value);
    void clear();

    //[A,B,C] if size = 3
    String toString();
}
