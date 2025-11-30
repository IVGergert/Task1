package com.gergert.task1.factory.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.factory.StudentFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentFactoryImpl implements StudentFactory {
    private static final Logger logger = LogManager.getLogger(StudentFactory.class);

    @Override
    public Student createStudent(int id, String name, int age) throws CustomException {

        if (name == null){
            logger.error("Failed to create student - name = null");
            throw new CustomException("Fields cannot be empty");
        }

        if (id < 0 || age < 0){
            logger.warn("The data id='{}', age='{}' are negative", id, age);
            throw new CustomException("The data cannot be negative");
        }

        logger.debug("Creating a student: ID={}, Name={}, Age={}", id, name, age);
        return new Student(id, name, age);
    }
}
