package com.gergert.task1.comparator;

import com.gergert.task1.entity.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MyArrayFirstElementComparatorTest {

    MyArrayFirstElementComparator firstElementComparator = new MyArrayFirstElementComparator();

    @Test
    void compareNormalArrays() {
        MyArray arr1 = new MyArray(1, new int[]{10, 99, 99});
        MyArray arr2 = new MyArray(5, new int[]{50, 1});

        assertTrue(firstElementComparator.compare(arr1, arr2) < 0);
    }

    @Test
    void compareNegativeNumbers() {
        MyArray arr1 = new MyArray(1, new int[]{-100});
        MyArray arr2 = new MyArray(2, new int[]{-5});

        assertTrue(firstElementComparator.compare(arr1, arr2) < 0);
    }

    @Test
    void compareEmptyArrayVsFilled() {
        MyArray empty = new MyArray(1, new int[]{});
        MyArray filled = new MyArray(2, new int[]{-1000});

        assertTrue(firstElementComparator.compare(empty, filled) > 0);
    }

    @Test
    void compareTwoEmptyArrays() {
        MyArray empty1 = new MyArray(1, new int[]{});
        MyArray empty2 = new MyArray(2, new int[]{});

        assertEquals(0, firstElementComparator.compare(empty1, empty2));
    }
}