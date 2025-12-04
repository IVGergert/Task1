package com.gergert.task1.parser;

import com.gergert.task1.exception.CustomException;

public interface ArrayParser {
    int[] parse(String line) throws CustomException;
}
