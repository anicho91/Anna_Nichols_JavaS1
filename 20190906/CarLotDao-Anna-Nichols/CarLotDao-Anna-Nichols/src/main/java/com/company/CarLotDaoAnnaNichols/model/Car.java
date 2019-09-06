package com.company.CarLotDaoAnnaNichols.model;

import java.util.Objects;

public class Car {

    private int id;
    private String model;
    private String make;
    private String year;
    private String color;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                model.equals(car.model) &&
                make.equals(car.make) &&
                year.equals(car.year) &&
                color.equals(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, make, year, color);
    }
}
