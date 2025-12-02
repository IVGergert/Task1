package com.gergert.task1.service;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;

import java.util.OptionalInt;

public interface ArrayCalculationService {
    OptionalInt findMin(MyArray myArray) throws CustomException;
    OptionalInt findMax(MyArray myArray) throws CustomException;
    int findSum(MyArray myArray) throws CustomException;
}
