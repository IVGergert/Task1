package com.gergert.task1.observer.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.observer.ArrayObserver;
import com.gergert.task1.warehouse.Warehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class ArrayObserverImpl implements ArrayObserver {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void update(MyArray myArray) {
        int[] array = myArray.getArray();
        final int id = myArray.getId();

        if (array == null || array.length == 0){
            Warehouse.getInstance().put(id, new ArrayData(0, 0, 0, 0));
            logger.info("Array with ID {} is empty or null. Zeros saved.", id);
            return;
        }

        IntSummaryStatistics arrayStats = Arrays.stream(array).summaryStatistics();

        ArrayData data = new ArrayData(
                arrayStats.getMax(),
                arrayStats.getMin(),
                arrayStats.getAverage(),
                (int) arrayStats.getSum()
        );

        Warehouse.getInstance().put(id, data);

        logger.info("New data successfully saved, for ID {}: {}", id, data);
    }
}
