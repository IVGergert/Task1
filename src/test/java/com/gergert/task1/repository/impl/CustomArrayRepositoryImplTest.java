package com.gergert.task1.repository.impl;

import com.gergert.task1.entity.ArrayData;
import com.gergert.task1.entity.CustomArray;
import com.gergert.task1.exception.CustomException;
import com.gergert.task1.specification.ArraySpecification;
import com.gergert.task1.warehouse.impl.ArrayWarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomArrayRepositoryImplTest {

    CustomArrayRepositoryImpl repository;

    @BeforeEach
    void setUp() throws Exception {
        resetSingleton(CustomArrayRepositoryImpl.class, "instance");
        resetSingleton(ArrayWarehouseImpl.class, "instance");
        repository = (CustomArrayRepositoryImpl) CustomArrayRepositoryImpl.getInstance();
    }

    @Test
    void add() throws CustomException {
        CustomArray customArray = new CustomArray(1, new int[]{1, 2, 3});

        repository.add(customArray);

        Optional<CustomArray> result = repository.findArrayById(1);
        assertTrue(result.isPresent());
        assertEquals(customArray, result.get());

        ArrayData warehouseData = ArrayWarehouseImpl.getInstance().get(1);
        assertNotNull(warehouseData);
        assertEquals(6, warehouseData.sum());
    }

    @Test
    void addDuplicate() throws CustomException {
        CustomArray array1 = new CustomArray(1, new int[]{1});
        CustomArray array2 = new CustomArray(1, new int[]{2});

        repository.add(array1);

        assertThrows(CustomException.class, () -> repository.add(array2));
    }

    @Test
    void remove() throws CustomException {
        CustomArray customArray = new CustomArray(1, new int[]{10, 20});
        repository.add(customArray);

        assertNotNull(ArrayWarehouseImpl.getInstance().get(1));

        repository.remove(customArray);

        assertFalse(repository.findArrayById(1).isPresent());

        assertNull(ArrayWarehouseImpl.getInstance().get(1));

        customArray.setElement(0, 999);
        assertNull(ArrayWarehouseImpl.getInstance().get(1));
    }

    @Test
    void removeNonExistent() {
        CustomArray myArray = new CustomArray(99, new int[]{1});
        assertThrows(CustomException.class, () -> repository.remove(myArray));
    }

    @Test
    void findArrayById() throws CustomException {
        CustomArray arr1 = new CustomArray(10, new int[]{1});
        CustomArray arr2 = new CustomArray(20, new int[]{2});
        repository.add(arr1);
        repository.add(arr2);

        Optional<CustomArray> found = repository.findArrayById(10);
        assertTrue(found.isPresent());
        assertEquals(10, found.get().getId());

        Optional<CustomArray> notFound = repository.findArrayById(99);
        assertFalse(notFound.isPresent());
    }

    @Test
    void query() throws CustomException {
        repository.add(new CustomArray(1, new int[]{1, 2, 3}));
        repository.add(new CustomArray(2, new int[]{10, 10}));
        repository.add(new CustomArray(3, new int[]{0, 0}));

        ArraySpecification sumMoreThan10 = array -> {
            int sum = 0;
            for (int i : array.getArray()) sum += i;
            return sum > 10;
        };

        List<CustomArray> result = repository.query(sumMoreThan10);
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getId());
    }

    @Test
    void sort() throws CustomException {
        CustomArray arr1 = new CustomArray(3, new int[]{1,6,2});
        CustomArray arr2 = new CustomArray(1, new int[]{1,9,2});
        CustomArray arr3 = new CustomArray(2, new int[]{2,9,34});

        repository.add(arr1);
        repository.add(arr2);
        repository.add(arr3);

        Comparator<CustomArray> idComparator = Comparator.comparingInt(CustomArray::getId);

        List<CustomArray> sorted = repository.sort(idComparator);

        assertEquals(1, sorted.get(0).getId());
        assertEquals(2, sorted.get(1).getId());
        assertEquals(3, sorted.get(2).getId());
    }

    @Test
    void testIntegrationUpdate() throws CustomException {
        int id = 5;
        CustomArray array = new CustomArray(id, new int[]{10, 20});
        repository.add(array);

        array.setElement(0, 100);

        ArrayData data = ArrayWarehouseImpl.getInstance().get(id);
        assertEquals(120, data.sum());
    }

    private void resetSingleton(Class<?> clazz, String fieldName) throws Exception {
        Field instance = clazz.getDeclaredField(fieldName);
        instance.setAccessible(true);
        instance.set(null, null);
    }
}