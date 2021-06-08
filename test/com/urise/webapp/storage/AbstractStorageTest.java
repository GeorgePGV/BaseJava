package com.urise.webapp.storage;

import com.urise.webapp.ResumeTestData;
import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File("G:\\Users\\basejava\\test\\com\\urise\\waste");

    protected Storage storage;
    protected static final String UUID_1 = "uuid1";
    protected static final String UUID_2 = "uuid2";
    protected static final String UUID_3 = "uuid3";
    protected static final String UUID_4 = "uuid4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = ResumeTestData.createResume(UUID_1,"Игорь");
        R2 = ResumeTestData.createResume(UUID_2,"Максим");
        R3 = ResumeTestData.createResume(UUID_3,"Олег");
        R4 = ResumeTestData.createResume(UUID_4,"Роман");
    }


    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setup() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0,storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveAlreadyExist() throws Exception {
        storage.save(R1);
    }

    @Test
    public void update() throws Exception {
        Resume updatedResume = ResumeTestData.createResume(UUID_1,"Александр");;
        storage.update(updatedResume);
        assertEquals(updatedResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.update(R4);
    }

    @Test
    public void get() throws Exception {
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
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
    public void getAllSorted() throws Exception {
        List<Resume> resumes2 = new ArrayList<>();
        resumes2.add(R1);
        resumes2.add(R2);
        resumes2.add(R3);
        List<Resume> resumes = storage.getAllSorted();
        assertEquals(3, resumes.size());
        assertEquals(resumes2, resumes);

    }

    @Test
    public void size() throws Exception {
        assertEquals(3,storage.size());
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}