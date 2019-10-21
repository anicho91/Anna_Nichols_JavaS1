package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;

import java.util.List;

public interface TShirtViewDao {
    TShirtViewModel addTShirtVm(TShirtViewModel tshirtViewModel);

    TShirtViewModel getTShirtVm(int tshirtId);

    List<TShirtViewModel> getAllTShirtsVm();

    void updateTShirtVm(TShirtViewModel tshirtViewModel);

    void deleteTShirtVm(int tshirtId);

    List<TShirtViewModel> getAllTShirtsByColorVm(String color);

    List<TShirtViewModel> getAllTShirtsBySizeVm(String size);
}
