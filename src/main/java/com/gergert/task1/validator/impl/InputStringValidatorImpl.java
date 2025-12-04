package com.gergert.task1.validator.impl;

import com.gergert.task1.validator.InputStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class InputStringValidatorImpl implements InputStringValidator {

    private static final Logger logger = LogManager.getLogger(InputStringValidatorImpl.class);
    private static final Pattern DELIMITER_PATTERN = Pattern.compile("[\\s,;\\-]+");
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+$");

    @Override
    public boolean isValid(String line) {
        logger.info("Validation line: {}", line);

        if (line == null || line.isBlank()) {
            logger.debug("Validation failed: line is null or empty");
            return false;
        }

        String[] parts = DELIMITER_PATTERN.split(line.strip());

        for (String part : parts) {
            if (!NUMBER_PATTERN.matcher(part).matches()) {
                logger.warn("Validation failed. Not a number: '{}' in line: {}", part, line);
                return false;
            }
        }

        logger.debug("Validation successful for line: {}", line);
        return true;
    }
}
