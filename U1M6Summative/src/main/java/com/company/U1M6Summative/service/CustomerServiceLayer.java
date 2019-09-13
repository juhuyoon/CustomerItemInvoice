package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dao.InvoiceItemRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceLayer {
    @Autowired
    private CustomerRepository customerRepository;
    //@Autowired
   // private InvoiceRepository invoiceRepository;

}

