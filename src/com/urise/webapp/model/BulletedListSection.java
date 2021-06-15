package com.urise.webapp.model;

import java.util.Arrays;
import java.util.List;

public class BulletedListSection extends AbstractSection{

    private static final long serialVersionUID = 1L;

    private List<String> elements;

    public BulletedListSection(List<String> elements) {
        this.elements = elements;
    }

    public BulletedListSection() {
    }

    public BulletedListSection(String... items) {
        this(Arrays.asList(items));
    }

    public List<String> getItems() {
        return elements;
    }

    @Override
    public String getContent() {
        return elements.toString();
    }

    public List<String> getElements() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BulletedListSection that = (BulletedListSection) o;

        return elements.equals(that.elements);

    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

}
