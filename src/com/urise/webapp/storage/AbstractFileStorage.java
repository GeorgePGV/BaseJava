package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.io.File;
import java.util.List;

public class AbstractFileStorage extends AbstractStorage<File>{

    @Override
    protected File getKey(String uuid) {

    }

    @Override
    protected void doUpdate(Resume r, File key) {

    }

    @Override
    protected void doSave(Resume r, File key) {

    }

    @Override
    protected Resume doGet(File key) {
        return null;
    }

    @Override
    protected boolean isExist(File key) {
        return false;
    }

    @Override
    protected void doDelete(File key) {

    }

    @Override
    protected List<Resume> doCopyAll() {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }
}
