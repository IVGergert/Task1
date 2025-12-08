package com.gergert.task1.service;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;

public interface ArraySortService {
    void bubbleSort(CustomArray customArray) throws CustomException;
    void selectionSort(CustomArray customArray) throws CustomException;
}
