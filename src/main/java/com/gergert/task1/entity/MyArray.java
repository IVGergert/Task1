package com.gergert.task1.entity;

import java.util.Arrays;

public class MyArray {
    private final int id;
    private String name;
    private int[] elements;

    public MyArray(int id, String name,int[] elements) {
        this.id = id;
        this.name = name;
        this.elements = elements;
    }

    public int[] getArray() {
        return Arrays.copyOf(elements, elements.length);
    }

    public void setArray(int[] elements) {
        this.elements = elements;
    }

    public int getSize() {
        return elements.length;
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

        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MyArray { ");
        sb.append("array = ").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }
}
