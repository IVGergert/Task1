package com.gergert.task1.reader.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.parser.impl.StudentParserImpl;
import com.gergert.task1.reader.StudentReader;
import com.gergert.task1.validator.impl.StudentValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StudentReaderImpl implements StudentReader {
    private static final Logger logger = LogManager.getLogger(StudentReaderImpl.class);
    private final StudentValidatorImpl validator = new StudentValidatorImpl();
    private final StudentParserImpl parser = new StudentParserImpl();

    @Override
    public Student[] readStudentsFromFile(String filePath) throws CustomException {
        logger.info("Reading file: {}", filePath);

        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);

        if (!exists) {
            logger.error("File not found: {}", filePath);
            throw new CustomException("File not found: " + filePath);
        }

        List<String> lines;

        try {
            lines = Files.readAllLines(path);
            logger.info("File read successfully. Total lines: {}", lines.size());
        } catch (IOException e) {
            logger.error("Error reading file: " + filePath, e);
            throw new CustomException("Error reading file: " + filePath, e);
        }

        List<Student> students = new ArrayList<>();

        for (String line : lines) {
            if (validator.isValid(line)){

                try {
                    Student student = parser.parseStudent(line);
                    students.add(student);
                    logger.info("Student created successfully: {}", student);
                } catch (CustomException e){
                    logger.error("Error parsing line '{}': {}", line, e.getMessage());
                }
            } else {
                logger.warn("Skipping invalid line: {}", line);
            }
        }

        logger.info("Finished processing. Total valid students: {}", students.size());
        return students.toArray(new Student[0]);
    }
}


