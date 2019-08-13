package com.company;

public class Microwave {

    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public boolean isRunning() {
        return running;
    }

    public Microwave(String manufacturer, String model, int secondsLeft, String time, boolean running) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = secondsLeft;
        this.time = time;
        this.running = running;
    }

//    public void start(int secondsLeft){
//        secondsLeft = time;
//        secondsLeft--;
//    }

//    public void stop(){
//        if (secondsLeft==0){
//            stop;
//        }
//    }

//    public void clear(){
//        if(clearButtonPressed == true){
//            time = 0;
//        }
//    }



}
