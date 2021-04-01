package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, uuid);
    }

    @Override
    public void save(Resume resume) {
        sortInOrder(resume, storage);
        size++;
    }

    public static void sortInOrder(Resume x, Resume[] storage) {
        if (x == null)
            throw new IllegalArgumentException();

        int idx = Arrays.binarySearch(storage, 0, size , x.getUuid());

        if (idx < 0) {
            idx = -idx - 1;
        }

        for (int i = idx + 1; i < size - 1; i++) {
            storage[i] = storage[i - 1];
        }
        storage[idx] = x;
    }
}



