package com.gergert.task1.validator.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorImplTest {

    ArrayValidatorImpl validator = new ArrayValidatorImpl();

    @Test
    void validateWhenArrayNull() {
        MyArray nullArray = null;

        assertThrows(CustomException.class, () -> {
            validator.validate(nullArray);
        });
    }

    @Test
    void validateWhenArrayEmpty() {
        MyArray emptyArray = new MyArray(new int[0]);

        assertThrows(CustomException.class, () -> {
            validator.validate(emptyArray);
        });
    }


    @Test
    void validateSuccess() {
        MyArray validArray = new MyArray(new int[]{1, 2, 3});

        assertDoesNotThrow(() -> {
            validator.validate(validArray);
        });
    }
}