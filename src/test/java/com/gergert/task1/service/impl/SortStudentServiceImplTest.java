package com.gergert.task1.service.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortStudentServiceImplTest {

    SortStudentServiceImpl sortStudentService = new SortStudentServiceImpl();
    static Student[] students;
    static Student[] expected;

    @BeforeAll
    static void setUp() {
        students = new Student[] {
                new Student(7, "Илья", 16),
                new Student(3, "Алексей", 20),
                new Student(9, "Николай", 34),
                new Student(2, "Владимир", 19),
                new Student(1, "Генадий", 55)
        };

        expected = new Student[] {
                new Student(1, "Генадий", 55),
                new Student(2, "Владимир", 19),
                new Student(3, "Алексей", 20),
                new Student(7, "Илья", 16),
                new Student(9, "Николай", 34)
        };
    }

    @Test
    void bubbleSortById() throws CustomException {
        Student[] actual = sortStudentService.bubbleSortById(students);
        assertArrayEquals(expected, actual);

    }

    @Test
    void selectionSortById() throws CustomException {
        Student[] actual = sortStudentService.selectionSortById(students);
        assertArrayEquals(expected, actual);
    }
}