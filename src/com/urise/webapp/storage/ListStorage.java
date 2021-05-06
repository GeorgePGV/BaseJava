package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return searchKey != null;
    }

    @Override
    public void doSave(Resume r, Object index) {
        storage.add(r);
    }

    @Override
    public void doUpdate(Resume r, Object index) {
        storage.set((Integer)index, r);
    }

    @Override
    public Resume doGet(Object index) {
        return storage.get((Integer)index);
    }

    @Override
    public void doDelete(Object index) {
        storage.remove(((Integer) index).intValue());
    }

    public void clear() {
        storage.clear();
    }

    public int size() {
        return storage.size();
    }

    public List<Resume> doCopyAll() {
        return storage;
    }

    protected Integer getKey(String uuid){
        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }
}
