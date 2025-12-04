package com.gergert.task1.service.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.service.ArrayCalculationService;
import com.gergert.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalInt;

public class ArrayCalculationServiceImpl implements ArrayCalculationService {
    private static final Logger logger = LogManager.getLogger();
    private final ArrayValidatorImpl validator = new ArrayValidatorImpl();

    @Override
    public OptionalInt findMin(MyArray myArray){
        validator.validateArray(myArray);

        int[] array = myArray.getArray();

        int min = array[0];

        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }

        logger.info("Min value in the array: {}", min);
        return OptionalInt.of(min);
    }

    @Override
    public OptionalInt findMax(MyArray myArray){
        validator.validateArray(myArray);

        int[] array = myArray.getArray();

        int max = array[0];

        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }

        logger.info("Max value in the array: {}", max);
        return OptionalInt.of(max);
    }

    @Override
    public int findSum(MyArray myArray){
        validator.validateArray(myArray);

        int[] array = myArray.getArray();

        int sum = 0;

        for (int element : array) {
            sum += element;
        }

        logger.info("Sum: {}", sum);
        return sum;
    }
}
