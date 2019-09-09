package com.company.CoffeeInventoryDaoAnnaNichols.dao;

import com.company.CoffeeInventoryDaoAnnaNichols.model.Roaster;

import java.util.List;

public interface RoasterDao {

    Roaster addRoaster(Roaster roaster);

    Roaster getRoaster(int id);

    List<Roaster> getAllRoasters();

    void updateRoaster(Roaster roaster);

    void deleteRoaster(int id);

}
