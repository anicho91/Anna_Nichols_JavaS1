package com.company;

public class Bathroom {
    private boolean hasTub;
    private int numSink;
    private boolean hasLightedMirror;
    private int levelOfWaterPressure;

    public boolean isHasTub() {
        return hasTub;
    }

    public int getNumSink() {
        return numSink;
    }


    public boolean isHasLightedMirror() {
        return hasLightedMirror;
    }

    public void setHasLightedMirror(boolean hasLightedMirror) {
        this.hasLightedMirror = hasLightedMirror;
    }

    public int getLevelOfWaterPressure() {
        return levelOfWaterPressure;
    }

    public void setLevelOfWaterPressure(int levelOfWaterPressure) {
        this.levelOfWaterPressure = levelOfWaterPressure;
    }

    public void turnOnLights(){

    }

    public void adjustWaterTemp(){

    }

    public Bathroom(){}
}
