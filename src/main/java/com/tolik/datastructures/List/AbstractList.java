package com.tolik.datastructures.List;

import static com.tolik.datastructures.general.Constants.INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LAST_RIGHT_VALUE_INDEX;
import static com.tolik.datastructures.general.Constants.INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LIST_SIZE;

public abstract class AbstractList implements List {

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
    public boolean contains(Object value) {
        return indexOf(value) != -1;
    }

    void checkIfIndexIsPositiveAndLessThanSize(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LIST_SIZE, size, index));
        }
    }

    void checkIfIndexIsPositiveAndLessThanRightBound(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException(
                    String.format(INDEX_SHOULD_BE_POSITIVE_AND_LESS_THAN_LAST_RIGHT_VALUE_INDEX, size - 1, index));
        }
    }
}
