package com.company;

public class Radio {

    private String manufacturer;
    private String model;
    private int numSpeaker;
    private String station;
    private int volume;
    private boolean powered;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getNumSpeakers() {
        return numSpeaker;
    }

    public String getStation() {
        return station;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public Radio(String manufacturer, String model, int numSpeaker, String station, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.numSpeaker = numSpeaker;
        this.station = station;
        this.volume = volume;
        this.powered = powered;
    }

//    public void togglePower(){
//        if (powered==false && buttonPressed == true){
//            togglePower();
//        }
//        if (powered==true && buttonPressed == true){
//            togglePower();
//        }
//    }

}
