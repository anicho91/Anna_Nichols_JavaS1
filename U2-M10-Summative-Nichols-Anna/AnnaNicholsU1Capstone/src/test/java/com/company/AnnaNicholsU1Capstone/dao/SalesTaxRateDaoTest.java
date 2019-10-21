package com.company.AnnaNicholsU1Capstone.dao;

import com.company.AnnaNicholsU1Capstone.dto.SalesTaxRate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SalesTaxRateDaoTest {
    
    @Autowired
    SalesTaxRateDao salesTaxRateDao;

    @Before
    public void setUp() throws Exception {
        List<SalesTaxRate> salesTaxRates = salesTaxRateDao.getAllSalesTaxRates();
        salesTaxRates.stream().forEach(SalesTaxRate -> salesTaxRateDao.deleteSalesTaxRate(SalesTaxRate.getState()));
    }

    @Test
    public void addGetDeleteSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal(".04"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertEquals(salesTaxRate1, salesTaxRate);

        salesTaxRateDao.deleteSalesTaxRate(salesTaxRate.getState());

        salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertNull(salesTaxRate1);
    }

    @Test
    public void getAllSalesTaxRates() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal(".04"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("WY");
        salesTaxRate.setRate(new BigDecimal(".07"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        List<SalesTaxRate> salesTaxRates = salesTaxRateDao.getAllSalesTaxRates();
        assertEquals(salesTaxRates.size(), 2);
    }

    @Test
    public void updateSalesTaxRate() {
        SalesTaxRate salesTaxRate = new SalesTaxRate();
        salesTaxRate.setState("GA");
        salesTaxRate.setRate(new BigDecimal(".04"));
        salesTaxRateDao.addSalesTaxRate(salesTaxRate);

        salesTaxRate.setRate(new BigDecimal(".05"));
        salesTaxRateDao.updateSalesTaxRate(salesTaxRate);

        SalesTaxRate salesTaxRate1 = salesTaxRateDao.getSalesTaxRate(salesTaxRate.getState());

        assertEquals(salesTaxRate1, salesTaxRate);

    }
}