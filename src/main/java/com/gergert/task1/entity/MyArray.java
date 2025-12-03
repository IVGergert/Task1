package com.gergert.task1.entity;

import com.gergert.task1.exception.CustomException;

import java.util.Arrays;

public class MyArray {
    private int[] array;

    public MyArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return Arrays.copyOf(array, array.length);
    }

    public void setArray(int[] array) {
        this.array = array;
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
}
