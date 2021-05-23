package com.urise.webapp.model;

import java.util.List;

public class Organization extends AbstractSection{
    private List<Position> positions;

    public Organization(List<Position> positions) {
        this.positions = positions;
    }

    @Override
    public String toString() {
        return positions.toString();
    }

    public List<Position> getElement() {
        return positions;
    }

    public void printElements() {
        for (int i = 0; i < positions.size() ; i++){
            System.out.println(positions.get(i).toString());
        }
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