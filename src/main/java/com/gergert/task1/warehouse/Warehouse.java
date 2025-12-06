package com.gergert.task1.warehouse;

import com.gergert.task1.entity.ArrayData;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static Warehouse instance;
    private Map<Integer, ArrayData> cache;

    private Warehouse() {
        cache = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public void put(Integer id, ArrayData data) {
        cache.put(id, data);
    }

    public ArrayData get(Integer id) {
        return cache.get(id);
    }
}
