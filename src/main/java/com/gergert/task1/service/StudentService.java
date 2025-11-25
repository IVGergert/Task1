package com.gergert.task1.service;

import com.gergert.task1.entity.Student;

public interface StudentService {
    int findMaxAgeForStudent(Student[] Student);
    int findMinAgeForStudent(Student[] Student);
    int findMaxStudentId(Student[] Student);
    int findMinStudentId(Student[] Student);
}
