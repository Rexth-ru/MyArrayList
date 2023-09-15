package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListTest {
    private MyArrayList<Integer> myArrayList;

    @BeforeEach
    void setUp() {
        myArrayList = new MyArrayList<>();
        myArrayList.add((Integer) 10);
        myArrayList.add((Integer) 6);
        myArrayList.add((Integer) 15);
    }

    @AfterEach
    void tearDown() {
        myArrayList.clear();
    }

    @Test
    void size() {
        assertEquals(myArrayList.size(), 3);
    }

    @Test
    void isEmpty() {
        myArrayList.clear();
        assertEquals(myArrayList.size(), 0);
    }

    @Test
    void addT() {
        for (int i = 0; i < 4; i++) {
            myArrayList.add((Integer) i);
        }
        assertEquals(myArrayList.size(), 7);
    }

    @Test
    void testAddByIndex() {
        myArrayList.add(2, 11);
        assertEquals(myArrayList.get(2), 11);
    }

    @Test
    void removeT() {
        myArrayList.remove((Integer) 10);
        assertEquals(myArrayList.size(), 2);
    }

    @Test
    void testRemoveByIndex() {
        myArrayList.remove(0);
        assertEquals(myArrayList.get(0), 6);
    }

    @Test
    void clear() {
        myArrayList.clear();
        assertEquals(myArrayList.size(), 0);
    }

    @Test
    void get() {
        assertEquals(myArrayList.get(0), 10);
    }

    @Test
    void set() {
        myArrayList.set(0, 1);
        assertEquals(myArrayList.get(0), 1);
        assertEquals(myArrayList.size(), 3);
    }

    @Test
    void sort() {
        MyArrayList<Integer> intList = new MyArrayList<>();
        intList.add((Integer) 6);
        intList.add((Integer) 10);
        intList.add((Integer) 15);
        myArrayList.sort(Integer::compareTo);
        assertEquals(myArrayList.get(0), intList.get(0));
    }
}