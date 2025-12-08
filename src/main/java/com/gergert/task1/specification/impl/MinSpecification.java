package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.specification.SearchOperation;
import com.gergert.task1.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final int valueToCompare;
    private final SearchOperation operation;

    public MinSpecification(int valueToCompare, SearchOperation operation) {
        this.valueToCompare = valueToCompare;
        this.operation = operation;
    }

    @Override
    public boolean specify(MyArray myArray) {
        int id = myArray.getId();
        ArrayData data = Warehouse.getInstance().get(id);

        if (data == null) {
            logger.error("No statistics found in Warehouse for Array ID: {}", id);
            return false;
        }

        int currentMin = data.min();

        logger.debug("Checking Min for ID {}: (Condition: {} {} {})", id, currentMin, operation, valueToCompare);

        return switch (operation) {
            case MORE -> currentMin > valueToCompare;
            case LESS -> currentMin < valueToCompare;
            case EQUALS -> currentMin == valueToCompare;
        };
    }
}
