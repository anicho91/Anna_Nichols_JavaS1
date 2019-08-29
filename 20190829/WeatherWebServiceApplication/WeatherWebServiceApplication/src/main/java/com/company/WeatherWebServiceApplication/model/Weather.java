package com.company.WeatherWebServiceApplication.model;

import java.util.ArrayList;
import java.util.List;

public class Weather {

    private List<Temperature> temperatureList;
    private int windSpeed;
    private String windDirection;
    private String skies;
    private int precipitation;

    public List<Temperature> getTemperatureList() {
        return temperatureList;
    }

    public void setTemperatureList(int int1, int int2) {
        this.temperatureList = temperatureList;
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
