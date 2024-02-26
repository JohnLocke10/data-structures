package com.tolik.datastructures.List;

public interface List {
    void add(Object value);

    void add(Object value, int index);

    Object remove(int index);

    Object get(int index);

    Object set(Object value, int index);

    void clear();

    int size();

    boolean isEmpty();

    int indexOf(Object value);

    int lastIndexOf(Object value);

    boolean contains(Object value);

    String toString();

}
