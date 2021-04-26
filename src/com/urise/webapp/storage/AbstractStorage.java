package com.urise.webapp.storage;

import com.urise.webapp.Exception.ExistStorageException;
import com.urise.webapp.Exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{
    protected abstract Object getIndex(String uuid);
    protected abstract void doUpdate(Resume r, Object key);
    protected abstract void doSave(Resume r, Object key);
    protected abstract Resume doGet(Object key);
    protected abstract void doDelete(Object key);

    public void update(Resume r) {
        Object key = getExistedKey(r.getUuid());
        doUpdate(r, key);
    }

    public void delete(String uuid) {
        Object key = getExistedKey(uuid);
        doDelete(key);
    }

    public Resume get(String uuid) {
        Object key = getExistedKey(uuid);
        return doGet(key);
    }

    public void save(Resume r) {
        Object key = getNotExistedKey(r.getUuid());
        doSave(r, key);
    }

    private Object getExistedKey(String uuid) {
        Object key = getIndex(uuid);
        if((Integer)key < 0){
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private Object getNotExistedKey(String uuid) {
        Object key = getIndex(uuid);
        if((Integer)key >= 0){
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}

