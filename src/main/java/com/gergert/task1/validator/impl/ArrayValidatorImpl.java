package com.gergert.task1.validator.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.validator.ArrayValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public boolean validateArray(CustomArray myArray){
        if (myArray == null) {
            logger.error("Check failed: MyArray entity is null");
            return false;
        }

        if (myArray.getSize() == 0) {
            logger.error("Check failed: Array is empty");
            return false;
        }

        return true;
    }
}
