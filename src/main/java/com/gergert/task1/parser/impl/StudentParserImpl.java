package com.gergert.task1.parser.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.factory.impl.StudentFactoryImpl;
import com.gergert.task1.parser.StudentParser;
import com.gergert.task1.validator.impl.StudentValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentParserImpl implements StudentParser {
    private static final Logger logger = LogManager.getLogger(StudentParserImpl.class);
    private final StudentFactoryImpl studentFactory = new StudentFactoryImpl();
    private final StudentValidatorImpl studentValidator = new StudentValidatorImpl();

    private static final String DELIMITER_REGEX = ("[\\s,;\\-]+");

    @Override
    public Student parseStudent(String line) throws CustomException {
        logger.info("Parsing line: {}", line);

        String[] parts = line.trim().split(DELIMITER_REGEX);

        if (!studentValidator.isValid(parts)) {
            logger.warn("Validation failed for line: {}", line);
            throw new CustomException("Validation failed for line: " + line);
        }

        int id = Integer.parseInt(parts[0]);
        String name = parts[1];
        int age = Integer.parseInt(parts[2]);

        return studentFactory.createStudent(id, name, age);
    }
}
