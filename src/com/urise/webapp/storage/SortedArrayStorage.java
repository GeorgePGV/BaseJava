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
      //  Comparator<Resume> comparator = (Resume1, Resume2) -> Resume1.getUuid().compareTo(Resume2.getUuid());
        int idx = Arrays.binarySearch(storage,0,size,resume);
        if (idx < 0) {
            idx = -idx - 1;
        }
        for (int i = idx + 1; i < size; i++) {
            storage[i] = storage[i - 1];
        }
        storage[idx] = resume;
        size++;
    }

    /*public static void sortInOrder(String uuid, Resume[] storage) {
        int idx = Arrays.binarySearch(storage, 0, size ,uuid);

        if (idx < 0) {
            idx = -idx - 1;
        }

        for (int i = idx + 1; i < size - 1; i++) {
            storage[i] = storage[i - 1];
        }
        storage[idx] = ;
    }*/
}



