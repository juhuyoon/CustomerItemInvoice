package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceLayer {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
}
