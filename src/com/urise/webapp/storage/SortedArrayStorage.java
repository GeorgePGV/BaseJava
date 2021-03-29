package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    public void save(Resume resume) {

    }

    public static void selectionSort(Resume[] array, int size) {
        for (int i = 0; i < size; i++) {
            Resume min = array[i];
            int minIndex = i;
            for (int j = i+1; j < size; j++) {
                if (array[j].getUuid() < min.getUuid()) {
                    min = array[j];
                    minIndex = j;
                }
            }
            int swap = array[i];
            array[i] = min;
            array[minIndex] = swap;
        }
    }

}
