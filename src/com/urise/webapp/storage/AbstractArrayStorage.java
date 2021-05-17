package com.urise.webapp.storage;

import com.urise.webapp.Exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer>{
    protected static final int STORAGE_LIMIT = 10_000;
    protected final Resume[] storage = new Resume[10_000];
    protected static int size = 0;

    public void clear() {
        Arrays.fill(storage, 0,size,null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public List<Resume> doCopyAll() {
        return Arrays.asList(Arrays.copyOfRange(storage,0,size));
    }

    @Override
    protected boolean isExist(Integer index) {
        return (Integer) index >= 0;
    }

    @Override
    public void doSave(Resume r, Integer index) {
        if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", r.getUuid());
        }
        putResume(r, (Integer) index);
        size++;
    }

    @Override
    public void doUpdate(Resume r, Integer index) {
        storage[(Integer) index] = r;
    }

    @Override
    public Resume doGet(Integer index) {
        return storage[(Integer) index];
    }

    @Override
    public void doDelete(Integer index) {
        replaceDeletedResume((Integer) index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract void replaceDeletedResume(int index);

    protected abstract void putResume(Resume resume, int index);

    public abstract Integer getKey(String uuid);
}
