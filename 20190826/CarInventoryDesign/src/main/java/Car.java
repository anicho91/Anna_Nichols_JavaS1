import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

    private String make;
    private String model;
    private int year;
    private String color;
    private int miles;

    public Car(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    public Car() {

    }


    public String getmake() {
        return make;
    }

    public void setmake(String make) {
        this.make = make;
    }

    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public int getyear() {
        return year;
    }

    public void setyear(int year) {
        this.year = year;
    }

    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }

    public int getmiles() {
        return miles;
    }

    public void setmiles(int miles) {
        this.miles = miles;
    }
}
