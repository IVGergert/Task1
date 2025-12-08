package com.gergert.task1.service.impl;

import com.gergert.task1.entity.CustomArray;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCalculationServiceImplTest {

    ArrayCalculationServiceImpl arrayCalculationService = new ArrayCalculationServiceImpl();

    @Test
    void findMin(){
        CustomArray array = new CustomArray(new int[]{74,4,8,9,45,342,23,6});
        OptionalInt expected = OptionalInt.of(4);
        OptionalInt actual = arrayCalculationService.findMin(array);
        assertEquals(expected, actual);
    }

    @Test
    void findMax(){
        CustomArray array = new CustomArray(new int[]{74,4,8,9,45,342,23,6});
        OptionalInt expected = OptionalInt.of(342);
        OptionalInt actual = arrayCalculationService.findMax(array);
        assertEquals(expected, actual);
    }

    @Test
    void sum(){
        CustomArray array = new CustomArray(new int[]{2,4,8,9,6});
        int expected = 29;
        int actual = arrayCalculationService.findSum(array);
        assertEquals(expected, actual);
    }
}