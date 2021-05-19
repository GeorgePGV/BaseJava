package com.urise.webapp.model;

import java.util.List;

public class SectionWithOrganization {
    private List<Organization> organizations;

    public SectionWithOrganization(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return organizations.toString();
    }

    public List<Organization> getElement() {
        return organizations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SectionWithOrganization that = (SectionWithOrganization) o;

        return organizations.equals(that.organizations);

    }

    @Override
    public int hashCode() {
        return organizations.hashCode();
    }
}
