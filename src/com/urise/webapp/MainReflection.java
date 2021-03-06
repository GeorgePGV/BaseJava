package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume r = new Resume("Игорь");
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        field.set(r, "new_uuid");
        Method method = r.getClass().getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);
    }
}
