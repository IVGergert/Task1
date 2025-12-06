package com.gergert.task1.observer.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.observer.ArrayObserver;
import com.gergert.task1.warehouse.Warehouse;

public class ArrayObserverImpl implements ArrayObserver {
    @Override
    public void update(MyArray myArray) {
        int[] array = myArray.getArray();
        final int id = myArray.getId();

        if (array == null || array.length == 0){
            Warehouse.getInstance().put(id, new ArrayData(0, 0, 0, 0.0));
            return;
        }

    }
}
