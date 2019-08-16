package com.company.interfaces;

public interface Vehicle {
    public default  void drive(int miles){

    };

    public void displayMilesTraveled();
}
