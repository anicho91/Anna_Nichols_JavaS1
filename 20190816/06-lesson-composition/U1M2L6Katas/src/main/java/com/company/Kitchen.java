package com.company;

public class Kitchen {

    private String typeOfFridge;
    private int overSize;
    private boolean hasDishwasher;
    private String typeOfStove;
    private String typeOfCountertops;

    public String getTypeOfFridge() {
        return typeOfFridge;
    }

    public void setTypeOfFridge(String typeOfFridge) {
        this.typeOfFridge = typeOfFridge;
    }

    public int getOverSize() {
        return overSize;
    }

    public void setOverSize(int overSize) {
        this.overSize = overSize;
    }

    public boolean isHasDishwasher() {
        return hasDishwasher;
    }

    public void setHasDishwasher(boolean hasDishwasher) {
        this.hasDishwasher = hasDishwasher;
    }

    public String getTypeOfStove() {
        return typeOfStove;
    }

    public void setTypeOfStove(String typeOfStove) {
        this.typeOfStove = typeOfStove;
    }

    public String getTypeOfCountertops() {
        return typeOfCountertops;
    }

    public void setTypeOfCountertops(String typeOfCountertops) {
        this.typeOfCountertops = typeOfCountertops;
    }

    public Kitchen(){}

    public void makeDinner(){};
    public void cleanDishes(){};
    public void boilingWater(){};
}
