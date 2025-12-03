package com.gergert.task1.service.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.service.ArraySortService;
import com.gergert.task1.validator.impl.ArrayValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArraySortServiceImpl implements ArraySortService {
    private static final Logger logger = LogManager.getLogger();
    private final ArrayValidatorImpl validator = new ArrayValidatorImpl();

    @Override
    public void bubbleSort(MyArray myArray) throws CustomException {
        validator.validateArray(myArray);

        logger.info("Starting Bubble Sort");

        int[] array = myArray.getArray();
        boolean swapped;

        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        myArray.setArray(array);
        logger.info("Bubble Sort finished, sorted array: {}", myArray.getArray());
    }

    @Override
    public void selectionSort(MyArray myArray) throws CustomException {
        validator.validateArray(myArray);

        logger.info("Starting Selection Sort");

        int[] array = myArray.getArray();

        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        myArray.setArray(array);

        logger.info("Selection Sort finished, sorted array: {}", myArray.getArray());
    }
}
