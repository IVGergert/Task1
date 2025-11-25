package com.gergert.task1.service;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface StudentService {
    int findMaxAgeForStudent(Student[] Student)  throws CustomException;
    int findMinAgeForStudent(Student[] Student)  throws CustomException ;
    int findMaxStudentId(Student[] Student)  throws CustomException ;
    int findMinStudentId(Student[] Student)  throws CustomException ;
}
