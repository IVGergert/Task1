package com.gergert.task1.service.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceImplTest {

    StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
    static Student[] students;

    @BeforeAll
    static void setUp() {
        students = new Student[] {
                new Student(1, "Илья", 16),
                new Student(2, "Алексей", 20),
                new Student(3, "Николай", 34),
                new Student(4, "Владимир", 19),
                new Student(5, "Генадий", 55),
        };
    }

    @Test
    void findMaxAgeForStudent() throws CustomException {
        int expected = 55;
        int actual = studentServiceImpl.findMaxAgeForStudent(students);
        assertEquals(expected, actual);
    }

    @Test
    void findMinAgeForStudent() throws CustomException {
        int expected = 16;
        int actual = studentServiceImpl.findMinAgeForStudent(students);
        assertEquals(expected, actual);
    }

    @Test
    void findMaxStudentId() throws CustomException {
        int expected = 5;
        int actual = studentServiceImpl.findMaxStudentId(students);
        assertEquals(expected, actual);
    }

    @Test
    void findMinStudentId() throws CustomException {
        int expected = 1;
        int actual = studentServiceImpl.findMinStudentId(students);
        assertEquals(expected, actual);
    }

    @Test
    void calculateTotalAge() throws CustomException {
        int expected = 144;
        int actual = studentServiceImpl.calculateTotalAge(students);
        assertEquals(expected, actual);
    }
}