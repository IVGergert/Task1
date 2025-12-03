package com.gergert.task1.validator.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger(ArrayValidatorImpl.class);

    @Override
    public void validateArray(MyArray myArray) throws CustomException {
        if (myArray == null) {
            logger.error("Check failed: MyArray entity is null");
            throw new CustomException("Array entity cannot be null");
        }

        if (myArray.getSize() == 0) {
            logger.error("Check failed: Array is empty");
            throw new CustomException("Array cannot be empty");
        }
    }
}
