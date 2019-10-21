package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.TShirtDao;
import com.company.AnnaNicholsU1Capstone.dto.TShirt;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TShirtServiceLayer implements TShirtViewDao{


    private TShirtDao tShirtDao;

    @Autowired
    public TShirtServiceLayer(TShirtDao tShirtDao) {
        this.tShirtDao = tShirtDao;
    }

    @Override
    public TShirtViewModel addTShirtVm(TShirtViewModel tshirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setSize(tshirtViewModel.getSize());
        tShirt.setColor(tshirtViewModel.getColor());
        tShirt.setDescription(tshirtViewModel.getDescription());
        tShirt.setPrice(tshirtViewModel.getPrice());
        tShirt.setQuantity(tshirtViewModel.getQuantity());
        tShirt = tShirtDao.addTShirt(tShirt);

        tshirtViewModel.setId(tShirt.getId());

        return tshirtViewModel;
    }

    @Override
    public TShirtViewModel getTShirtVm(int tShirtId) {
        TShirt tShirt = tShirtDao.getTShirt(tShirtId);
        return buildTShirtViewModel(tShirt);
    }

    @Override
    public List<TShirtViewModel> getAllTShirtsVm() {
        List<TShirt> tShirts = tShirtDao.getAllTShirts();

        List<TShirtViewModel> tShirtViewModels = new ArrayList<>();

        for (TShirt tShirt : tShirts){
            TShirtViewModel tsvm = buildTShirtViewModel(tShirt);
            tShirtViewModels.add(tsvm);
        }

        return tShirtViewModels;
    }

    @Override
    public void updateTShirtVm(TShirtViewModel tshirtViewModel) {
        TShirt tShirt = new TShirt();
        tShirt.setId(tshirtViewModel.getId());
        tShirt.setSize(tshirtViewModel.getSize());
        tShirt.setColor(tshirtViewModel.getColor());
        tShirt.setDescription(tshirtViewModel.getDescription());
        tShirt.setPrice(tshirtViewModel.getPrice());
        tShirt.setQuantity(tshirtViewModel.getQuantity());

        tShirtDao.updateTShirt(tShirt);

    }

    @Override
    public void deleteTShirtVm(int tShirtId) {

        tShirtDao.deleteTShirt(tShirtId);
    }

    @Override
    public List<TShirtViewModel> getAllTShirtsByColorVm(String color) {
        List<TShirt> tShirt = tShirtDao.getByColor(color);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<>();

        for (TShirt tShirtColor : tShirt){
            TShirtViewModel tsvm = buildTShirtViewModel(tShirtColor);
            tShirtViewModels.add(tsvm);
        }

        return tShirtViewModels;
    }

    @Override
    public List<TShirtViewModel> getAllTShirtsBySizeVm(String size) {
        List<TShirt> tShirt = tShirtDao.getBySize(size);
        List<TShirtViewModel> tShirtViewModels = new ArrayList<>();

        for (TShirt tShirtColor : tShirt){
            TShirtViewModel tsvm = buildTShirtViewModel(tShirtColor);
            tShirtViewModels.add(tsvm);
        }

        return tShirtViewModels;
    }


    private TShirtViewModel buildTShirtViewModel(TShirt tShirt){
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setId(tShirt.getId());
        tsvm.setSize(tShirt.getSize());
        tsvm.setColor(tShirt.getColor());
        tsvm.setDescription(tShirt.getDescription());
        tsvm.setPrice(tShirt.getPrice());
        tsvm.setQuantity(tShirt.getQuantity());

        return tsvm;
    }
}
