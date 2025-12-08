package com.gergert.task1.service;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;

import java.util.OptionalInt;

public interface ArrayCalculationService {
    OptionalInt findMin(CustomArray customArray) throws CustomException;
    OptionalInt findMax(CustomArray customArray) throws CustomException;
    int findSum(CustomArray customArray) throws CustomException;
}
