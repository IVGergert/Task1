package com.gergert.task1.warehouse;

import com.gergert.task1.entity.ArrayData;

public interface ArrayWarehouse {
    void put(int id, ArrayData data);
    ArrayData get(int id);
    void remove(int id);
}
