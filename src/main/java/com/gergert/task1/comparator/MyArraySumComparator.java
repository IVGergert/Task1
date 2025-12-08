package com.gergert.task1.comparator;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;

import java.util.Comparator;

public class MyArraySumComparator implements Comparator<MyArray> {
    @Override
    public int compare(MyArray myArray1, MyArray myArray2) {
        ArrayData arrayData1 = ArrayWarehouseImpl.getInstance().get(myArray1.getId());
        ArrayData arrayData2 = ArrayWarehouseImpl.getInstance().get(myArray2.getId());

        int sum1 = (arrayData1 != null) ? arrayData1.sum() : 0;
        int sum2 = (arrayData2 != null) ? arrayData2.sum() : 0;

        return Integer.compare(sum1, sum2);
    }
}
