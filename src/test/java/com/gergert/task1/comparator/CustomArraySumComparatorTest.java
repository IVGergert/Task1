package com.gergert.task1.comparator;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomArraySumComparatorTest {

    CustomArraySumComparator customArraySumComparator = new CustomArraySumComparator();

    @Test
    void compareNormalArrays() {
        CustomArray arr1 = new CustomArray(1, new int[]{1,5,7,2});
        CustomArray arr2 = new CustomArray(2, new int[]{2,6});

        ArrayData data1 = new ArrayData(0, 0, 0, 15);
        ArrayWarehouseImpl.getInstance().put(arr1.getId(), data1);

        ArrayData data2 = new ArrayData(0, 0, 0, 8);
        ArrayWarehouseImpl.getInstance().put(arr2.getId(), data2);

        assertTrue(customArraySumComparator.compare(arr1, arr2) > 0);
        assertTrue(customArraySumComparator.compare(arr2, arr1) < 0);
    }


    @Test
    void compareEqualsIdArrays() {
        CustomArray arr1 = new CustomArray(3, new int[]{1,5,2});
        CustomArray arr2 = new CustomArray(3, new int[]{1,5,2});

        assertEquals(0, customArraySumComparator.compare(arr1, arr2));
    }
}