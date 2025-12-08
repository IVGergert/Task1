package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.specification.SearchOperation;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MaxSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final int valueToCompare;
    private final SearchOperation operation;

    public MaxSpecification(int valueToCompare, SearchOperation operation) {
        this.valueToCompare = valueToCompare;
        this.operation = operation;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        int id = customArray.getId();
        ArrayData data = ArrayWarehouseImpl.getInstance().get(id);

        if (data == null) {
            logger.error("No statistics found in Warehouse for Array ID: {}", id);
            return false;
        }

        int currentMax = data.max();

        logger.debug("Checking Max for ID {}: (Condition: {} {} {})", id, currentMax, operation, valueToCompare);

        return switch (operation) {
            case MORE -> currentMax > valueToCompare;
            case LESS -> currentMax  < valueToCompare;
            case EQUALS -> currentMax  == valueToCompare;
        };
    }
}
