package com.gergert.task1.factory;

import com.gergert.task1.entity.Student;
import com.gergert.task1.exception.CustomException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StudentFactoryImpl implements StudentFactory{
    private static final Logger logger = LogManager.getLogger(StudentFactory.class);

    @Override
    public Student createStudent(int id, String name, int age) throws CustomException{

        if (name == null){
            logger.error("Не удалось создать студента - name = null");
            throw new CustomException("Поля не могут быть пустыми");
        }

        if (id < 0 || age < 0){
            logger.warn("Данные id='{}', age='{}' отрицательны", id, age);
            throw new CustomException("Данные не могут быть отрицательным");
        }

        logger.info("Создание студента: {}", name);
        return new Student(id, name, age);
    }
}
