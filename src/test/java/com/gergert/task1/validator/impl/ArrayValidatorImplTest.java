package com.gergert.task1.validator.impl;

import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayValidatorImplTest {

    ArrayValidatorImpl validator = new ArrayValidatorImpl();

    @Test
    void validateWhenArrayNull() {
        assertThrows(CustomException.class, () -> {
            validator.validateArray(null);
        });
    }

    @Test
    void validateWhenArrayEmpty() {
        CustomArray emptyArray = new CustomArray(new int[0]);

        assertThrows(CustomException.class, () -> {
            validator.validateArray(emptyArray);
        });
    }

    @Test
    void validateSuccess() {
        CustomArray validArray = new CustomArray(new int[]{1, 2, 3});

        assertDoesNotThrow(() -> {
            validator.validateArray(validArray);
        });
    }
}