package com.gergert.task1.comparator;

import com.gergert.task1.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayFirstElementComparatorTest {

    CustomArrayFirstElementComparator firstElementComparator = new CustomArrayFirstElementComparator();

    @Test
    void compareNormalArrays() {
        CustomArray arr1 = new CustomArray(1, new int[]{10, 99, 99});
        CustomArray arr2 = new CustomArray(5, new int[]{50, 1});

        assertTrue(firstElementComparator.compare(arr1, arr2) < 0);
    }

    @Test
    void compareNegativeNumbers() {
        CustomArray arr1 = new CustomArray(1, new int[]{-100});
        CustomArray arr2 = new CustomArray(2, new int[]{-5});

        assertTrue(firstElementComparator.compare(arr1, arr2) < 0);
    }

    @Test
    void compareEmptyArrayVsFilled() {
        CustomArray empty = new CustomArray(1, new int[]{});
        CustomArray filled = new CustomArray(2, new int[]{-1000});

        assertTrue(firstElementComparator.compare(empty, filled) > 0);
    }

    @Test
    void compareTwoEmptyArrays() {
        CustomArray empty1 = new CustomArray(1, new int[]{});
        CustomArray empty2 = new CustomArray(2, new int[]{});

        assertEquals(0, firstElementComparator.compare(empty1, empty2));
    }
}