package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.service.ConsoleServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.ConsoleViewModel;
import com.fasterxml.jackson.core.JsonProcessingException;
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
@WebMvcTest(ConsoleController.class)
public class ConsoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ConsoleServiceLayer consoleService;


    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createConsoleTest() throws Exception {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Playstation");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("2TB");
        cvm.setProcessor("Intel i7-2880k");
        cvm.setPrice(new BigDecimal("500.00"));
        cvm.setQuantity(new BigDecimal(10));

        String inputJson = mapper.writeValueAsString(cvm);

        ConsoleViewModel cvm2 = new ConsoleViewModel();
        cvm2.setModel("Playstation");
        cvm2.setManufacturer("Sony");
        cvm2.setMemoryAmount("2TB");
        cvm2.setProcessor("Intel i7-2880k");
        cvm2.setPrice(new BigDecimal("500.00"));
        cvm2.setQuantity(new BigDecimal(10));
        cvm2.setId(2);

        String outputJson = mapper.writeValueAsString(cvm2);

        when(consoleService.addConsoleVm(cvm)).thenReturn(cvm2);

        this.mockMvc.perform(post("/console")
                                .content(inputJson)
                                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllConsolesTest() throws Exception {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Playstation");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("2TB");
        cvm.setProcessor("Intel i7-2880k");
        cvm.setPrice(new BigDecimal("500.00"));
        cvm.setQuantity(new BigDecimal(10));
        cvm.setId(2);

        ConsoleViewModel cvm2 = new ConsoleViewModel();
        cvm2.setModel("Xbox");
        cvm2.setManufacturer("Microsoft");
        cvm2.setMemoryAmount("2TB");
        cvm2.setProcessor("Intel i7-2880k");
        cvm2.setPrice(new BigDecimal("300.00"));
        cvm2.setQuantity(new BigDecimal(5));
        cvm2.setId(3);

        List<ConsoleViewModel> cvmList = new ArrayList<>();
        cvmList.add(cvm);
        cvmList.add(cvm2);

        when(consoleService.getAllConsolesVm()).thenReturn(cvmList);

        List<ConsoleViewModel> cvmList2 = new ArrayList<>();
        cvmList2.addAll(cvmList);

        String outputJson = mapper.writeValueAsString(cvmList2);

        this.mockMvc.perform(get("/console"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getConsoleByIdTest() throws Exception {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Playstation");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("2TB");
        cvm.setProcessor("Intel i7-2880k");
        cvm.setPrice(new BigDecimal("500.00"));
        cvm.setQuantity(new BigDecimal(10));
        cvm.setId(2);

        String outputJson = mapper.writeValueAsString(cvm);

        when(consoleService.getConsoleVm(2)).thenReturn(cvm);

        this.mockMvc.perform(get("/console/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    public void getAllConsolesByManufacturer() throws Exception {
        ConsoleViewModel cvm = new ConsoleViewModel();
        cvm.setModel("Playstation");
        cvm.setManufacturer("Sony");
        cvm.setMemoryAmount("2TB");
        cvm.setProcessor("Intel i7-2880k");
        cvm.setPrice(new BigDecimal("500.00"));
        cvm.setQuantity(new BigDecimal(10));
        cvm.setId(2);

        ConsoleViewModel cvm2 = new ConsoleViewModel();
        cvm2.setModel("Xbox");
        cvm2.setManufacturer("Microsoft");
        cvm2.setMemoryAmount("2TB");
        cvm2.setProcessor("Intel i7-2880k");
        cvm2.setPrice(new BigDecimal("300.00"));
        cvm2.setQuantity(new BigDecimal(5));
        cvm2.setId(3);

        List<ConsoleViewModel> cvmList = new ArrayList<>();
        cvmList.add(cvm);
        cvmList.add(cvm2);

        when(consoleService.getAllConsolesByManufacturerVm(cvm.getManufacturer())).thenReturn(cvmList);

        List<ConsoleViewModel> cvmList2 = new ArrayList<>();
        cvmList2.addAll(cvmList);

        String outputJson = mapper.writeValueAsString(cvmList2);

        this.mockMvc.perform(get("/console/manufacturer/Sony"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void updateConsoleTest() throws Exception {
        ConsoleViewModel cvm2 = new ConsoleViewModel();
        cvm2.setModel("Xbox");
        cvm2.setManufacturer("Microsoft");
        cvm2.setMemoryAmount("2TB");
        cvm2.setProcessor("Intel i7-2880k");
        cvm2.setPrice(new BigDecimal("300.00"));
        cvm2.setQuantity(new BigDecimal(5));
        cvm2.setId(3);

        String inputJson = mapper.writeValueAsString(cvm2);

        this.mockMvc.perform(put("/console/" + cvm2.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void deleteConsoleTest() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/console/2"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    public void getConsole400ErrorTest() throws Exception{

        String id400Console = "z";

        this.mockMvc.perform(get("/console/" + id400Console))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getConsole404ErrorTest() throws Exception{
        ConsoleViewModel cvm = new ConsoleViewModel();

        int id404Console = 10;

        when(consoleService.getConsoleVm(id404Console)).thenReturn(cvm);

        this.mockMvc.perform(get("/console" + id404Console))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void getConsole405ErrorTest() throws Exception{

        int id405Console = 10;

        this.mockMvc.perform(post("/console/" + id405Console))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());

    }

    @Test
    public void getConsole415ErrorTest() throws Exception{

        ConsoleViewModel cvm2 = new ConsoleViewModel();
        cvm2.setModel("Xbox");
        cvm2.setManufacturer("Microsoft");
        cvm2.setMemoryAmount("2TB");
        cvm2.setProcessor("Intel i7-2880k");
        cvm2.setPrice(new BigDecimal("300.00"));
        cvm2.setQuantity(new BigDecimal(5));
        cvm2.setId(3);

        String inputJson = mapper.writeValueAsString(cvm2);

        this.mockMvc.perform(put("/console/" + cvm2.getId())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_XML))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());

    }

}