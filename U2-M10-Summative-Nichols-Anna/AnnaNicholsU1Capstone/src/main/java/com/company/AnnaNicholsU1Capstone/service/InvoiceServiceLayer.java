package com.company.AnnaNicholsU1Capstone.service;

import com.company.AnnaNicholsU1Capstone.dao.*;
import com.company.AnnaNicholsU1Capstone.dto.*;
import com.company.AnnaNicholsU1Capstone.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceServiceLayer implements InvoiceViewDao {

    private InvoiceDaoJdbcTemplateImpl iDJT;
    private InvoiceDao invoiceDao;
    private TShirtViewModel tShirtViewModel;
    private ConsoleViewModel consoleViewModel;
    private GameViewModel gameViewModel;
    private ProcessingFeeViewModel processingFeeViewModel;
    private SalesTaxRateViewModel salesTaxRateViewModel;
    private ConsoleDao consoleDao;
    private InvoiceViewDao invoiceViewDao;
    private GameDao gameDao;
    private TShirtDao tShirtDao;
    private SalesTaxRateDao salesTaxRateDao;
    private SalesTaxRate salesTaxRate;
    private Console console;
    private Game game;
    private TShirt tShirt;

    @Autowired
    public InvoiceServiceLayer(InvoiceDaoJdbcTemplateImpl iDJT, GameDao gameDao, ConsoleDao consoleDao, TShirtDao tShirtDao) {
        this.iDJT = iDJT;
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.tShirtDao = tShirtDao;
    }

    @Override
    public InvoiceViewModel addInvoiceVm(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setQuantity(invoiceViewModel.getQuantity());


        String findItem = invoice.getItemType();

        //Getting the tax rate based on passed in state
        String state = invoiceViewModel.getState();

        SalesTaxRateViewModel salesTaxRateViewModel = new SalesTaxRateViewModel();

        salesTaxRateViewModel.setState(invoice.getState());
        salesTaxRateViewModel.setRate(salesTaxRateViewModel.findStateTax(state));

        invoice.setTax(salesTaxRateViewModel.getRate());

        //Getting the processing fee based on passed in product type
        String itemType = invoiceViewModel.getItemType();

        ProcessingFeeViewModel processingFeeViewModel = new ProcessingFeeViewModel();
        processingFeeViewModel.setProductType(invoice.getItemType());
        processingFeeViewModel.setFee(processingFeeViewModel.findFee(itemType));

        invoice.setProcessingFee(processingFeeViewModel.getFee());

        //Setting invoice quantity to BigDecimal to compare quantities
        BigDecimal invoiceQuantity = new BigDecimal(invoice.getQuantity());

        if (findItem.equalsIgnoreCase("TShirt")){

            List<TShirt> tshirts = tShirtDao.getAllTShirts();

            tshirts.stream()
                    .forEach(tShirt ->
                    {
                        tShirt.setId(invoiceViewModel.getItemId());


                    });

            if(tShirt.getQuantity().compareTo(invoiceQuantity)>0) {
                invoice.setUnitPrice(tShirtDao.getTShirt(invoice.getItemId()).getPrice());

                BigDecimal unitPrice = invoice.getUnitPrice();
                BigDecimal quantity = new BigDecimal(invoice.getQuantity());

                BigDecimal newQuantity = tShirtDao.getTShirt(invoice.getItemId()).getQuantity().subtract(invoiceQuantity);
                tShirtDao.getTShirt(invoice.getItemId()).setQuantity(newQuantity);

                invoice.setSubtotal(unitPrice.multiply(quantity));

                BigDecimal sub1 = invoice.getSubtotal().multiply(invoice.getTax());
                BigDecimal sub2 = sub1.add(invoice.getSubtotal());

                if (invoiceViewModel.getQuantity() > 10) {
                    invoice.setProcessingFee(new BigDecimal(String.valueOf(invoice.getProcessingFee().add(new BigDecimal("15.49")))));
                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                } else {

                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                }

                invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
                invoiceViewModel.setQuantity(invoice.getQuantity());
                invoiceViewModel.setSubtotal(invoice.getSubtotal());
                invoiceViewModel.setTax(invoice.getTax());
                invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
                invoiceViewModel.setTotal(invoice.getTotal());
                invoiceViewModel.setId(invoice.getId());
                return invoiceViewModel;
            }

        }else if(findItem.equalsIgnoreCase("Console")){

            List<Console> consoles = consoleDao.getAllConsoles();

            consoles.stream()
                    .forEach(console ->
                    {
                        console.setId(invoiceViewModel.getItemId());

                    });

            if(consoleDao.getConsole(invoiceViewModel.getItemId()).getQuantity().compareTo(invoiceQuantity)>0) {

                invoice.setUnitPrice(consoleDao.getConsole(invoice.getItemId()).getPrice());

                BigDecimal unitPrice = invoice.getUnitPrice();
                BigDecimal quantity = new BigDecimal(invoice.getQuantity());

                BigDecimal newQuantity = consoleDao.getConsole(invoice.getItemId()).getQuantity().subtract(invoiceQuantity);
                consoleDao.getConsole(invoice.getItemId()).setQuantity(newQuantity);

                invoice.setSubtotal(unitPrice.multiply(quantity));

                BigDecimal sub1 = invoice.getSubtotal().multiply(invoice.getTax());
                BigDecimal sub2 = sub1.add(invoice.getSubtotal());

                if (invoiceViewModel.getQuantity() > 10) {
                    invoice.setProcessingFee(new BigDecimal(String.valueOf(invoice.getProcessingFee().add(new BigDecimal("15.49")))));
                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                } else {
                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                }

                invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
                invoiceViewModel.setQuantity(invoice.getQuantity());
                invoiceViewModel.setSubtotal(invoice.getSubtotal());
                invoiceViewModel.setTax(invoice.getTax());
                invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
                invoiceViewModel.setTotal(invoice.getTotal());
                invoiceViewModel.setId(invoice.getId());
                return invoiceViewModel;
            }
        }else if(findItem.equalsIgnoreCase("Game")){

            List<Game> games = gameDao.getAllGames();

            games.stream()
                    .forEach(game ->
                    {
                        game.setId(invoiceViewModel.getItemId());

                    });

            if(gameDao.getGame(invoice.getItemId()).getQuantity().compareTo(invoiceQuantity)>0) {
                invoice.setUnitPrice(gameDao.getGame(invoice.getItemId()).getPrice());

                BigDecimal unitPrice = invoice.getUnitPrice();
                BigDecimal quantity = new BigDecimal(invoice.getQuantity());

                BigDecimal newQuantity = gameDao.getGame(invoice.getItemId()).getQuantity().subtract(invoiceQuantity);
                gameDao.getGame(invoice.getItemId()).setQuantity(newQuantity);

                invoice.setSubtotal(unitPrice.multiply(quantity));

                BigDecimal sub1 = invoice.getSubtotal().multiply(invoice.getTax());
                BigDecimal sub2 = sub1.add(invoice.getSubtotal());

                if (invoiceViewModel.getQuantity() > 10) {
                    invoice.setProcessingFee(new BigDecimal(String.valueOf(invoice.getProcessingFee().add(new BigDecimal("15.49")))));
                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                } else {
                    invoice.setTotal(sub2.add(invoice.getProcessingFee()));
                }

                invoiceViewModel.setUnitPrice(invoice.getUnitPrice());
                invoiceViewModel.setQuantity(invoice.getQuantity());
                invoiceViewModel.setSubtotal(invoice.getSubtotal());
                invoiceViewModel.setTax(invoice.getTax());
                invoiceViewModel.setProcessingFee(invoice.getProcessingFee());
                invoiceViewModel.setTotal(invoice.getTotal());
                invoiceViewModel.setId(invoice.getId());
                return invoiceViewModel;
            }
        }

        return null;
    }

    @Override
    public InvoiceViewModel getInvoiceVm(int invoiceId) {
        Invoice invoice = invoiceDao.getInvoice(invoiceId);
        return buildInvoiceViewModel(invoice);
    }

    @Override
    public List<InvoiceViewModel> getAllInvoicesVm() {
        List<Invoice> invoices = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> invoiceViewModels = new ArrayList<>();

        for (Invoice invoice : invoices){
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            invoiceViewModels.add(ivm);
        }

        return invoiceViewModels;
    }

    @Override
    public void deleteInvoiceVm(int invoiceId) {

        invoiceDao.deleteInvoice(invoiceId);
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice){

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setName(invoice.getName());
        ivm.setStreet(invoice.getStreet());
        ivm.setCity(invoice.getCity());
        ivm.setState(invoice.getState());
        ivm.setZipcode(invoice.getZipcode());
        ivm.setItemType(invoice.getItemType());
        ivm.setItemId(invoice.getItemId());
        ivm.setUnitPrice(invoice.getUnitPrice());
        ivm.setQuantity(invoice.getQuantity());
        ivm.setSubtotal(invoice.getSubtotal());
        ivm.setTax(invoice.getTax());
        ivm.setProcessingFee(invoice.getProcessingFee());
        ivm.setTotal(invoice.getTotal());

        return ivm;

    }
}
