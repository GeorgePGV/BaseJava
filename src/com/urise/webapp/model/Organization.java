package com.urise.webapp.model;

import java.util.List;

public class Organization extends AbstractSection{
    private List<Position> positions;

    public Organization(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String getContent() {
        return positions.toString();
    }

    public List<Position> getElement() {
        return positions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return positions.equals(that.positions);

    }

    @Override
    public int hashCode() {
        return positions.hashCode();
    }
}
