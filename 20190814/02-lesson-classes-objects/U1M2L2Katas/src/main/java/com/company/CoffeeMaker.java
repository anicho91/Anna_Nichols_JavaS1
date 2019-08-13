package com.company;

public class CoffeeMaker {

    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public String getManufacturer() { return manufacturer; }
    public String getModel() { return model; }
    public int getCarafeSize() { return carafeSize; }
    public int getCupsLeft() { return cupsLeft; }
    public boolean isPowered() { return powered; }

    public void brew(){

    }

    public void pourCoffee(int numCups){

    }

    public CoffeeMaker(String manufacturer, String model, int carafeSize,
                       int cupsLeft, boolean powered){
        this.manufacturer = manufacturer;
        this.model = model;
        this.carafeSize = carafeSize;
        this.cupsLeft = cupsLeft;
        this.powered = powered;
    }

}
