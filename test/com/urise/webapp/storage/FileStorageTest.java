package com.urise.webapp.storage;

import com.urise.webapp.storage.serializer.ObjectStreamPathStorage;

public class FileStorageTest extends AbstractStorageTest{
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamPathStorage()));
    }
}