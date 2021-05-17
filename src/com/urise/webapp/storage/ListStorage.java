package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer>{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey != null;
    }

    @Override
    public void doSave(Resume r, Integer index) {
        storage.add(r);
    }

    @Override
    public void doUpdate(Resume r, Integer index) {
        storage.set((Integer)index, r);
    }

    @Override
    public Resume doGet(Integer index) {
        return storage.get((Integer)index);
    }

    @Override
    public void doDelete(Integer index) {
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
