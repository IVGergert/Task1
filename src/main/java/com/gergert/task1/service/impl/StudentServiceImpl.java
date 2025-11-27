package com.gergert.task1.service.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Override
    public int findMaxAgeForStudent(Student[] students) throws CustomException {
        if (students == null || students.length == 0) {
            logger.error("Attempt to search in empty array");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        int maxAge = students[0].getAge();

        for (Student student : students) {
            if (student.getAge() > maxAge){
                maxAge = student.getAge();
            }
        }

        logger.info("Max student age found: {}",  maxAge);
        return maxAge;
    }

    @Override
    public int findMinAgeForStudent(Student[] students) throws CustomException  {
        if (students == null || students.length == 0){
            logger.error("Array is empty or null");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        int minAge = students[0].getAge();

        for (Student student : students) {
            if (student.getAge() < minAge){
                minAge = student.getAge();
            }
        }

        logger.info("Min student age found: {}",  minAge);
        return minAge;
    }

    @Override
    public int findMaxStudentId(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Array is empty or null");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        int maxStudentId = students[0].getStudentId();

        for (Student student : students) {
            if (student.getStudentId() > maxStudentId){
                maxStudentId = student.getStudentId();
            }
        }

        logger.info("Max student ID found: {}", maxStudentId);
        return maxStudentId;
    }

    @Override
    public int findMinStudentId(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Array is empty or null");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        int minStudentId = students[0].getStudentId();

        for (Student student : students) {
            if (student.getStudentId() < minStudentId){
                minStudentId = student.getStudentId();
            }
        }

        logger.info("Min student ID found: {}", minStudentId);
        return minStudentId;
    }

    @Override
    public int calculateTotalAge(Student[] students) throws CustomException{
        if (students == null || students.length == 0){
            logger.error("Array is empty or null");
            throw new CustomException("Array is empty or null");
        }

        if (students[0] == null) {
            logger.error("First element is null");
            throw new CustomException("First element is null");
        }

        int totalAge = 0;

        for (Student student : students) {
            totalAge += student.getAge();
        }

        logger.info("Total student age calculated: {}", totalAge);
        return totalAge;
    }
}
