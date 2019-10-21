package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.service.InvoiceServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.InvoiceViewModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(InvoiceController.class)
public class InvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    InvoiceServiceLayer invoiceService;

    @MockBean
    DataSource dataSource;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    @WithAnonymousUser
    public void createInvoiceTestWithAnon() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));

        String inputJson = mapper.writeValueAsString(ivm);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Jack");
        ivm2.setStreet("13 parkway");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("Console");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("33.44"));
        ivm2.setSubtotal(new BigDecimal("50.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("60.99"));
        ivm2.setId(2);

        String outputJson = mapper.writeValueAsString(ivm2);

        when(invoiceService.addInvoiceVm(ivm)).thenReturn(ivm2);

        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockNewUser
    public void createInvoiceTestWithNewUser() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));

        String inputJson = mapper.writeValueAsString(ivm);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Jack");
        ivm2.setStreet("13 parkway");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("Console");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("33.44"));
        ivm2.setSubtotal(new BigDecimal("50.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("60.99"));
        ivm2.setId(2);

        String outputJson = mapper.writeValueAsString(ivm2);

        when(invoiceService.addInvoiceVm(ivm)).thenReturn(ivm2);

        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockStaffMember
    public void createInvoiceTestWithStaffMember() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));

        String inputJson = mapper.writeValueAsString(ivm);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Jack");
        ivm2.setStreet("13 parkway");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("Console");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("33.44"));
        ivm2.setSubtotal(new BigDecimal("50.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("60.99"));
        ivm2.setId(2);

        String outputJson = mapper.writeValueAsString(ivm2);

        when(invoiceService.addInvoiceVm(ivm)).thenReturn(ivm2);

        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockManager
    public void createInvoiceTestWithManager() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));

        String inputJson = mapper.writeValueAsString(ivm);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Jack");
        ivm2.setStreet("13 parkway");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("Console");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("33.44"));
        ivm2.setSubtotal(new BigDecimal("50.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("60.99"));
        ivm2.setId(2);

        String outputJson = mapper.writeValueAsString(ivm2);

        when(invoiceService.addInvoiceVm(ivm)).thenReturn(ivm2);

        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    @WithMockAdmin
    public void createInvoiceTestWithAdmin() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));

        String inputJson = mapper.writeValueAsString(ivm);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Jack");
        ivm2.setStreet("13 parkway");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("Console");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("33.44"));
        ivm2.setSubtotal(new BigDecimal("50.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("60.99"));
        ivm2.setId(2);

        String outputJson = mapper.writeValueAsString(ivm2);

        when(invoiceService.addInvoiceVm(ivm)).thenReturn(ivm2);

        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader())
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllInvoicesTest() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));
        ivm.setId(2);

        InvoiceViewModel ivm2 = new InvoiceViewModel();
        ivm2.setName("Peggy");
        ivm2.setStreet("211 downing");
        ivm2.setCity("Atlanta");
        ivm2.setState("GA");
        ivm2.setZipcode("30109");
        ivm2.setItemType("TShirt");
        ivm2.setItemId(3);
        ivm2.setQuantity(5);
        ivm2.setUnitPrice(new BigDecimal("10.44"));
        ivm2.setSubtotal(new BigDecimal("20.02"));
        ivm2.setTax(new BigDecimal(".04"));
        ivm2.setProcessingFee(new BigDecimal("1.99"));
        ivm2.setTotal(new BigDecimal("30.99"));
        ivm2.setId(3);

        List<InvoiceViewModel> ivmList = new ArrayList<>();
        ivmList.add(ivm);
        ivmList.add(ivm2);

        when(invoiceService.getAllInvoicesVm()).thenReturn(ivmList);

        List<InvoiceViewModel> ivmList2 = new ArrayList<>();
        ivmList2.addAll(ivmList);

        String outputJson = mapper.writeValueAsString(ivmList2);

        this.mockMvc.perform(get("/invoice"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getInvoiceByIdTest() throws Exception {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setName("Jack");
        ivm.setStreet("13 parkway");
        ivm.setCity("Atlanta");
        ivm.setState("GA");
        ivm.setZipcode("30109");
        ivm.setItemType("Console");
        ivm.setItemId(3);
        ivm.setQuantity(5);
        ivm.setUnitPrice(new BigDecimal("33.44"));
        ivm.setSubtotal(new BigDecimal("50.02"));
        ivm.setTax(new BigDecimal(".04"));
        ivm.setProcessingFee(new BigDecimal("1.99"));
        ivm.setTotal(new BigDecimal("60.99"));
        ivm.setId(2);

        String outputJson = mapper.writeValueAsString(ivm);

        when(invoiceService.getInvoiceVm(2)).thenReturn(ivm);

        this.mockMvc.perform(get("/invoice/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }

    @Test
    @WithAnonymousUser
    public void deleteInvoiceTestWithAnon() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/invoice/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockNewUser
    public void deleteInvoiceTestWithNewUser() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/invoice/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockStaffMember
    public void deleteInvoiceTestWithStaffMember() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/invoice/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockManager
    public void deleteInvoiceTestWithManager() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/invoice/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isForbidden());
    }

    @Test
    @WithMockAdmin
    public void deleteInvoiceTestWithAdmin() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/invoice/2")
                .with(csrf().asHeader()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    @Test
    @WithMockAdmin
    public void postInvoice400ErrorTest() throws Exception{
        this.mockMvc.perform(post("/invoice")
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void getInvoice422ErrorTest() throws Exception{

        String id422Invoice = "z";

        this.mockMvc.perform(get("/invoice/" + id422Invoice))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void getInvoice404ErrorTest() throws Exception{
        InvoiceViewModel ivm = new InvoiceViewModel();

        int id404Invoice = 10;

        when(invoiceService.getInvoiceVm(id404Invoice)).thenReturn(ivm);

        this.mockMvc.perform(get("/invoice" + id404Invoice))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockAdmin
    public void postInvoice405ErrorTest() throws Exception{

        int id405Invoice = 10;

        this.mockMvc.perform(post("/invoice/" + id405Invoice)
                .with(csrf().asHeader()))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());

    }

}