package com.company;

public class Garage {
    private int numOfCarSpots;
    private boolean hasStorage;
    private boolean hasPartyFridge;
    private boolean attachedToHouse;

    public int getNumOfCarSpots() {
        return numOfCarSpots;
    }

    public void setNumOfCarSpots(int numOfCarSpots) {
        this.numOfCarSpots = numOfCarSpots;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    public boolean isHasPartyFridge() {
        return hasPartyFridge;
    }

    public void setHasPartyFridge(boolean hasPartyFridge) {
        this.hasPartyFridge = hasPartyFridge;
    }

    public boolean isAttachedToHouse() {
        return attachedToHouse;
    }

    public void setAttachedToHouse(boolean attachedToHouse) {
        this.attachedToHouse = attachedToHouse;
    }

    public void toggleGarageDoor(){

    }

    public int decreaseStorageCapacity(int storageCapacity){
        return storageCapacity;
    }

    public Garage(){

    }
}
