package com.gergert.task1.reader.impl;

import com.gergert.task1.exception.CustomException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReadDataFromFileImplTest {

    ReadDataFromFileImpl readDataFromFile = new ReadDataFromFileImpl();

    @Test
    void readLines(@TempDir Path tempDir) throws IOException, CustomException {
        Path tempFile = tempDir.resolve("test_arrays.txt");

        List<String> expected = Arrays.asList(
                "1, 2, 3",
                "10 - 20",
                "   ",
                "",
                "12121 - 2 2-  2"
        );

        Files.write(tempFile, expected);

        String filePath = tempFile.toString();

        List<String> actual = readDataFromFile.readLines(filePath);

        assertEquals(expected, actual);
    }

    @Test
    void readLinesWhereFileNotFound(){
        String wrongPath = "path/that/does/not/exist.txt";

        assertThrows(CustomException.class, () -> {
            readDataFromFile.readLines(wrongPath);
        });

    }
}