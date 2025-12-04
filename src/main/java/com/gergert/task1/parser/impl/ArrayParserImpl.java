package com.gergert.task1.parser.impl;

import com.gergert.task1.exception.CustomException;
import com.gergert.task1.parser.ArrayParser;
import com.gergert.task1.validator.impl.InputStringValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger logger = LogManager.getLogger();
    private final InputStringValidatorImpl validator = new InputStringValidatorImpl();

    private static final String DELIMITER_REGEX = "[\\s,;\\-]+";

    @Override
    public int[] parse(String line) throws CustomException {
        logger.info("Parsing line: {}", line);

        if (!validator.isValid(line)){
            logger.error("Invalid line format: {}", line);
            throw new CustomException("Invalid line format: " + line);
        }

        String[] parts = line.strip().split(DELIMITER_REGEX);

        int[] array = new int[parts.length];

        for (int i = 0; i < parts.length; i++){
            array[i] = Integer.parseInt(parts[i]);
        }

        logger.info("Parsed result: {}", array);
        return array;
    }
}
