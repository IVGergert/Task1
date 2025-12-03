package com.gergert.task1.reader.impl;

import com.gergert.task1.exception.CustomException;
import com.gergert.task1.reader.ReadDataFromFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadDataFromFileImpl implements ReadDataFromFile {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readLines(String filePath) throws CustomException {
        logger.info("Reading file: {}", filePath);

        Path path = Paths.get(filePath);

        if (!Files.exists(path)) {
            logger.error("File not found at path: {}", filePath);
            throw new CustomException("File not found: " + filePath);
        }

        try {
            logger.info("Success on reading file");
            return Files.readAllLines(path);
        } catch (IOException e) {
            logger.error("IO Exception while reading file: {}", filePath, e);
            throw new CustomException("Error reading file: " + e.getMessage(), e);
        }
    }
}
