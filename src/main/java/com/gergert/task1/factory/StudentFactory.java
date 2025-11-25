package com.gergert.task1.factory;

import com.gergert.task1.entity.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentFactory {
    private static final Logger logger = LogManager.getLogger(StudentFactory.class);

    public Student createStudent(int id, String name, int age) {
        logger.info("Создание студента: " + name);
        return new Student(id, name, age);
    }



}
