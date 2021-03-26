package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10_000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public void save(Resume resume) {
        if (resume.getIndex() != 0 ){
            System.out.println("Ошибка: резюме с uuid: " + resume.getUuid() + " уже есть в хранилище");
        } else if (size == storage.length){
            System.out.println("Ошибка: в хранилище нет места");
        } else {
            storage[size] = resume;
            size++;
            resume.setIndex(size);
        }

    }

    public void update(Resume resume) {
        if (checkForErrors(resume.getUuid()) != 0) {
            storage[checkForErrors(resume.getUuid())] = resume;
        }
    }

    public Resume get(String uuid) {
        if (checkForErrors(uuid) != 0) {
            return storage[checkForErrors(uuid)];
        } else {
            return null;
        }
    }

    public void delete(String uuid) {
        if(checkForErrors(uuid) != 0) {
            for (int j = checkForErrors(uuid); j < size; j++) {
                storage[j] = storage[j + 1];
            }
            size--;
        }
    }

    public int checkForErrors(String uuid){
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = storage[i].getIndex();
                break;
            }
        }
        if (index == 0){
            System.out.println("Ошибка: резюме с uuid " + uuid + " нет в хранилище");
        }
        return index;
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
