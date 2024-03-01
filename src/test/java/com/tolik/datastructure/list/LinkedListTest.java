package com.tolik.datastructure.list;

import com.tolik.datastructures.List.LinkedList;
import com.tolik.datastructures.List.List;

public class LinkedListTest extends AbstractListTest{

    @Override
    List getList() {
        return new LinkedList();
    }
}
