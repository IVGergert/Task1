package com.gergert.task1.service;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;

public interface ArraySortingService {
    void bubbleSort(MyArray myArray) throws CustomException;
    void selectionSort(MyArray myArray) throws CustomException;
}
