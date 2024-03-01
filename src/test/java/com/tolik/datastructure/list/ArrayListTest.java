package com.tolik.datastructure.list;

import com.tolik.datastructures.List.ArrayList;
import com.tolik.datastructures.List.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayListTest extends AbstractListTest {

    private List list;

    @Override
    List getList() {
        return new ArrayList();
    }

    @Test
    @DisplayName("Check add over initial capacity")
    public void checkAddOverInitialCapacity() {
        list = new ArrayList(1);
        list.add("X");
        list.add("Y");
        assertEquals(2, list.size());
        assertEquals("X", list.get(0));
        assertEquals("Y", list.get(1));
    }
}
