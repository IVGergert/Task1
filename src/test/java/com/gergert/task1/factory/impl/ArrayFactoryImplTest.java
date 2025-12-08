package com.gergert.task1.factory.impl;

import com.gergert.task1.entity.CustomArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFactoryImplTest {

    ArrayFactoryImpl arrayFactory = new ArrayFactoryImpl();

    @Test
    void testCreateArrayNotNull() {
        int[] expected = {1,2,3,4};
        CustomArray customArray = arrayFactory.createArray(1,expected);

        assertNotNull(customArray);
    }

    @Test
    void testCreateArrayValues() {
        int[] data = {4, 5, 6};
        CustomArray customArray = arrayFactory.createArray(99, data);

        assertArrayEquals(data, customArray.getArray());
        assertEquals(1, customArray.getId());
    }
}