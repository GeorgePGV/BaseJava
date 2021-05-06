package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageResume extends AbstractStorage{
    private Map<String, Resume> storage = new HashMap<>();

    public void doSave(Resume r, Object resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    public void doUpdate(Resume r, Object resume) {
        storage.put(r.getUuid(), r);
    }

    public Resume doGet(Object resume) {
        return (Resume) resume;
    }

    public void doDelete(Object resume) {
        storage.remove(((Resume) resume).getUuid());
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

    protected Resume getKey(String uuid) {
        return storage.get(uuid);
    }
}
