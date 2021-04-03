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
        int index = getIndex(resume.getUuid());
        if (index >= 0 ){
            System.out.println("Ошибка: резюме с uuid: " + resume.getUuid() + " уже есть в хранилище");
        } else if (size == storage.length){
            System.out.println("Ошибка: в хранилище нет места");
        } else {
            //index = (index + 1) * -1;
            putResume(resume, index);
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
                replacingDeletedResume(getIndex(uuid));
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
