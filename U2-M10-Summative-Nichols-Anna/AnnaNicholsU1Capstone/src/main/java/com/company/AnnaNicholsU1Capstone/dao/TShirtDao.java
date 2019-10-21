package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {

    TShirt addTShirt(TShirt tshirt);

    TShirt getTShirt(int id);

    List<TShirt> getAllTShirts();

    void updateTShirt(TShirt tshirt);

    void deleteTShirt(int id);

    List<TShirt> getByColor(String color);

    List<TShirt> getBySize(String size);
}
