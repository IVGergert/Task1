package com.gergert.task1.comparator;

import com.gergert.task1.entity.CustomArray;

import java.util.Comparator;

public class CustomArrayIdComparator implements Comparator<CustomArray> {

    @Override
    public int compare(CustomArray customArray1, CustomArray customArray2) {
        return Integer.compare(customArray1.getId(), customArray2.getId());
    }
}
