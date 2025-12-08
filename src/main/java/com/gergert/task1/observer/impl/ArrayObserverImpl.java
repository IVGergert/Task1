package com.gergert.task1.observer.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.observer.ArrayObserver;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
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

        ArrayWarehouseImpl warehouse = ArrayWarehouseImpl.getInstance();

        if (array == null || array.length == 0){
            logger.warn("Array ID {} is empty. Saving zeros to Warehouse.", id);
            warehouse.put(id, new ArrayData(0, 0, 0, 0));
            return;
        }

        IntSummaryStatistics arrayStats = Arrays.stream(array).summaryStatistics();

        ArrayData data = new ArrayData(
                arrayStats.getMax(),
                arrayStats.getMin(),
                arrayStats.getAverage(),
                (int) arrayStats.getSum()
        );

        warehouse.put(id, data);

        logger.info("Warehouse updated for ID {}: {}", id, data);
    }
}
