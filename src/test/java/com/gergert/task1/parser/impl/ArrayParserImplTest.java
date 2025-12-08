package com.gergert.task1.parser.impl;

import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserImplTest {
    ArrayParserImpl parser = new ArrayParserImpl();

    @Test
    void parseLineWithDashesSuccess() throws CustomException {
        String line = "1 - 2 - 3";
        int[] expected = {1, 2, 3};

        int[] result = parser.parse(line);
        assertArrayEquals(expected, result);
    }

    @Test
    void parseLineWithSpacesSuccess() throws CustomException {
        String line = "1 2 3";
        int[] expected = {1, 2, 3};

        int[] result = parser.parse(line);
        assertArrayEquals(expected, result);
    }

    @Test
    void parseLineWithCommasSuccess() throws CustomException {
        String line = "1,2,3";
        int[] expected = {1, 2, 3};

        int[] result = parser.parse(line);
        assertArrayEquals(expected, result);
    }

    @Test
    void parseError(){
        String line = "dadasd1 - 23sdwae22 1212 3";

        assertThrows(CustomException.class, () -> parser.parse(line));
    }
}