package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.SalesTaxRate;

import java.util.List;

public interface SalesTaxRateDao {

    SalesTaxRate addSalesTaxRate(SalesTaxRate salesTaxRate);

    SalesTaxRate getSalesTaxRate(String state);

    List<SalesTaxRate> getAllSalesTaxRates();

    void updateSalesTaxRate(SalesTaxRate salesTaxRate);

    void deleteSalesTaxRate(String state);
    
}
