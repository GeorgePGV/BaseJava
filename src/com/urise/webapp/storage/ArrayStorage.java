package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    protected void replacingDeletedResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void putResume(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    public int getIndex(String uuid){
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        if (index == -1) {
            System.out.println("Ошибка: резюме с uuid " + uuid + " нет в хранилище");
        }
        return -1;
    }
}
