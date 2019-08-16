package com.company;

public class Home {
    private HomeBasics bathroomBasics;
    private HomeBasics garageBasics;
    private HomeBasics studyBasics;
    private HomeBasics kitchenBasics;

    private Bathroom bathroom;
    private Garage garage;
    private Study study;
    private Kitchen kitchen;

    public HomeBasics getBathroomBasics() {
        return bathroomBasics;
    }

    public void setBathroomBasics(HomeBasics bathroomBasics) {
        this.bathroomBasics = bathroomBasics;
    }

    public HomeBasics getGarageBasics() {
        return garageBasics;
    }

    public void setGarageBasics(HomeBasics garageBasics) {
        this.garageBasics = garageBasics;
    }

    public HomeBasics getStudyBasics() {
        return studyBasics;
    }

    public void setStudyBasics(HomeBasics studyBasics) {
        this.studyBasics = studyBasics;
    }

    public HomeBasics getKitchenBasics() {
        return kitchenBasics;
    }

    public void setKitchenBasics(HomeBasics kitchenBasics) {
        this.kitchenBasics = kitchenBasics;
    }
}
