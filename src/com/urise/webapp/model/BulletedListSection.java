package com.urise.webapp.model;

import java.util.List;

public class BulletedListSection extends AbstractSection{

    private List<String> elements;

    public BulletedListSection(List<String> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public List<String> getElements() {
        return elements;
    }

    public void printElements() {
        for (int i = 0; i < elements.size(); i++) {
            System.out.println(elements.get(i));
        }
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
