package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> storage = new HashMap<>();

    @Override
    public void doSave(Resume r, Object index) {
        storage.put(String.valueOf(index), r);
    }

    @Override
    public void doUpdate(Resume r, Object index) {
        storage.put(String.valueOf(index), r);
    }

    @Override
    public Resume doGet(Object index) {
        return storage.get(index);
    }

    @Override
    public void doDelete(Object index) {
        storage.remove(index);
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public List<Resume> getAllInList() {
        return new ArrayList<>(storage.values());
    }

    protected Integer getKey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
