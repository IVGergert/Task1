package com.gergert.task1.specification.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.specification.ArraySpecification;

public class IdSpecification implements ArraySpecification {
    private final int searchId;

    public IdSpecification(int searchId) {
        this.searchId = searchId;
    }

    @Override
    public boolean specify(CustomArray customArray) {
        if (customArray.getId() == searchId) {
            return true;
        }
        return false;
    }
}
