package com.tolik.datastructures.list;

public interface List<T> extends Iterable<T> {
    void add(T value);

    void add(T value, int index);

    T remove(int index);

    T get(int index);

    T set(T value, int index);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(T value);

    int lastIndexOf(T value);

    boolean contains(T value);

    String toString();

}
