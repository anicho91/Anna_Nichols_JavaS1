import com.opencsv.bean.CsvBindByName;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Car {

    @CsvBindByName(column = "Make")
    private String make;
    @CsvBindByName(column = "Model")
    private String model;
    @CsvBindByName(column = "Year")
    private int year;
    @CsvBindByName(column = "Color")
    private String color;
    @CsvBindByName(column = "Miles")
    private int miles;

    public Car(String make, String model, int year, String color, int miles) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }

    private List<Car> carList = new ArrayList<Car>();

    public Car(String make2, String model2, String color2) {

    }

    public void add(Car newCar){

        carList.add(newCar);
    }

    public void remove(Car newCar){

        carList.remove(newCar);
    }

    public List<Car> getAll(){
        return carList;
    }

    public Car() {

    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMiles() {
        return miles;
    }

    public void setMiles(int miles) {
        this.miles = miles;
    }
}
