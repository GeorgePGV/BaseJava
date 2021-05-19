package com.urise.webapp.model;

public class Organization{
    private String dates;
    private String title;
    private String description;

    public Organization(String dates ,String title , String description ){
        this.dates = dates;
        this.title = title;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization org = (Organization) o;

        if (!description.equals(org.description)) return false;
        if (!dates.equals(org.dates)) return false;
        return title.equals(org.title);

    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + dates.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
