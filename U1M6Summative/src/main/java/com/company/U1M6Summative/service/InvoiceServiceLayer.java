package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.InvoiceItemRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class InvoiceServiceLayer {

    private InvoiceItemRepository invoiceItemRepo;
    private InvoiceRepository invoiceRepo;

    @Autowired
    public InvoiceServiceLayer(InvoiceItemRepository invoiceItemRepo, InvoiceRepository invoiceRepo) {
        this.invoiceItemRepo = invoiceItemRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(ivm.getCustomerId());
        invoice.setOrderDate(ivm.getOrderDate());
        invoice.setPickupDate(ivm.getPickupDate());
        invoice.setReturnDate(ivm.getReturnDate());
        invoice.setLateFee(ivm.getLateFee());
        invoice = invoiceRepo.save(invoice);
        ivm.setId(invoice.getId());

        List<InvoiceItem> invoiceItemList = ivm.getInvoiceItemList();
        invoiceItemList.stream()
                .forEach(invoiceItem -> {
                    invoiceItem.setInvoiceId(ivm.getId());
                    invoiceItemRepo.save(invoiceItem);
                });

        invoiceItemList = invoiceItemRepo.findByInvoiceId(ivm.getId());
        ivm.setInvoiceItemList(invoiceItemList);

        return ivm;
    }

//    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
//        //List of associated invoice items
//        List<InvoiceItem> invoiceItemList = invoiceItemRepo.findByInvoiceId(invoice.getId());
//
//    }

}