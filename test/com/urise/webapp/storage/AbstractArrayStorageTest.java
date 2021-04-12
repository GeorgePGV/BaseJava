package com.urise.webapp.storage;

import com.urise.webapp.Exception.ExistStorageException;
import com.urise.webapp.Exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;


class AbstractArrayStorageTest {

    private static Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    static Resume resume1 = new Resume(UUID_1);
    static Resume resume2 = new Resume(UUID_2);
    static Resume resume3  = new Resume(UUID_3);
    static Resume resume4 = new Resume(UUID_4);

    @BeforeAll
    static void setup() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @org.junit.jupiter.api.Test
    void clear() throws Exception {
        storage.clear();
        Assertions.assertEquals(0,storage.size());
    }

    @org.junit.jupiter.api.Test
    void save() throws Exception {
        storage.save(resume4);
        Assertions.assertEquals(4,storage.size());
        Assertions.assertEquals(resume4,storage.get(resume4.getUuid()));
    }

    @org.junit.jupiter.api.Test
    void saveAlreadyExist() throws ExistStorageException {
        storage.save(resume1);
    }

    @org.junit.jupiter.api.Test
    void saveOverflow() throws ExistStorageException {
        for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++ ){
            storage.save(new Resume());
        }
        storage.save(new Resume());
    }

    @org.junit.jupiter.api.Test
    void update() throws Exception {
       Resume updatedResume = new Resume(UUID_1);
       storage.update(updatedResume);
        Assertions.assertEquals(updatedResume,storage.get(UUID_1));
    }

    @org.junit.jupiter.api.Test
    public void updateNotExist() throws NotExistStorageException {
        storage.get("ytdc6");
    }

    @org.junit.jupiter.api.Test
    void get() throws Exception {
        Assertions.assertEquals(resume1, storage.get(resume1.getUuid()));
    }

   @org.junit.jupiter.api.Test
    void getNotExist() throws NotExistStorageException {
        storage.get("ytdc6");
    }

    @org.junit.jupiter.api.Test
    void delete() throws Exception {
        storage.delete(UUID_1);
        Assertions.assertEquals(2, storage.size());
    }

    @org.junit.jupiter.api.Test
    public void deleteNotExist() throws NotExistStorageException {
        storage.get("ytdc6");
    }


    @org.junit.jupiter.api.Test
    void getAll() throws Exception {
        Resume[] resumes = storage.getAll();
        Assertions.assertEquals(3, resumes.length);
        Assertions.assertEquals(resume1, resumes[0]);
        Assertions.assertEquals(resume2, resumes[1]);
        Assertions.assertEquals(resume3, resumes[2]);
    }

    @org.junit.jupiter.api.Test
    void size() throws Exception {
        Assertions.assertEquals(3,storage.size());
    }
}