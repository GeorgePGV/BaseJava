package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorageResume extends AbstractStorage<Resume>{
    private Map<String, Resume> storage = new HashMap<>();

    public void doSave(Resume r, Resume resume) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    public void doUpdate(Resume r, Resume resume) {
        storage.put(r.getUuid(), r);
    }

    public Resume doGet(Resume resume) {
        return (Resume) resume;
    }

    public void doDelete(Resume resume) {
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
