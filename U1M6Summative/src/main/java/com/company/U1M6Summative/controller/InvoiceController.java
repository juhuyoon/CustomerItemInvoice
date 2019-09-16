package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.service.CustomerServiceLayer;
import com.company.U1M6Summative.service.InvoiceServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceServiceLayer invoiceService;
    @Autowired
    CustomerServiceLayer customerService;

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel postInvoice(@RequestBody InvoiceViewModel invoice){
        return invoiceService.saveIvm(invoice);

    }

//    FOR USE IN POSTMAN; TO BE REMOVED
    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getInvoice(){

       return invoiceService.getAllIvm();

    }

    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable int invoiceId){

        invoiceService.deleteIvm(invoiceId);
    }

    @RequestMapping(value = "/invoice/customer/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getByCustomer(@PathVariable int customerId){


        List<InvoiceViewModel> invoices = invoiceService.getIvmByCustomer(customerId);

        return invoices;
    }

}
