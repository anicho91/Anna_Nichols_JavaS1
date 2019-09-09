package com.company.VideoGameCollectionDaoAnnaNichols.model;

import java.util.Objects;

public class Type {

    private int id;
    private String name;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id == type.id &&
                Objects.equals(name, type.name) &&
                Objects.equals(description, type.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
