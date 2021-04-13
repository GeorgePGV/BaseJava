package com.urise.webapp.storage;

import com.urise.webapp.Exception.ExistStorageException;
import com.urise.webapp.Exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import static org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    static Resume resume1 = new Resume(UUID_1);
    static Resume resume2 = new Resume(UUID_2);
    static Resume resume3 = new Resume(UUID_3);
    static Resume resume4 = new Resume(UUID_4);

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeAll
    void setup() throws Exception {
        storage.clear();
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @Test
    void clear() throws Exception {
        storage.clear();
        Assertions.assertEquals(0,storage.size());
    }

    @Test
    void save() throws Exception {
        storage.save(resume4);
        Assertions.assertEquals(4,storage.size());
        Assertions.assertEquals(resume4,storage.get(resume4.getUuid()));
    }

    @Test
    void saveAlreadyExist() throws ExistStorageException {
        storage.save(resume1);
    }

    @Test
    void saveOverflow() throws ExistStorageException {
        for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++ ){
            storage.save(new Resume());
        }
        storage.save(new Resume());
    }

    @Test
    void update() throws Exception {
        Resume updatedResume = new Resume(UUID_1);
        storage.update(updatedResume);
        Assertions.assertEquals(updatedResume, storage.get(UUID_1));
    }

    @Test
    public void updateNotExist() {
        Assertions.assertThrows(NotExistStorageException.class, () -> {
            storage.get("ytdc6");
        });
    }

    @Test
    void get() throws Exception {
        Assertions.assertEquals(resume1, storage.get(resume1.getUuid()));
    }

    @Test
    void getNotExist() throws NotExistStorageException {
        storage.get("ytdc6");
    }

    @Test
    void delete() throws Exception {
        storage.delete(UUID_1);
        Assertions.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws NotExistStorageException {
        storage.get("ytdc6");
    }


    @Test
    void getAll() throws Exception {
        Resume[] resumes = storage.getAll();
        Assertions.assertEquals(3, resumes.length);
        Assertions.assertEquals(resume1, resumes[0]);
        Assertions.assertEquals(resume2, resumes[1]);
        Assertions.assertEquals(resume3, resumes[2]);
    }

    @Test
    void size() throws Exception {
        Assertions.assertEquals(3,storage.size());
    }
}