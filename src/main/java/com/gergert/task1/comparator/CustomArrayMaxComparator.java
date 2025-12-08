package com.gergert.task1.comparator;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;

import java.util.Comparator;

public class CustomArrayMaxComparator implements Comparator<CustomArray> {
    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        ArrayData arrayData1 = ArrayWarehouseImpl.getInstance().get(customArray1.getId());
        ArrayData arrayData2 = ArrayWarehouseImpl.getInstance().get(customArray2.getId());

        int max1 = (arrayData1 != null) ? arrayData1.max() : 0;
        int max2 = (arrayData2 != null) ? arrayData2.max() : 0;

        return Integer.compare(max1, max2);
    }
}
