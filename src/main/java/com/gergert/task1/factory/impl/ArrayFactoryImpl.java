package com.gergert.task1.factory.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.factory.ArrayFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class ArrayFactoryImpl implements ArrayFactory {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public CustomArray createArray(int id, int[] array) {
        logger.info("Creating array: {}", Arrays.toString(array));
        return new CustomArray(id,array);
    }
}
