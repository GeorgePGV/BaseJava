package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[10_000];
    protected static int size = 0;
    protected int index;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) != -1 ){
            System.out.println("Ошибка: резюме с uuid: " + resume.getUuid() + " уже есть в хранилище");
        } else if (size == storage.length){
            System.out.println("Ошибка: в хранилище нет места");
        } else {
            storage[size] = resume;
            size++;
        }

    }

    public void update(Resume resume) {
        if (getIndex(resume.getUuid()) != -1) {
            storage[getIndex(resume.getUuid())] = resume;
        }
    }

    public Resume get(String uuid) {
        if (getIndex(uuid) != -1) {
            return storage[getIndex(uuid)];
        } else {
            return null;
        }
    }

    public void delete(String uuid) {
        if(getIndex(uuid) != -1) {
            if (size - getIndex(uuid) >= 0)
                System.arraycopy(storage, getIndex(uuid) + 1, storage, getIndex(uuid), size - getIndex(uuid));
            size--;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    public abstract int getIndex(String uuid);
}
