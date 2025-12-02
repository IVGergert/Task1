package com.gergert.task1.service.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySortServiceImplTest {

    private final ArraySortServiceImpl sortService = new ArraySortServiceImpl();

    @Test
    void bubbleSort() throws CustomException {
        MyArray actual = new MyArray(new int[] {8, 2, 21, 63, 23});
        MyArray expected = new MyArray(new int[] {2, 8, 21, 23, 63});
        sortService.bubbleSort(actual);
        assertEquals(expected, actual);
    }

    @Test
    void selectionSort() throws CustomException {
        MyArray actual = new MyArray(new int[] {1, 9, 2, 23, 12, 72});
        MyArray expected = new MyArray(new int[] {1, 2, 9, 12, 23, 72});
        sortService.selectionSort(actual);
        assertEquals(expected, actual);
    }
}