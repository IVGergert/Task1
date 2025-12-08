package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.specification.SearchOperation;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageSpecification implements ArraySpecification {
    private static final Logger logger = LogManager.getLogger();
    private final int valueToCompare;
    private final SearchOperation operation;

    public AverageSpecification(int valueToCompare, SearchOperation operation) {
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

        double currentAvg = data.avg();

        logger.debug("Checking Avg for ID {}: (Condition: {} {} {})", id, currentAvg, operation, valueToCompare);

        return switch (operation) {
            case MORE -> currentAvg > valueToCompare;
            case LESS -> currentAvg < valueToCompare;
            case EQUALS -> currentAvg == valueToCompare;
        };
    }
}
