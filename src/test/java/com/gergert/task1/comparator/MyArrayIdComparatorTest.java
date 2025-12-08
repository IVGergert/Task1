package com.gergert.task1.comparator;

import com.gergert.task1.entity.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayIdComparatorTest {

    MyArrayIdComparator idComparator = new MyArrayIdComparator();

    @Test
    void compareNormalArrays() {
        MyArray arr1 = new MyArray(1, new int[]{});
        MyArray arr2 = new MyArray(5, new int[]{});

        assertTrue(idComparator.compare(arr1, arr2) < 0);
        assertTrue(idComparator.compare(arr2, arr1) > 0);
    }

    @Test
    void compareEqualsIdArrays() {
        MyArray arr1 = new MyArray(3, new int[]{});
        MyArray arr2 = new MyArray(3, new int[]{});

        assertEquals(0, idComparator.compare(arr1, arr2));
    }
}