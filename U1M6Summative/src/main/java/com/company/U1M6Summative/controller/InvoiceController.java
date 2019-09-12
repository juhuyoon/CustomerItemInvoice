package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dto.Invoice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InvoiceController {

    private List<Invoice> invoiceList = new ArrayList<>();

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice postInvoice(@RequestBody @Valid Invoice invoice){
        invoiceList.add(invoice);

        return invoice;
    }

//    FOR USE IN POSTMAN; TO BE REMOVED
//    @RequestMapping(value = "/invoice", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Invoice> getInvoice(){
//
//        return invoiceList;
//    }

    @RequestMapping(value = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteInvoice(@PathVariable int invoiceId){

        invoiceList.remove(invoiceId);
    }

    @RequestMapping(value = "/invoice/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice getByCustomer(@PathVariable int customerId){

        for(Invoice invoice : invoiceList){
            if(invoice.getCustomerId().equals(customerId))
                return invoice;
        }

        throw new IllegalArgumentException("Customer's invoice not found");
    }

}
