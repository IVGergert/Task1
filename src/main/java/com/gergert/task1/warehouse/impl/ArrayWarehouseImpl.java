package com.gergert.task1.warehouse.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.warehouse.ArrayWarehouse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouseImpl implements ArrayWarehouse{
    private static final Logger logger = LogManager.getLogger();

    private static ArrayWarehouseImpl instance;
    private final Map<Integer, ArrayData> storage = new HashMap<>();;

    private ArrayWarehouseImpl() {
    }

    public static ArrayWarehouseImpl getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouseImpl();
        }
        return instance;
    }

    @Override
    public void put(int id, ArrayData data) {
        storage.put(id, data);
    }

    @Override
    public ArrayData get(int id) {
        return storage.get(id);
    }

    @Override
    public void remove(int id) {
        storage.remove(id);
        logger.info("Data removed from warehouse for ID: {}", id);
    }
}
