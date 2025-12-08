package com.gergert.task1.repository;


import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface MyArrayRepository {
    void add (MyArray myArray) throws CustomException;
    void remove (MyArray myArray) throws CustomException;
    Optional<MyArray> findArrayById(int id);

    List<MyArray> query(ArraySpecification specification);
    List<MyArray> sort(Comparator<MyArray> comparator);
}
