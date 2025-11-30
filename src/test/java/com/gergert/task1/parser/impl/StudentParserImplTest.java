package com.gergert.task1.parser.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class StudentParserImplTest {

    StudentParserImpl parser = new StudentParserImpl();

    @Test
    void parseStudent() throws CustomException {
        Student expected = new Student(1,"Ivan",20);
        String line = "1, Ivan, 20";
        Student actual = parser.parseStudent(line);
        assertEquals(expected, actual);
    }

    @Test
    void parseStudent_ShouldThrowException_WhenIdIsInvalid(){
        String line = "1as, Ivan, 20";
        assertThrows(CustomException.class, () -> {
            parser.parseStudent(line);
        });
    }

    @Test
    void parseStudent_ShouldThrowException_WhenAgeIsInvalid(){
        String line = "1, Ivan, 20sdsdsd";
        assertThrows(CustomException.class, () -> {
            parser.parseStudent(line);
        });
    }

    @Test
    void parseStudent_ShouldThrowException_WhenNameIsInvalid(){
        String line = "1, Iva1sd1212ada1212n, 20";
        assertThrows(CustomException.class, () -> {
            parser.parseStudent(line);
        });
    }
}