package com.company;

public class Car {
    private String make;
    private String model;
    private String type;
    private String color;
    private String engine;
    private String transmission;
    private int numDoors;
    private double mpg;
    private int milesDriven;

    public String getMake() { return make; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public String getColor() { return color; }
    public String getEngine() { return engine; }
    public String getTransmission() { return transmission; }
    public int getNumDoors() { return numDoors; }
    public double getMpg() { return mpg; }
    public int getMilesDriven() { return milesDriven; }

//    public String setMake() { return make; }
//    public String setModel() { return model; }
//    public String setType() { return type; }
//    public String setColor() { return color; }
//    public String setEngine() { return engine; }
//    public String setTransmission() { return transmission; }
//    public int setNumDoors() { return numDoors; }
//    public double setMpg() { return mpg; }
//    public int setMilesDriven() { return milesDriven; }

    public Car(String make, String model, String type, String color, String engine,
               String transmission, int numDoors, double mpg, int milesDriven) {
        this.make = make;
        this.model = model;
        this.type = type;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
        this.numDoors = numDoors;
        this.mpg = mpg;
        this.milesDriven = milesDriven;
    }

    public void drive(int miles){
        milesDriven++;
    }

    public void honk(){
        System.out.println("Honk");
    }

}
