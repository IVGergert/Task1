package com.gergert.task1.repository;


import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.specification.ArraySpecification;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public interface CustomArrayRepository {
    void add (CustomArray customArray) throws CustomException;
    void remove (CustomArray customArray) throws CustomException;
    Optional<CustomArray> findArrayById(int id);

    List<CustomArray> query(ArraySpecification specification);
    List<CustomArray> sort(Comparator<CustomArray> comparator);
}
