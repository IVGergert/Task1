package com.gergert.task1.parser;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface StudentParser {
    Student parseStudent(String line) throws CustomException;
}
