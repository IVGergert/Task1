package com.gergert.task1.entity;

import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayTest {
    @Test
    void testEqualsAndHashCodeById() {
        CustomArray arr1 = new CustomArray(1, new int[]{1, 2, 3});
        CustomArray arr2 = new CustomArray(1, new int[]{100, 200});

        assertEquals(arr1, arr2);
        assertEquals(arr1.hashCode(), arr2.hashCode());
    }

    @Test
    void testNotEqualsById() {
        CustomArray arr1 = new CustomArray(1, new int[]{1, 2, 3});
        CustomArray arr2 = new CustomArray(2, new int[]{1, 2, 3});

        assertNotEquals(arr1, arr2);
    }

    @Test
    void testGetArray() {
        CustomArray customArray = new CustomArray(new int[] {10, 20, 30});

        int[] expected = customArray.getArray();
        expected[0] = 999;

        assertEquals(10, customArray.getArray()[0]);
    }

    @Test
    void testGetFirstElement() {
        CustomArray empty = new CustomArray(2, new int[]{});
        assertEquals(0, empty.getFirstElement());

        CustomArray normal = new CustomArray(3, new int[]{5, 6});
        assertEquals(5, normal.getFirstElement());
    }

    @Test
    void testSetElementUpdatesValue() throws CustomException {
        CustomArray customArray = new CustomArray(1, new int[]{10, 20});
        customArray.setElement(0, 50);

        assertEquals(50, customArray.getArray()[0]);
    }

    @Test
    void testSetElementThrowsExceptionOutOfBounds() {
        CustomArray customArray = new CustomArray(1, new int[]{10});

        assertThrows(CustomException.class, () -> customArray.setElement(5, 100));
        assertThrows(CustomException.class, () -> customArray.setElement(-1, 100));
    }
}