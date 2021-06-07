package com.urise.webapp.model;

import java.io.Serializable;
import java.util.List;

public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Position> positions;
    private String name;
    private String url;

    public Organization(String name, String url, List<Position> positions) {
        this.name = name;
        this.url  = url;
        this.positions = positions;
    }

    public String getContent() {
        return positions.toString();
    }

    public List<Position> getElement() {
        return positions;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return positions.equals(that.positions);

    }

    public int hashCode() {
        return positions.hashCode();
    }

    public String toString() {
        return "Organization(" + name + "," + url + "," + positions + ')';
    }
}
