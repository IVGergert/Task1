package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.specification.SearchOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CountSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final int targetCount;
    private final SearchOperation operation;

    public CountSpecification(int targetCount, SearchOperation operation) {
        this.targetCount = targetCount;
        this.operation = operation;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        int id = customArray.getId();
        int currentCount = customArray.getSize();

        logger.debug("Checking Count for ID {}: Current {} {} Target {}", id, currentCount, operation, targetCount);

        boolean result = switch (operation) {
            case MORE -> currentCount > targetCount;
            case LESS -> currentCount < targetCount;
            case EQUALS -> currentCount == targetCount;
        };

        if (result) {
            logger.info("Match found: Array ID {} has {} elements (Condition: {} {})", id, currentCount, operation, targetCount);
        }

        return result;
    }
}
