package com.gergert.task1.service.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.service.SortStudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SortStudentServiceImpl implements SortStudentService {
    private static final Logger logger = LogManager.getLogger(SortStudentServiceImpl.class);

    @Override
    public Student[] bubbleSortById(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Attempt to sort empty array");
            throw new CustomException("Array is empty or null");
        }

        Student[] sortedStudents = Arrays.copyOf(students, students.length);

        boolean swapped;

        for (int i = 0; i < sortedStudents.length - 1; i++){
            swapped = false;
            for (int j = 0; j < sortedStudents.length - i - 1; j++){
                if (sortedStudents[j] != null && sortedStudents[j + 1] != null){
                    if (sortedStudents[j].getStudentId() > sortedStudents[j + 1].getStudentId()) {
                        Student temp = sortedStudents[j];
                        sortedStudents[j] = sortedStudents[j + 1];
                        sortedStudents[j + 1] = temp;
                        swapped = true;
                    }
                }
            }

            if (!swapped) {
                break;
            }
        }

        logger.info("Bubble sort finished");
        return sortedStudents;
    }

    @Override
    public Student[] selectionSortById(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Attempt to calculate sum in empty array");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        Student[] sortedStudents = Arrays.copyOf(students, students.length);

        for (int i = 0; i < sortedStudents.length - 1; i++){
            int minIndex = i;
            for (int j = i + 1; j < sortedStudents.length; j++){
                if (sortedStudents[j] != null && sortedStudents[minIndex] != null){
                    if (sortedStudents[j].getStudentId() < sortedStudents[minIndex].getStudentId()) {
                        minIndex = j;
                    }
                } else {
                    logger.error("Current and next elements is null");
                    throw new CustomException("Current and next elements is null");
                }
            }

            Student temp = sortedStudents[minIndex];
            sortedStudents[minIndex] = sortedStudents[i];
            sortedStudents[i] = temp;

        }
        logger.info("Selection sort finished");

        return sortedStudents;
    }
}
