package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    public void doSave(Resume r, Object index) {
        storage.put((String)index, r);
    }

    @Override
    protected boolean isExist(Object key) {
        return storage.containsKey((String) key);
    }

    public void doUpdate(Resume r, Object index) {
        storage.put(String.valueOf(index), r);
    }

    public Resume doGet(Object index) {
        return storage.get(index);
    }

    public void doDelete(Object index) {
        storage.remove(index);
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    protected String getKey(String uuid) {
        return uuid;
    }
}

