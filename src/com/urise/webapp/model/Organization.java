package com.urise.webapp.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Position> positions;
    private final Link homePage;

    public Organization(String name, String url, List<Position> positions) {
        this(new Link(name, url), positions);
    }

    public Organization(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Organization(Link homePage, List<Position> positions) {
        this.homePage = homePage;
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
        return "Organization(" + homePage.toString() +"," + positions + ')';
    }

    public static class Position implements Serializable {
        public LocalDate startDate;
        private LocalDate endDate;
        private String title;
        private String description;

        public Position(String title , String description, LocalDate startDate, LocalDate endDate ){
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "startDate must not be null");
            Objects.requireNonNull(endDate, "endDate must not be null");
            Objects.requireNonNull(title, "title must not be null");
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        public Position(LocalDate startDate, String title, String description) {
            this.startDate = startDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position org = (Position) o;

            if (!description.equals(org.description)) return false;
            if (!startDate.equals(org.startDate)) return false;
            if (!endDate.equals(org.endDate)) return false;
            return title.equals(org.title);

        }

        @Override
        public int hashCode() {
            int result = title.hashCode();
            result = 31 * result + startDate.hashCode();
            result = 31 * result + endDate.hashCode();
            result = 31 * result + description.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Position{" +
                    ", startDate=" + startDate +
                    ", endDate=" + endDate +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }
}



