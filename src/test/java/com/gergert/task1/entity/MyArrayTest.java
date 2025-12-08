package com.gergert.task1.entity;


import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayTest {
    @Test
    void testEqualsAndHashCodeById() {
        MyArray arr1 = new MyArray(1, new int[]{1, 2, 3});
        MyArray arr2 = new MyArray(1, new int[]{100, 200});

        assertEquals(arr1, arr2);
        assertEquals(arr1.hashCode(), arr2.hashCode());
    }

    @Test
    void testNotEqualsById() {
        MyArray arr1 = new MyArray(1, new int[]{1, 2, 3});
        MyArray arr2 = new MyArray(2, new int[]{1, 2, 3});

        assertNotEquals(arr1, arr2);
    }

    @Test
    void testGetArray() {
        MyArray myArray = new MyArray(new int[] {10, 20, 30});

        int[] expected = myArray.getArray();
        expected[0] = 999;

        assertEquals(10, myArray.getArray()[0]);
    }

    @Test
    void testGetFirstElement() {
        MyArray empty = new MyArray(2, new int[]{});
        assertEquals(0, empty.getFirstElement());

        MyArray normal = new MyArray(3, new int[]{5, 6});
        assertEquals(5, normal.getFirstElement());
    }

    @Test
    void testSetElementUpdatesValue() throws CustomException {
        MyArray myArray = new MyArray(1, new int[]{10, 20});
        myArray.setElement(0, 50);

        assertEquals(50, myArray.getArray()[0]);
    }

    @Test
    void testSetElementThrowsExceptionOutOfBounds() {
        MyArray myArray = new MyArray(1, new int[]{10});

        assertThrows(CustomException.class, () -> myArray.setElement(5, 100));
        assertThrows(CustomException.class, () -> myArray.setElement(-1, 100));
    }
}