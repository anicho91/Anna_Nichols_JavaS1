package com.company.CarLotDaoAnnaNichols.dao;

import com.company.CarLotDaoAnnaNichols.model.Car;

import java.util.List;

public interface CarLotDao {

    Car getCar(int id);

    List<Car> getAllCar();

    Car addCar(Car car);

    void updateCar(Car car);

    void deleteCar(int id);

    List<Car> getCarByMake (String make);

    List<Car> getCarByColor (String color);

}
