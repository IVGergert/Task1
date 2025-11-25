package com.gergert.task1.factory;

import com.gergert.task1.entity.Student;

import java.util.logging.Logger;

public class StudentFactory {
    private static final Logger logger = Logger.getLogger(String.valueOf(StudentFactory.class));

    public static Student createStudent(int id, String name, int age) {
        logger.info("Создание студента: " + name);
        return new Student(id, name, age);
    }



}
