package com.gergert.task1.comparator;

import com.gergert.task1.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayLengthComparatorTest {

    CustomArrayLengthComparator lengthComparator = new CustomArrayLengthComparator();

    @Test
    void compareNormalArrays() {
        CustomArray arr1 = new CustomArray(1, new int[]{10, 99, 99});
        CustomArray arr2 = new CustomArray(5, new int[]{50, 1});

        assertTrue(lengthComparator.compare(arr1, arr2) > 0);
        assertTrue(lengthComparator.compare(arr2, arr1) < 0);
    }

    @Test
    void compareShouldHandleEmptyArrays() {
        CustomArray empty = new CustomArray(1, new int[]{});
        CustomArray notEmpty = new CustomArray(2, new int[]{100});

        assertTrue(lengthComparator.compare(empty, notEmpty) < 0);
    }

    @Test
    void compareSameLength() {
        CustomArray arr1 = new CustomArray(1, new int[]{1, 2, 3});
        CustomArray arr2 = new CustomArray(2, new int[]{7, 8, 9});

        assertEquals(0, lengthComparator.compare(arr1, arr2));
    }
}