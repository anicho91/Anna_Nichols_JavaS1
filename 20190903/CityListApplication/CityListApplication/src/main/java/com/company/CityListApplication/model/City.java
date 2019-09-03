package com.company.CityListApplication.model;

import java.util.List;

public class City {
    private String name;
    private String state;
    private int population;
    private boolean isCapital;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean isCapital() {
        return isCapital;
    }

    public void setCapital(boolean capital) {
        this.isCapital = capital;
    }

}
