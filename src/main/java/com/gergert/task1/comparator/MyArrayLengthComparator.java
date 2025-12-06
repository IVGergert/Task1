package com.gergert.task1.comparator;

import com.gergert.task1.entity.MyArray;

import java.util.Comparator;

public class MyArrayLengthComparator implements Comparator<MyArray> {

    @Override
    public int compare(MyArray myArray1, MyArray myArray2) {
        return Integer.compare(myArray1.getSize(), myArray2.getSize());
    }
}
