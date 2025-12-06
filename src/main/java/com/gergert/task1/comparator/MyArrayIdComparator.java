package com.gergert.task1.comparator;

import com.gergert.task1.entity.MyArray;

import java.util.Comparator;

public class MyArrayIdComparator implements Comparator<MyArray> {

    @Override
    public int compare(MyArray myArray1, MyArray myArray2) {
        return Integer.compare(myArray1.getId(), myArray2.getId());
    }
}
