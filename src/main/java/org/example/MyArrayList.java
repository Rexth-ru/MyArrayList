package org.example;

import java.util.*;

/**
 * implementation of ArrayList without inheritance from Iterable or List
 * @param <T> Suitable for any type
 */
public class MyArrayList<T> {
    private static final int INIT_CAPACITY = 10;
    private T[] arr = (T[]) new Object[INIT_CAPACITY];
    private int size;

    public MyArrayList() {
    }

    public MyArrayList(T[] arr) {
        this.arr = arr;
    }

    /**
     * number of non-null elements
     *
     * @return number
     */
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add new element
     * if array is empty, keep element in first place
     * if the array is not empty, store the element at the end of the list
     *
     * @param t new element
     */
    public void add(T t) {
        if (isEmpty()) {
            arr[0] = t;
            size++;
        } else {
            checkCapacity();
            arr[size] = t;
            size++;
        }
    }

    /**
     * add a new element to a specific place in the array by index
     * if the index cell is empty, the element is added to the end of the list
     * before insertion, a check is made to ensure there is enough space in the array
     * in this case all elements in the array are shifted to the right
     * if the index goes beyond the array, an exception will be thrown
     *
     * @param index   the place in the array
     * @param element new element
     */
    public void add(int index, T element) {
        checkCapacity();
        if (index > size && index <= arr.length) {
            arr[size + 1] = element;
            size++;
        } else if (index <= arr.length && index >= 0) {
            for (int j = size; j > index; j--) {
                arr[j] = arr[j - 1];
            }
            arr[index] = element;
            size++;
        } else throw new IndexOutOfBoundsException();
    }

    /**
     *deleting an element by its value while all elements on the right are shifted to the left
     * @param t element value
     */
    public void remove(T t) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(t)) {
                for (int j = i; j <= size; j++) {
                    arr[j] = arr[j + 1];
                    if (arr[j + 1] == null) {
                        size--;
                        return;
                    }
                }

            }
        }
    }

    /**
     * removing an element by index
     * elements on the right are shifted to the left
     *
     * @param index the number indicating the index of the element in the array
     */
    public void remove(int index) {
        if (index <= size && index >= 0) {
            for (int i = index; i <= size; i++) {
                arr[i] = arr[i + 1];
                if (arr[i + 1] == null) {
                    size--;
                    return;
                }
            }

        } else throw new IndexOutOfBoundsException();
    }

    /**
     * removing all elements
     */
    public void clear() {
        int changSize = size;
        while (changSize > 0) {
            for (int i = 0; i < size; i++) {
                arr[i] = null;
                changSize--;
            }
        }
        size = changSize;
    }

    /**
     *get element by index
     * @param index
     * @return element value
     */
    public T get(int index) {
        if (index < arr.length) return arr[index];
        else throw new IndexOutOfBoundsException();
    }

    /**
     * replace element by index
     * @param index
     * @param element new meaning of element
     */
    public void set(int index, T element) {
        if (index < size) {
            arr[index] = element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * sorts array elements
     * @param comparator sorting logic
     */
    public void sort(Comparator<? super T> comparator) {
        int low = 0;
        int high = size() - 1;
        quickSort(low, high, comparator);
    }

    private void quickSort(int low, int high, Comparator comparator) {
        if (low >= high) {
            return;
        }
        int middle = (low + high) / 2;
        T opor = arr[middle];

        int leftBound = low;
        int rightBound = high;
        while (leftBound <= rightBound) {
            while (comparator.compare(arr[leftBound], opor) < 0) {
                leftBound++;
            }
            while (comparator.compare(arr[rightBound], opor) > 0) {
                rightBound--;
            }
            if (leftBound <= rightBound) {
                T temp = arr[leftBound];
                arr[leftBound] = arr[rightBound];
                arr[rightBound] = temp;
                leftBound++;
                rightBound--;
            }
        }
        if (low < rightBound) {
            quickSort(low, rightBound, comparator);
        }
        if (leftBound < high) {
            quickSort(leftBound, high, comparator);
        }
    }

    /**
     * checks the size of the array and increases it if necessary
     */
    private void checkCapacity() {
        if (size >= arr.length) {
            T[] newArr = Arrays.copyOf(arr, (int) (arr.length * 1.5 + 1));
            arr = newArr;
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
