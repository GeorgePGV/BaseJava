package com.urise.webapp.model;

import java.util.List;

public class SectionWithList {

    private List<String> elements;

    public SectionWithList(List<String> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return elements.toString();
    }

    public List<String> getElement() {
        return elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionWithList that = (SectionWithList) o;

        return elements.equals(that.elements);

    }

    @Override
    public int hashCode() {
        return elements.hashCode();
    }

}
