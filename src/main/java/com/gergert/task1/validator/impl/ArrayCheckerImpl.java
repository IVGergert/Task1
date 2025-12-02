package com.gergert.task1.validator.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.validator.ArrayChecker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayCheckerImpl implements ArrayChecker {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void checkArray(MyArray myArray) throws CustomException {
        if (myArray == null) {
            logger.error("Check failed:Array is null");
            throw new CustomException("Array cannot be null");
        }

        int[] array = myArray.getArray();

        if (array == null || array.length == 0) {
            logger.error("Check failed: Array inside MyArray is empty or null");
            throw new CustomException("Array is empty");
        }
    }
}
