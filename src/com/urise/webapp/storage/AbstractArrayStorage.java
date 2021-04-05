package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[10_000];
    protected static int size = 0;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0 ){
            System.out.println("Ошибка: резюме с uuid: " + resume.getUuid() + " уже есть в хранилище");
        } else if (size == STORAGE_LIMIT){
            System.out.println("Ошибка: в хранилище нет места");
        } else {
            putResume(resume, index);
            size++;
        }

    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index != -1) {
            return storage[index];
        } {
            return null;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index != -1) {
            if (size - index >= 0)
                replacingDeletedResume(index);
            size--;
            storage[size - 1] = null;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    protected abstract void replacingDeletedResume(int index);

    protected abstract void putResume(Resume resume, int index);

    public abstract int getIndex(String uuid);
}
