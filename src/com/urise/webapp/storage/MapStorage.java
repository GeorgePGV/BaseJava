package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage<String> {
    private Map<String, Resume> storage = new HashMap<>();

    public void doSave(Resume r, String index) {
        storage.put((String)index, r);
    }

    @Override
    protected boolean isExist(String key) {
        return storage.containsKey((String) key);
    }

    public void doUpdate(Resume r, String index) {
        storage.put(String.valueOf(index), r);
    }

    public Resume doGet(String index) {
        return storage.get(index);
    }

    public void doDelete(String index) {
        storage.remove(index);
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    protected String getKey(String uuid) {
        return uuid;
    }
}

