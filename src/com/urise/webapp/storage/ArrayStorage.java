package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10_000];
    int size = 0;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public void save(Resume resume) {
        boolean indicator = true;
        for (int i = 0; i < size; i++) {
            if (storage[i] == resume) {
                indicator = false;
                System.out.println("Ошибка: такое резюме уже есть в хранилище");
            }
        }
        if (size != 10_000) {
            storage[size] = resume;
            size++;
        } else {
            System.out.println("Ошибка: в хранилище нет места");
        }
    }

    public void update(Resume resume) {
        if (checkForErrors(resume.getUuid())) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(resume.getUuid())) {
                    storage[i] = resume;
                }
            }
        }
    }

    public Resume get(String uuid) {
        if (checkForErrors(uuid)) {
            for (int i = 0; i < size; i++) {
               if (uuid.equals(storage[i].getUuid())) {
                   return storage[i];
               }
           }
       }
       return null;
    }

    public void delete(String uuid) {
        if(checkForErrors(uuid)) {
            for (int i = 0; i < size; i++) {
                if (uuid.equals(storage[i].getUuid())) {
                    for (int j = i; j < size; j++) {
                        storage[j] = storage[j + 1];
                    }
                    size--;
                }
            }
        }
    }

    public boolean checkForErrors(String uuid){
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                result = true;
                break;
            }
        }
        if (result == false){
            System.out.println("Ошибка: такого резюме нет в хранилище");
        }
        return result;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }
}
