package com.urise.webapp.storage;

import com.urise.webapp.Exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage{
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[10_000];
    protected static int size = 0;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public void doSave(Resume r, Object index) {
        if (size == STORAGE_LIMIT){
            throw new StorageException("Storage overflow", r.getUuid());
        } else {
            putResume(r, (Integer)index);
            size++;
        }
    }

    @Override
    public void doUpdate(Resume r, Object index) {
        storage[(Integer) index] = r;
    }

    @Override
    public Resume doGet(Object index) {
        return storage[(Integer) index];
    }

    @Override
    public void doDelete(Object index) {
        replaceDeletedResume((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void replaceDeletedResume(int index);

    protected abstract void putResume(Resume resume, int index);

    public abstract Integer getIndex(String uuid);
}
