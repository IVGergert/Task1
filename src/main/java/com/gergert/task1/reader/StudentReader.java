package com.gergert.task1.reader;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;

public interface StudentReader {
    Student[] readStudentsFromFile(String filePath) throws CustomException;
}
