package com.gergert.task1.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
    void testGetArrayReturnsCopy() {
        int[] original = {10, 20, 30};
        MyArray myArray = new MyArray(1, original);

        int[] expected = myArray.getArray();
        expected[0] = 999;

        assertEquals(10, myArray.getArray()[0]);
    }
}