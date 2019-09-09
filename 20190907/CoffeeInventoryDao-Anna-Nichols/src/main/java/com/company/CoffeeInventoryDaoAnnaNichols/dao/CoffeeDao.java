package com.company.CoffeeInventoryDaoAnnaNichols.dao;

import com.company.CoffeeInventoryDaoAnnaNichols.model.Coffee;

import java.util.List;

public interface CoffeeDao {

    Coffee addCoffee(Coffee coffee);

    Coffee getCoffee(int id);

    List<Coffee> getCoffeeByRoaster(int roasterId);

    List<Coffee> getCoffeeByType(String type);

    List<Coffee> getAllCoffees();

    void updateCoffee(Coffee coffee);

    void deleteCoffee(int id);

}
