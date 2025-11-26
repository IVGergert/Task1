package com.gergert.task1.factory;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface StudentFactory {
    Student createStudent(int id, String name, int age) throws CustomException;
}
