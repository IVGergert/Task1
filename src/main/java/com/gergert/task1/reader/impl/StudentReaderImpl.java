package com.gergert.task1.reader.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.parser.impl.StudentParserImpl;
import com.gergert.task1.reader.StudentReader;
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
    private final StudentParserImpl parser = new StudentParserImpl();

    @Override
    public Student[] readStudentsFromFile(String filePath) throws CustomException {
        logger.info("Reading file: {}", filePath);

        List<String> lines = readLinesFromFile(filePath);

        List<Student> students = parseLinesToStudents(lines);

        logger.info("Finished processing. Total valid students: {}", students.size());
        return students.toArray(new Student[0]);
    }

    private List<String> readLinesFromFile(String filePath) throws CustomException{
        Path path = Paths.get(filePath);
        boolean exists = Files.exists(path);

        if (!exists) {
            logger.error("File not found: {}", filePath);
            throw new CustomException("File not found: " + filePath);
        }

        try {
            List<String> lines = Files.readAllLines(path);
            logger.info("File read successfully. Total lines: {}", lines.size());
            return lines;
        } catch (IOException e) {
            logger.error("Error reading file: {}", filePath, e);
            throw new CustomException("Error reading file: " + filePath, e);
        }
    }

    private List<Student> parseLinesToStudents(List<String> lines) {
        List<Student> students = new ArrayList<>();

        for (String line : lines) {
            if (line.isEmpty()) {
                logger.warn("Skipping isEmpty line: {}", line);
                continue;
            }

            try {
                Student student = parser.parseStudent(line);
                students.add(student);
                logger.info("Student created successfully: {}", student);
            } catch (CustomException e) {
                logger.warn("Skipping invalid line: {}, Reason: {}", line, e.getMessage());
            }
        }

        return students;
    }
}


