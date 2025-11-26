package com.gergert.task1.service;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface StudentService {
    int findMaxAgeForStudent(Student[] Students) throws CustomException;
    int findMinAgeForStudent(Student[] Students) throws CustomException;
    int findMaxStudentId(Student[] Students) throws CustomException;
    int findMinStudentId(Student[] Students) throws CustomException;
    int calculateTotalAge(Student[] students) throws CustomException;
}
