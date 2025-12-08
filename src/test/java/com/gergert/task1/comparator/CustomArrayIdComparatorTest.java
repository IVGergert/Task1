package com.gergert.task1.comparator;

import com.gergert.task1.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CustomArrayIdComparatorTest {

    CustomArrayIdComparator idComparator = new CustomArrayIdComparator();

    @Test
    void compareNormalArrays() {
        CustomArray arr1 = new CustomArray(1, new int[]{});
        CustomArray arr2 = new CustomArray(5, new int[]{});

        assertTrue(idComparator.compare(arr1, arr2) < 0);
        assertTrue(idComparator.compare(arr2, arr1) > 0);
    }

    @Test
    void compareEqualsIdArrays() {
        CustomArray arr1 = new CustomArray(3, new int[]{});
        CustomArray arr2 = new CustomArray(3, new int[]{});

        assertEquals(0, idComparator.compare(arr1, arr2));
    }
}