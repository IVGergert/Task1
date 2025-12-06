package com.gergert.task1.entity;

import com.gergert.task1.observer.ArrayObservable;
import com.gergert.task1.observer.ArrayObserver;

import java.util.Arrays;

public class MyArray implements ArrayObservable {
    private final int id;
    private int[] array;

    private ArrayObserver observer;

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

    public int getId() {
        return id;
    }

    public ArrayObserver getObserver() {
        return observer;
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

        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
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
}
