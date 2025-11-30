package com.gergert.task1.validator.impl;

import com.gergert.task1.validator.StudentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class StudentValidatorImpl implements StudentValidator {
    private static final Logger logger = LogManager.getLogger(StudentValidatorImpl.class);

    private static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
    private static final Pattern AGE_PATTERN = Pattern.compile("^\\d+$");

    @Override
    public boolean isValid(String[] parts) {
        if (parts.length != 3) {
            logger.warn("Invalid parts count: {}", parts.length);
            return false;
        }

        if (!ID_PATTERN.matcher(parts[0]).matches()){
            logger.warn("Invalid ID format: '{}'", parts[0]);
            return false;
        }

        if (!NAME_PATTERN.matcher(parts[1]).matches()){
            logger.warn("Invalid Name format: '{}'", parts[1]);
            return false;
        }

        if (!AGE_PATTERN.matcher(parts[2]).matches()){
            logger.warn("Invalid Age format: '{}'", parts[2]);
            return false;
        }

        return true;
    }
}
