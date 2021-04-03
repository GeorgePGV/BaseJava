package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void replacingDeletedResume(int index) {
        int element = size - index - 1;
        if (element > 0) {
            System.arraycopy(storage, index + 1, storage, index, element);
        }
    }

    @Override
    protected void putResume(Resume resume, int index) {
        System.arraycopy(storage, -index - 1, storage, -index, size - index + 1);
        storage[-index - 1] = resume;
    }
}





