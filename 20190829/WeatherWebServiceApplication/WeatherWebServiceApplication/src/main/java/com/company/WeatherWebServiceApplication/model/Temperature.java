package com.company.WeatherWebServiceApplication.model;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class Temperature {
    private int fahrenheit;
    private int celsius;

    public int getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(int fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }
}
