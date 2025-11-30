package com.gergert.task1.validator.impl;

import com.gergert.task1.validator.StudentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidatorImpl implements StudentValidator {
    private static final Logger logger = LogManager.getLogger(StudentValidatorImpl.class);

    private static final String DELIMITER_REGEX = ("[\\s,;\\-]+");

    private static final Pattern ID_PATTERN = Pattern.compile("^\\d+$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
    private static final Pattern AGE_PATTERN = Pattern.compile("^\\d+$");

    @Override
    public boolean isValid(String line) {
        if (line == null || line.trim().isEmpty()) {
            logger.debug("Line {} is empty or null", line);
            return false;
        }

        String[] parts = line.trim().split(DELIMITER_REGEX);

        if (parts.length != 3) {
            logger.warn("Invalid parts count: {}", line);
            return false;
        }

        String id = parts[0];
        String name = parts[1];
        String age = parts[2];

        if (!ID_PATTERN.matcher(id).matches()){
            logger.warn("Invalid ID format: '{}' in line: {}", id, line);
            return false;
        }

        if (!NAME_PATTERN.matcher(name).matches()){
            logger.warn("Invalid Name format: '{}' in line: {}", name, line);
            return false;
        }

        if (!AGE_PATTERN.matcher(age).matches()){
            logger.warn("Invalid Age format: '{}' in line: {}", age, line);
            return false;
        }

        return true;
    }
}
