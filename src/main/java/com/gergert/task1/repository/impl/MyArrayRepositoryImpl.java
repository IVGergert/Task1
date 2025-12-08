package com.gergert.task1.repository.impl;

import com.gergert.task1.entity.MyArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.observer.ArrayObserver;
import com.gergert.task1.observer.impl.ArrayObserverImpl;
import com.gergert.task1.repository.MyArrayRepository;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class MyArrayRepositoryImpl implements MyArrayRepository {
    private static final Logger logger = LogManager.getLogger();

    private static MyArrayRepositoryImpl instance;
    private final List<MyArray> storage = new ArrayList<>();

    private MyArrayRepositoryImpl(){
    }

    public static MyArrayRepository getInstance() {
        if (instance == null) {
            instance = new MyArrayRepositoryImpl();
        }
        return instance;
    }

    @Override
    public void add(MyArray myArray) throws CustomException {
        final int id = myArray.getId();

        if (findArrayById(id).isPresent()) {
            logger.error("Array with ID {} already exists.", id);
            throw new CustomException("Array with ID " + id + " already exists.");
        }

        logger.info("Saved array ID {}", id);

        storage.add(myArray);
        ArrayObserver observer = new ArrayObserverImpl();
        myArray.addArrayObserver(observer);
        myArray.notifyArrayObservers();

        logger.info("Array ID {} successfully added.", id);

    }

    @Override
    public void remove(MyArray myArray) throws CustomException {
        final int id = myArray.getId();

        if (!storage.contains(myArray)) {
            logger.error("Attempt to remove non-existent array ID {}", id);
            throw new CustomException("Array with ID " + id + " not found in repository.");
        }

        storage.remove(myArray);
        ArrayWarehouseImpl.getInstance().remove(id);
        myArray.removeArrayObserver(null);

        logger.info("Array ID {} removed successfully.", id);
    }

    @Override
    public Optional<MyArray> findArrayById(int id) {
        logger.debug("Find array with ID: {}", id);

        return storage.stream()
                .filter(myArray -> myArray.getId() == id)
                .findFirst();
    }

    @Override
    public List<MyArray> query(ArraySpecification specification) {
        logger.debug("Querying repository with specification: {}", specification.getClass().getSimpleName());

        return storage.stream()
                .filter(specification::specify)
                .collect(Collectors.toList());
    }

    @Override
    public List<MyArray> sort(Comparator<MyArray> comparator) {
        logger.debug("Sorting repository");

        List<MyArray> sortedList = new ArrayList<>(this.storage);
        sortedList.sort(comparator);

        return sortedList;
    }
}
