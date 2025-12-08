package com.gergert.task1.comparator;

import com.gergert.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayFirstElementComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return Integer.compare(customArray1.getFirstElement(), customArray2.getFirstElement());
    }
}
