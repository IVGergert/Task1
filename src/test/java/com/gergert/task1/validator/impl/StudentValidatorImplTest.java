package com.gergert.task1.validator.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StudentValidatorImplTest {

    StudentValidatorImpl studentValidator = new StudentValidatorImpl();

    @Test
    void validateParts_ShouldReturnTrue_WhenDataIsCorrect() {
        String[] parts = {"1", "Ivan", "20"};
        boolean actual = studentValidator.isValid(parts);
        assertTrue(actual);
    }

    @Test
    void validateParts_ShouldReturnFalse_WhenIdInvalid() {
        String[] parts = {"1a", "Ivan", "20"};
        boolean actual = studentValidator.isValid(parts);
        assertFalse(actual);
    }

    @Test
    void validateParts_ShouldReturnFalse_WhenNameInvalid() {
        String[] parts = {"1", "Ivan777", "20"};
        boolean actual = studentValidator.isValid(parts);
        assertFalse(actual);
    }

    @Test
    void validateParts_ShouldReturnFalse_WhenLengthInvalid() {
        String[] parts = {"1", "Ivan"};
        boolean actual = studentValidator.isValid(parts);
        assertFalse(actual);
    }
}