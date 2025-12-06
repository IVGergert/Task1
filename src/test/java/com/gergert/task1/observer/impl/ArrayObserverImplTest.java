package com.gergert.task1.observer.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.MyArray;
import com.gergert.task1.warehouse.Warehouse;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {

    ArrayObserverImpl observer = new ArrayObserverImpl();

    @Test
    void updateCalculatesCorrectStatistics() {
        int id = 1;
        MyArray myArray = new MyArray(id, new int[] {1, 2, 3, 4, 5});

        observer.update(myArray);

        ArrayData data = Warehouse.getInstance().get(id);

        assertNotNull(data);
        assertEquals(15, data.sum());
        assertEquals(3.0, data.avg());
        assertEquals(1, data.min());
        assertEquals(5, data.max());
    }

    @Test
    void updateWithEmptyArray(){
        int id = 101;
        MyArray myArray = new MyArray(id, new int[]{});

        observer.update(myArray);

        ArrayData data = Warehouse.getInstance().get(id);
        assertNotNull(data);
        assertEquals(0, data.sum());
        assertEquals(0.0, data.avg());
    }

    @Test
    void updateWithNegativeNumbers(){
        int id = 102;
        MyArray myArray = new MyArray(id, new int[]{-10, -20});

        observer.update(myArray);

        ArrayData data = Warehouse.getInstance().get(id);
        assertEquals(-30, data.sum());
        assertEquals(-15.0, data.avg());
        assertEquals(-20, data.min());
        assertEquals(-10, data.max());
    }
}