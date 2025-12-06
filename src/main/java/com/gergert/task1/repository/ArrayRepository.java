package com.gergert.task1.repository;


import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;

import java.util.Optional;

public interface ArrayRepository {
    void save (MyArray myArray) throws CustomException;
    void remove (MyArray myArray) throws CustomException;
    Optional<MyArray> findMyArrayById(int id);

}
