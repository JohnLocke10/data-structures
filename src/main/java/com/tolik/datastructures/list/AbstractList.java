package com.tolik.datastructures.list;

import java.util.StringJoiner;

public abstract class AbstractList implements List {

    static final String INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LIST_SIZE =
            "Index should be in range from 0(inclusive) till list.size(exclusive)! List size: %d. Actual index: %d";
    static final String INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LAST_RIGHT_VALUE_INDEX =
            "Index should be from 0(inclusive) till last right value index(exclusive). Right index: %d .Actual index: %d";

    int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(Object value) {
        add(value, size);
    }

    @Override
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (Object object : this) {
            stringJoiner.add(String.valueOf(object));
        }
        return stringJoiner.toString();
    }

    void validateIndexToAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LIST_SIZE, size, index));
        }
    }

    void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LAST_RIGHT_VALUE_INDEX, size - 1, index));
        }
    }
}
