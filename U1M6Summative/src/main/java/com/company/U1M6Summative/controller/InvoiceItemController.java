package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dao.InvoiceItemRepository;
import com.company.U1M6Summative.dto.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceItemController {

    @Autowired
    InvoiceItemRepository invoiceItemRepo;

    @RequestMapping(value = "/invoiceitem", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceItem postInvoice(@RequestBody InvoiceItem invoiceItem){
        return invoiceItemRepo.save(invoiceItem);

    }

    @RequestMapping(value = "/invoiceitem", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceItem> getInvoiceItems() {

        return invoiceItemRepo.findAll();
    }

}
