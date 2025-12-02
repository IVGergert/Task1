package com.gergert.task1.validator;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;

public interface ArrayValidator {
    void validate(MyArray myArray) throws CustomException;
}
