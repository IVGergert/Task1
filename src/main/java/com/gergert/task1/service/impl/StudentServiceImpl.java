package com.gergert.task1.service.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentServiceImpl implements StudentService{

    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Override
    public int findMaxAgeForStudent(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Студенты не найдены");
            throw new CustomException("Студенты не найдены");
        }

        if (students[0] == null) {
            logger.error("Первый элемент null");
            throw new CustomException("Первый элемент null");
        }

        int maxAge = students[0].getAge();

        for (Student student : students) {
            if (student.getAge() > maxAge){
                maxAge = student.getAge();
            }
        }

        logger.info("Максимальный возраст студента найден: {}",  maxAge);
        return maxAge;
    }

    @Override
    public int findMinAgeForStudent(Student[] students) throws CustomException  {
        if (students == null || students.length == 0){
            logger.error("Студенты не найдены");
            throw new CustomException("Студенты не найдены");
        }

        if (students[0] == null) {
            logger.error("Первый элемент null");
            throw new CustomException("Первый элемент null");
        }

        int minAge = students[0].getAge();

        for (Student student : students) {
            if (student.getAge() < minAge){
                minAge = student.getAge();
            }
        }

        logger.info("Минимальный возраст студента найден: {}",  minAge);
        return minAge;
    }

    @Override
    public int findMaxStudentId(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Студенты не найдены");
            throw new CustomException("Студенты не найдены");
        }

        if (students[0] == null) {
            logger.error("Первый элемент null");
            throw new CustomException("Первый элемент null");
        }

        int maxStudentId = students[0].getStudentId();

        for (Student student : students) {
            if (student.getStudentId() > maxStudentId){
                maxStudentId = student.getStudentId();
            }
        }

        logger.info("Максимальный id студента найден: {}", maxStudentId);
        return maxStudentId;
    }

    @Override
    public int findMinStudentId(Student[] students) throws CustomException {
        if (students == null || students.length == 0){
            logger.error("Студенты не найдены");
            throw new CustomException("Студенты не найдены");
        }

        if (students[0] == null) {
            logger.error("Первый элемент null");
            throw new CustomException("Первый элемент null");
        }

        int minStudentId = students[0].getStudentId();

        for (Student student : students) {
            if (student.getStudentId() < minStudentId){
                minStudentId = student.getStudentId();
            }
        }

        logger.info("Минимальный id студента найден: {}", minStudentId);
        return minStudentId;
    }

    public int calculateTotalAge(Student[] students) throws CustomException{
        if (students == null || students.length == 0){
            logger.error("Студенты не найдены");
            throw new CustomException("Студенты не найдены");
        }

        if (students[0] == null) {
            logger.error("Первый элемент null");
            throw new CustomException("Первый элемент null");
        }

        int calculateTotalAge = 0;

        for (Student student : students) {
            calculateTotalAge += student.getAge();
        }

        logger.info("Общий возраст студентов подсчитан: {}", calculateTotalAge);
        return calculateTotalAge;
    }
}
