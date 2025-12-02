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
    private static final Logger logger = LogManager.getLogger(ReadDataFromFileImpl.class);

    @Override
    public List<String> readLines(String filePath) throws CustomException {
        logger.info("Attempting to read file from path: {}", filePath);

        Path path = Paths.get(filePath);

        if (Files.exists(path)){
            try {
                logger.info("Success on reading file");
                return Files.readAllLines(path);
            } catch (IOException e) {
                logger.error("IO Exception while reading file: {}", filePath, e);
                throw new CustomException("Error reading file: " + e.getMessage(), e);
            }
        } else {
            logger.error("File not found");
            throw new CustomException("File not found: " + filePath);
        }
    }
}
