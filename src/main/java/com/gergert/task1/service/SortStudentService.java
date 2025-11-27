package com.gergert.task1.service;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface SortStudentService {
    Student[] bubbleSortById(Student[] students) throws CustomException;
    Student[] selectionSortById(Student[] students) throws CustomException;
}
