package com.gergert.task1.entity;

import com.gergert.task1.exception.CustomException;
import com.gergert.task1.observer.ArrayObservable;
import com.gergert.task1.observer.ArrayObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.StringJoiner;

public class CustomArray implements ArrayObservable {
    private static final Logger logger = LogManager.getLogger();

    private int id;
    private int[] array;

    private ArrayObserver observer;

    public CustomArray() {
        this.array = new int[0];
    }

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(int id, int[] array) {
        this.id = id;
        this.array = array;
    }

    public int[] getArray() {
        if (array != null){
            return Arrays.copyOf(array, array.length);
        }

        return new int[0];
    }

    public int getFirstElement() {
        if (array != null && array.length > 0){
            return array[0];
        }

        return 0;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        if (array != null){
            return array.length;
        }
        return 0;
    }

    public void setArray(int[] array) {
        this.array = Arrays.copyOf(array, array.length);
        logger.info("Array replaced for ID: {}. New size: {}", id, array.length);
        notifyArrayObservers();
    }

    public void setElement(int index, int value) throws CustomException {
        logger.debug("Attempting to set value {} at index {} for Array ID {}", value, index, id);

        if (!isValidIndex(index)){
            logger.error("Failed to set value: index {} out of bounds.", index);
            throw new CustomException("Index out of bound: " + index);
        }

        array[index] = value;
        logger.info("Successfully set value by index: {}, Notifying observer", index);
        notifyArrayObservers();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomArray that = (CustomArray) o;

        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomArray.class.getSimpleName() + " [", "]")
                .add("id = " + id)
                .add("array = " + Arrays.toString(array))
                .toString();
    }

    @Override
    public void addArrayObserver(ArrayObserver observer) {
        this.observer = observer;
        logger.debug("Observer attached to array ID: {}.", id);
    }

    @Override
    public void removeArrayObserver(ArrayObserver observer) {
        if (this.observer == observer) {
            this.observer = null;
            logger.debug("Observer removed from array ID {}", id);
        }
    }

    @Override
    public void notifyArrayObservers() {
        if (observer != null){
            observer.update(this);
        }
    }

    private boolean isValidIndex(int index) {
        return array != null && index >= 0 && index < array.length;
    }
}
