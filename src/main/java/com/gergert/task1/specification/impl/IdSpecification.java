package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.specification.ArraySpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IdSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final int searchId;

    public IdSpecification(int searchId) {
        this.searchId = searchId;
    }

    @Override
    public boolean specify(MyArray myArray) {
        if (myArray.getId() == searchId) {
            logger.info("Found array with ID: {}", searchId);
            return true;
        }

        logger.debug("Array ID {} != search ID {}", myArray.getId(), searchId);
        return false;
    }
}
