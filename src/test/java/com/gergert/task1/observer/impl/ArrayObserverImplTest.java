package com.gergert.task1.observer.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {

    ArrayObserverImpl observer = new ArrayObserverImpl();

    @Test
    void updateCalculatesCorrectStatistics() {
        int id = 1;
        CustomArray customArray = new CustomArray(id, new int[] {1, 2, 3, 4, 5});

        observer.update(customArray);

        ArrayData data = ArrayWarehouseImpl.getInstance().get(id);

        assertNotNull(data);
        assertEquals(15, data.sum());
        assertEquals(3.0, data.avg());
        assertEquals(1, data.min());
        assertEquals(5, data.max());
    }

    @Test
    void updateWithEmptyArray(){
        int id = 101;
        CustomArray customArray = new CustomArray(id, new int[]{});

        observer.update(customArray);

        ArrayData data = ArrayWarehouseImpl.getInstance().get(id);
        assertNotNull(data);
        assertEquals(0, data.sum());
        assertEquals(0.0, data.avg());
    }

    @Test
    void updateWithNegativeNumbers(){
        int id = 102;
        CustomArray customArray = new CustomArray(id, new int[]{-10, -20});

        observer.update(customArray);

        ArrayData data = ArrayWarehouseImpl.getInstance().get(id);
        assertEquals(-30, data.sum());
        assertEquals(-15.0, data.avg());
        assertEquals(-20, data.min());
        assertEquals(-10, data.max());
    }
}