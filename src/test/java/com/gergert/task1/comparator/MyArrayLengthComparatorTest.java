package com.gergert.task1.comparator;

import com.gergert.task1.entity.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayLengthComparatorTest {

    MyArrayLengthComparator lengthComparator = new MyArrayLengthComparator();

    @Test
    void compareNormalArrays() {
        MyArray arr1 = new MyArray(1, new int[]{10, 99, 99});
        MyArray arr2 = new MyArray(5, new int[]{50, 1});

        assertTrue(lengthComparator.compare(arr1, arr2) > 0);
        assertTrue(lengthComparator.compare(arr2, arr1) < 0);
    }

    @Test
    void compareShouldHandleEmptyArrays() {
        MyArray empty = new MyArray(1, new int[]{});
        MyArray notEmpty = new MyArray(2, new int[]{100});

        assertTrue(lengthComparator.compare(empty, notEmpty) < 0);
    }

    @Test
    void compareSameLength() {
        MyArray arr1 = new MyArray(1, new int[]{1, 2, 3});
        MyArray arr2 = new MyArray(2, new int[]{7, 8, 9});

        assertEquals(0, lengthComparator.compare(arr1, arr2));
    }
}