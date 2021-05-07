package com.urise.webapp.storage;


import com.urise.webapp.Exception.ExistStorageException;
import com.urise.webapp.Exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    public Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    static Resume resume1 = new Resume(UUID_1,"Игорь");
    static Resume resume2 = new Resume(UUID_2,"Максим");
    static Resume resume3 = new Resume(UUID_3,"Олег");
    static Resume resume4 = new Resume(UUID_4,"Роман");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setup() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0,storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(resume4);
        assertEquals(4, storage.size());
        assertEquals(resume4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() throws Exception {
        storage.save(resume1);
    }


    @Test
    public void update() throws Exception {
        Resume updatedResume = new Resume(UUID_1,"Александр");
        storage.update(updatedResume);
        assertEquals(updatedResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(resume4);
    }

    @Test
    public void get() throws Exception {
        assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("uytduytdv");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("dummy");
    }


    @Test
    public void getAll() throws Exception {
        List<Resume> resumes = storage.getAllSorted();
        assertEquals(3, resumes.size());
        assertEquals(resume1, resumes.get(0));
        assertEquals(resume2, resumes.get(1));
        assertEquals(resume3, resumes.get(2));
    }

    @Test
    public void size() throws Exception {
        assertEquals(3,storage.size());
    }
}