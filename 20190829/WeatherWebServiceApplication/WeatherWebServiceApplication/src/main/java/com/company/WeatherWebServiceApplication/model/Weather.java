package com.company.WeatherWebServiceApplication.model;

import java.util.List;

public class Weather {

    private Number fahrenheit;
    private Number celsius;
    private int windSpeed;
    private String windDirection;
    private String skies;
    private int precipitation;

    public Number getFahrenheit() {
        return fahrenheit;
    }

    public void setFahrenheit(Number fahrenheit) {
        this.fahrenheit = fahrenheit;
    }

    public Number getCelsius() {
        return celsius;
    }

    public void setCelsius(Number celsius) {
        this.celsius = celsius;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getSkies() {
        return skies;
    }

    public void setSkies(String skies) {
        this.skies = skies;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }


}
