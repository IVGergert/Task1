package com.gergert.task1.factory;

import com.gergert.task1.entity.MyArray;

public interface ArrayFactory {
    MyArray createArray(int id,int[] elements);
}
