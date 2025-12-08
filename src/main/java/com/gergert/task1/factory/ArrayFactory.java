package com.gergert.task1.factory;

import com.gergert.task1.entity.CustomArray;

public interface ArrayFactory {
    CustomArray createArray(int id, int[] elements);
}
