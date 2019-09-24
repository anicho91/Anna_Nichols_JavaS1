package com.company.AnnaNicholsU1Capstone.controller;

import com.company.AnnaNicholsU1Capstone.service.InvoiceServiceLayer;
import com.company.AnnaNicholsU1Capstone.viewmodel.GameViewModel;
import com.company.AnnaNicholsU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceServiceLayer invoiceService;


        @RequestMapping(value = "/invoice", method = RequestMethod.POST)
        @ResponseStatus(value = HttpStatus.CREATED)
        public InvoiceViewModel createInvoice (@RequestBody InvoiceViewModel invoice){

            return invoiceService.addInvoiceVm(invoice);
        }

    @RequestMapping(value="/invoice", method = RequestMethod.GET)
    public List<InvoiceViewModel> getAllInvoices(){

        return invoiceService.getAllInvoicesVm();
    }

    @RequestMapping(value="/invoice/{invoiceId}", method = RequestMethod.GET)
    public InvoiceViewModel getInvoiceById(@PathVariable int invoiceId){

        return invoiceService.getInvoiceVm(invoiceId);
    }

    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int invoiceId){

        invoiceService.deleteInvoiceVm(invoiceId);
    }


}
