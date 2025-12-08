package com.gergert.task1.service.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArraySortServiceImplTest {

    ArraySortServiceImpl sortService = new ArraySortServiceImpl();

    @Test
    void bubbleSort() throws CustomException {
        CustomArray actual = new CustomArray(new int[] {8, 2, 21, 63, 23});
        CustomArray expected = new CustomArray(new int[] {2, 8, 21, 23, 63});
        sortService.bubbleSort(actual);
        assertEquals(expected, actual);
    }

    @Test
    void selectionSort() throws CustomException {
        CustomArray actual = new CustomArray(new int[] {1, 9, 2, 23, 12, 72});
        CustomArray expected = new CustomArray(new int[] {1, 2, 9, 12, 23, 72});
        sortService.selectionSort(actual);
        assertEquals(expected, actual);
    }
}