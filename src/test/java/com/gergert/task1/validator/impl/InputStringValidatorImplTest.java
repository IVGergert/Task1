package com.gergert.task1.validator.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputStringValidatorImplTest {

    InputStringValidatorImpl validator = new InputStringValidatorImpl();

    @Test
    void validateSuccess() {
        String line = "1, 2; 3 - 4";

        boolean result = validator.isValid(line);
        assertTrue(result);
    }

    @Test
    void validateWhenStringNull() {
        boolean result = validator.isValid(null);
        assertFalse(result);
    }

    @Test
    void validateWhenStringIsBlank() {
        boolean result = validator.isValid("           ");
        assertFalse(result);
    }
}