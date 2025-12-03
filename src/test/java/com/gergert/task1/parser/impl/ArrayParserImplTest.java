package com.gergert.task1.parser.impl;

import com.gergert.task1.entity.MyArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserImplTest {
    ArrayParserImpl parser = new ArrayParserImpl();


    @Test
    void parse() {
        String line = "1 - 2 - 3";
        MyArray expected = new MyArray(new int[] {1, 2, 3});

        MyArray result = parser.parse(line);
        assertEquals(expected, result);
    }
}