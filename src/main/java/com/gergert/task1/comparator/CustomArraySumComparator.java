package com.gergert.task1.comparator;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;

import java.util.Comparator;

public class CustomArraySumComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        ArrayData arrayData1 = ArrayWarehouseImpl.getInstance().get(customArray1.getId());
        ArrayData arrayData2 = ArrayWarehouseImpl.getInstance().get(customArray2.getId());

        int sum1 = (arrayData1 != null) ? arrayData1.sum() : 0;
        int sum2 = (arrayData2 != null) ? arrayData2.sum() : 0;

        return Integer.compare(sum1, sum2);
    }
}
