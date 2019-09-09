package com.company.VideoGameCollectionDaoAnnaNichols.model;

import java.util.Objects;

public class Console {

    private int id;
    private String name;
    private String year;

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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return id == console.id &&
                year == console.year &&
                Objects.equals(name, console.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, year);
    }
}
