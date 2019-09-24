package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.service.TShirtServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.TShirtViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(TShirtController.class)
public class TShirtControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    TShirtServiceLayer tshirtService;


    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createTShirtTest() throws Exception {
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setSize("M");
        tsvm.setColor("Red");
        tsvm.setDescription("Shirt");
        tsvm.setPrice(new BigDecimal("10.00"));
        tsvm.setQuantity(new BigDecimal("2"));

        String inputJson = mapper.writeValueAsString(tsvm);

        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("M");
        tsvm2.setColor("Red");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(2);

        String outputJson = mapper.writeValueAsString(tsvm2);

        when(tshirtService.addTShirtVm(tsvm)).thenReturn(tsvm2);

        this.mockMvc.perform(post("/tshirt")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllTShirtsTest() throws Exception {
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setSize("M");
        tsvm.setColor("Red");
        tsvm.setDescription("Shirt");
        tsvm.setPrice(new BigDecimal("10.00"));
        tsvm.setQuantity(new BigDecimal("2"));
        tsvm.setId(2);

        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("L");
        tsvm2.setColor("Blue");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(3);

        List<TShirtViewModel> tsvmList = new ArrayList<>();
        tsvmList.add(tsvm);
        tsvmList.add(tsvm2);

        when(tshirtService.getAllTShirtsVm()).thenReturn(tsvmList);

        List<TShirtViewModel> tsvmList2 = new ArrayList<>();
        tsvmList2.addAll(tsvmList);

        String outputJson = mapper.writeValueAsString(tsvmList2);

        this.mockMvc.perform(get("/tshirt"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtByIdTest() throws Exception {
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setSize("M");
        tsvm.setColor("Red");
        tsvm.setDescription("Shirt");
        tsvm.setPrice(new BigDecimal("10.00"));
        tsvm.setQuantity(new BigDecimal("2"));
        tsvm.setId(2);

        String outputJson = mapper.writeValueAsString(tsvm);

        when(tshirtService.getTShirtVm(2)).thenReturn(tsvm);

        this.mockMvc.perform(get("/tshirt/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void updateTShirtTest() throws Exception {
        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("M");
        tsvm2.setColor("Red");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(3);

        String inputJson = mapper.writeValueAsString(tsvm2);

        this.mockMvc.perform(put("/tshirt/" + tsvm2.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteTShirtTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/tshirt/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void getTShirt400ErrorTest() throws Exception{

        String id400TShirt = "z";

        this.mockMvc.perform(get("/tshirt/" + id400TShirt))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getTShirt404ErrorTest() throws Exception{
        TShirtViewModel tsvm = new TShirtViewModel();

        int id404TShirt = 10;

        when(tshirtService.getTShirtVm(id404TShirt)).thenReturn(tsvm);

        this.mockMvc.perform(get("/tshirt" + id404TShirt))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getTShirt405ErrorTest() throws Exception{

        int id405TShirt = 10;

        this.mockMvc.perform(post("/tshirt/" + id405TShirt))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());

    }

    @Test
    public void getTShirt415ErrorTest() throws Exception{

        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("M");
        tsvm2.setColor("Red");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(3);

        String inputJson = mapper.writeValueAsString(tsvm2);

        this.mockMvc.perform(put("/tshirt/" + tsvm2.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());

    }

    @Test
    public void getTShirtByColor() throws Exception {
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setSize("M");
        tsvm.setColor("Red");
        tsvm.setDescription("Shirt");
        tsvm.setPrice(new BigDecimal("10.00"));
        tsvm.setQuantity(new BigDecimal("2"));
        tsvm.setId(2);

        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("L");
        tsvm2.setColor("Blue");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(3);

        List<TShirtViewModel> tsvmList = new ArrayList<>();
        tsvmList.add(tsvm);
        tsvmList.add(tsvm2);

        when(tshirtService.getAllTShirtsByColorVm(tsvm.getColor())).thenReturn(tsvmList);

        List<TShirtViewModel> tsvmList2 = new ArrayList<>();
        tsvmList2.addAll(tsvmList);

        String outputJson = mapper.writeValueAsString(tsvmList2);

        this.mockMvc.perform(get("/tshirt/color/Red"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getTShirtBySize() throws Exception {
        TShirtViewModel tsvm = new TShirtViewModel();
        tsvm.setSize("M");
        tsvm.setColor("Red");
        tsvm.setDescription("Shirt");
        tsvm.setPrice(new BigDecimal("10.00"));
        tsvm.setQuantity(new BigDecimal("2"));
        tsvm.setId(2);

        TShirtViewModel tsvm2 = new TShirtViewModel();
        tsvm2.setSize("L");
        tsvm2.setColor("Blue");
        tsvm2.setDescription("Shirt");
        tsvm2.setPrice(new BigDecimal("10.00"));
        tsvm2.setQuantity(new BigDecimal("2"));
        tsvm2.setId(3);

        List<TShirtViewModel> tsvmList = new ArrayList<>();
        tsvmList.add(tsvm);
        tsvmList.add(tsvm2);

        when(tshirtService.getAllTShirtsBySizeVm(tsvm.getSize())).thenReturn(tsvmList);

        List<TShirtViewModel> tsvmList2 = new ArrayList<>();
        tsvmList2.addAll(tsvmList);

        String outputJson = mapper.writeValueAsString(tsvmList2);

        this.mockMvc.perform(get("/tshirt/size/M"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}