package com.gergert.task1.reader;

import com.gergert.task1.exception.CustomException;

import java.util.List;

public interface ReadDataFromFile {
    List<String> readLines(String filePath) throws CustomException;
}
