package com.company;

public class TV {

    private String manufacturer;
    private String model;
    private int screenSize;
    private String channel;
    private int volume;
    private boolean powered;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public String getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }

    public boolean isPowered() {
        return powered;
    }

    public TV(String manufacturer, String model, int screenSize, String channel, int volume, boolean powered) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.screenSize = screenSize;
        this.channel = channel;
        this.volume = volume;
        this.powered = powered;
    }

//    public void togglePower(){
//        if(buttonPressed == true && powered==false){
//            powered=true;
//        }
//        if(buttonPressed == true && powered==true){
//            powered=false;
//        }
//    }
}
