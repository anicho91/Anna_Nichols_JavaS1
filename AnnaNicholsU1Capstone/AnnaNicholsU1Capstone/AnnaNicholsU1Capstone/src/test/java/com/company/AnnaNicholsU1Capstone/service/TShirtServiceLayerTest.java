package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.TShirtDao;
import com.company.AnnaNicholsU1Capstone.dto.TShirt;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class TShirtServiceLayerTest {

    private TShirtServiceLayer tShirtService;
    private TShirtDao tShirtDao;
    private TShirtViewDao tShirtViewDao;
    
    private void setupTshirtMock(){

        tShirtDao = mock(TShirtDao.class);

        TShirt tShirt = new TShirt();
        tShirt.setId(4);
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));

        TShirt tShirt2 = new TShirt();
        tShirt2.setSize("M");
        tShirt2.setColor("Red");
        tShirt2.setDescription("Shirt");
        tShirt2.setPrice(new BigDecimal("10.00"));
        tShirt2.setQuantity(new BigDecimal("2"));

        List<TShirt> tShirts = new ArrayList<>();
        tShirts.add(tShirt);

        doReturn(tShirt).when(tShirtDao).addTShirt(tShirt2);
        doReturn(tShirt).when(tShirtDao).getTShirt(4);
        doReturn(tShirts).when(tShirtDao).getAllTShirts();
    }

    @Before
    public void setUp() throws Exception {
        setupTshirtMock();

        tShirtService = new TShirtServiceLayer(tShirtDao);
    }

    @Test
    public void addGetGetAllTShirtVm() {
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));
        tShirt = tShirtService.addTShirtVm(tShirt);

        TShirtViewModel fromService = tShirtService.getTShirtVm(tShirt.getId());
        assertEquals(tShirt, fromService);

        List<TShirtViewModel> tShirts = tShirtService.getAllTShirtsVm();
        assertEquals(1, tShirts.size());
        assertEquals(tShirt, tShirts.get(0));
    }

    @Test
    public void updateTShirtVm() {

        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setId(4);
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));

        ArgumentCaptor<TShirt> tShirtCaptor = ArgumentCaptor.forClass(TShirt.class);

        doNothing().when(tShirtDao).updateTShirt(tShirtCaptor.capture());

        tShirtService.updateTShirtVm(tShirt);
        verify(tShirtDao, times(1)).updateTShirt(tShirtCaptor.getValue());

        TShirt tShirt2 = tShirtCaptor.getValue();

        assertEquals(tShirt.getColor(), tShirt2.getColor());

    }

    @Test
    public void deleteTShirtVm() {

        ArgumentCaptor<Integer> integerCaptor = ArgumentCaptor.forClass(Integer.class);
        doNothing().when(tShirtDao).deleteTShirt(integerCaptor.capture());

        tShirtService.deleteTShirtVm(2);
        verify(tShirtDao, times(1)).deleteTShirt(integerCaptor.getValue());
        assertEquals(2, integerCaptor.getValue().intValue());
    }


    @Test
    public void getAllTShirtsByColorVm() {
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));
        tShirt = tShirtService.addTShirtVm(tShirt);

        List<TShirtViewModel> tShirts = tShirtService.getAllTShirtsVm();
        tShirtService.getAllTShirtsByColorVm(tShirts.get(0).getColor());
        assertEquals("Red", tShirts.get(0).getColor());
        assertEquals(tShirt, tShirts.get(0));
    }

    @Test
    public void getAllTShirtsBySizeVm() {
        TShirtViewModel tShirt = new TShirtViewModel();
        tShirt.setSize("M");
        tShirt.setColor("Red");
        tShirt.setDescription("Shirt");
        tShirt.setPrice(new BigDecimal("10.00"));
        tShirt.setQuantity(new BigDecimal("2"));
        tShirt = tShirtService.addTShirtVm(tShirt);

        List<TShirtViewModel> tShirts = tShirtService.getAllTShirtsVm();
        tShirtService.getAllTShirtsByColorVm(tShirts.get(0).getSize());
        assertEquals("M", tShirts.get(0).getSize());
        assertEquals(tShirt, tShirts.get(0));
    }
}
