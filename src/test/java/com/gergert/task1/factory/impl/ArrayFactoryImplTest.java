package com.gergert.task1.factory.impl;

import com.gergert.task1.entity.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryImplTest {

    ArrayFactoryImpl arrayFactory = new ArrayFactoryImpl();

    @Test
    void testCreateArrayNotNull() {
        int[] expected = {1,2,3,4};
        MyArray myArray = arrayFactory.createArray(1,expected);

        assertNotNull(myArray);
    }

    @Test
    void testCreateArrayValues() {
        int[] data = {4, 5, 6};
        MyArray myArray = arrayFactory.createArray(99, data);

        assertArrayEquals(data, myArray.getArray());
        assertEquals(1, myArray.getId());
    }
}