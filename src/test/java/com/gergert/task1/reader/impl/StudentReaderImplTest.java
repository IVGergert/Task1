package com.gergert.task1.reader.impl;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentReaderImplTest {

    StudentReaderImpl reader = new StudentReaderImpl();

    @TempDir
    Path tempDir;

    @Test
    void testReadStudentsFromFile() throws CustomException, IOException {
        List<String> lines = Arrays.asList(
                "1, Ivan, 20",
                "   ",
                "2 - ddfsf2323 - 12",
                "2 - Petr - 25",
                "3sdasd, Anw121na, 20yasd"
        );

        Path file = tempDir.resolve("test_data.txt");
        Files.write(file, lines);
        String filePath = file.toString();

        Student[] expected = {
                new Student(1, "Ivan", 20),
                new Student(2, "Petr", 25)
        };

        Student[] actual = reader.readStudentsFromFile(filePath);

        assertArrayEquals(expected, actual);
    }

    @Test
    void readStudentsFromFile_ShouldThrowException_WhenFileNotFound() {
        String path = "data/file.txt";

        assertThrows(CustomException.class, () -> {
            reader.readStudentsFromFile(path);
        });
    }


}