package com.gergert.task1.entity;

import com.gergert.task1.exception.CustomException;
import com.gergert.task1.observer.ArrayObservable;
import com.gergert.task1.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class MyArray implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger();
    private int id;
    private int[] array;

    private ArrayObserver observer;

    public MyArray(int[] array) {
        this.array = array;
    }

    public MyArray(int id, int[] array) {
        this.id = id;
        this.array = array;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public int getFirstElement() {
        return (array != null && array.length > 0) ? array[0] : 0;
    }

    public void setArray(int[] array) {
        this.array = array;
        notifyArrayObservers();
    }

    public void setElement(int index, int value) throws CustomException {
        logger.debug("Setting value {} at index: {}.", value, index);
        boolean isValid = boundsValidator(index, array.length);

        if (!isValid){
            logger.error("Failed to set value: index {} out of bounds.", index);
            throw new CustomException("Index out of bound: " + index);
        }

        logger.info("Successfully set value by index: {}", index);
        array[index] = value;
        logger.debug("Notifying observers for array ID: {}.", id);
        notifyArrayObservers();
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return array.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MyArray that = (MyArray) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArray { ");
        sb.append("array = ").append(Arrays.toString(array));
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void addArrayObserver(ArrayObserver observer) {
        this.observer = observer;
    }

    @Override
    public void removeArrayObserver(ArrayObserver observer) {
        if (this.observer == observer) {
            this.observer = null;
        }
    }

    @Override
    public void notifyArrayObservers() {
        if (observer != null) {
            observer.update(this);
        }
    }

    private boolean boundsValidator (int index, int arrayLength) {
        logger.debug("Validating array bounds.");

        int minIndex = 0;
        if (index >= arrayLength || index < minIndex) {
            logger.error("Index out of bound: {}", index);
            return false;
        }

        logger.trace("Bounds validation passed.");
        return true;
    }
}
