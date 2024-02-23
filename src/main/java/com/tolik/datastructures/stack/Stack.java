package com.tolik.datastructures.stack;

public interface Stack {
    public void push(Object value);
    public Object pop();
    Object peek();
    boolean contains(Object value);
    public int size();
    boolean isEmpty();
    void clear();
}
