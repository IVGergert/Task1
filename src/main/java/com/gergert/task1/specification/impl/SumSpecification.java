package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.specification.SearchOperation;
import com.gergert.task1.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final double valueToCompare;
    private final SearchOperation operation;

    public SumSpecification(double valueToCompare, SearchOperation operation) {
        this.valueToCompare = valueToCompare;
        this.operation = operation;
    }

    @Override
    public boolean specify(MyArray myArray) {
        int id = myArray.getId();

        double currentSum = Warehouse.getInstance().get(id).sum();

        logger.debug("Checking Array ID: {}. Current Sum: {} {} Target: {}", id, currentSum, operation, valueToCompare);

        boolean result = switch (operation){
            case MORE -> currentSum > valueToCompare;
            case LESS -> currentSum < valueToCompare;
            case EQUALS -> currentSum == valueToCompare;
            default -> false;
        };

        if (result){
            logger.info("Match found: Array ID {} satisfies condition.", id);
        }

        return result;
    }
}
