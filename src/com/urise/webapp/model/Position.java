package com.urise.webapp.model;

import java.time.LocalDate;

public class Position {
    private final Link homePage;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private String title;
    private String description;

    public Position(String name, String url, String title , String description, LocalDate startDate, LocalDate endDate ){
        this.homePage = new Link(name, url);
        this.startDate = startDate;
        this.endDate = endDate;
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
        return "Organization{" +
                "homePage=" + homePage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
