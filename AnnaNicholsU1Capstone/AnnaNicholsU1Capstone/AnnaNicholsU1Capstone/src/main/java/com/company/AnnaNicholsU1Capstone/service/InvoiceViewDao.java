package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.viewmodel.InvoiceViewModel;

import java.util.List;

public interface InvoiceViewDao {

    InvoiceViewModel addInvoiceVm(InvoiceViewModel invoiceViewModel);

    InvoiceViewModel getInvoiceVm(int invoiceId);

    List<InvoiceViewModel> getAllInvoicesVm();

    void deleteInvoiceVm(int invoiceId);
    
}
