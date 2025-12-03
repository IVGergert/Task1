package com.gergert.task1.parser.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.factory.impl.ArrayFactoryImpl;
import com.gergert.task1.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {
    private static final Logger logger = LogManager.getLogger(ArrayParserImpl.class);
    private final ArrayFactoryImpl factory = new ArrayFactoryImpl();

    private static final String DELIMITER_REGEX = "[\\s,;\\-]+";

    @Override
    public MyArray parse(String line) {
        logger.info("Parsing line: {}", line);

        if (line.isBlank()) {
            return factory.createArray(new int[0]);
        }

        String[] parts = line.trim().split(DELIMITER_REGEX);

        int[] numbers = new int[parts.length];

        for (int i = 0; i < parts.length; i++){
            numbers[i] = Integer.parseInt(parts[i]);
        }

        logger.info("Parsed result:: {}", numbers);
        return factory.createArray(numbers);

    }
}
