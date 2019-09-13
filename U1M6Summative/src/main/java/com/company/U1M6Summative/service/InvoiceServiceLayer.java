package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.InvoiceItemRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.viewmodel.InvoiceItemViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceServiceLayer implements InvoiceViewDao {

    private InvoiceItemRepository invoiceItemRepo;
    private InvoiceRepository invoiceRepo;

    @Autowired
    public InvoiceServiceLayer(InvoiceItemRepository invoiceItemRepo, InvoiceRepository invoiceRepo) {
        this.invoiceItemRepo = invoiceItemRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @Transactional
    public InvoiceItemViewModel saveIivm(InvoiceItemViewModel iivm) {

        return iivm;
    }

    @Override
    @Transactional
    public InvoiceViewModel saveIvm(InvoiceViewModel ivm) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(ivm.getCustomerId());
        invoice.setOrderDate(ivm.getOrderDate());
        invoice.setPickupDate(ivm.getPickupDate());
        invoice.setReturnDate(ivm.getReturnDate());
        invoice.setLateFee(ivm.getLateFee());
        invoice = invoiceRepo.save(invoice);
        ivm.setId(invoice.getId());

        List<InvoiceItemViewModel> invoiceItemViewModelList = ivm.getInvoiceItemViewModelList();
        invoiceItemViewModelList.stream()
                .forEach(invoiceItemViewModel -> {
                    invoiceItemViewModel.setInvoiceId(ivm.getId());
                });

//        invoiceItemViewModelList = invoiceItemRepo.findByInvoiceId(ivm.getId());
//        ivm.setInvoiceItemViewModelList(invoiceItemViewModelList);

        return ivm;
    }

//    public InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
//        //List of associated invoice items
//        List<InvoiceItem> invoiceItemList = invoiceItemRepo.findByInvoiceId(invoice.getId());
//
//    }


    @Override
    public InvoiceViewModel getIvm(int invoiceId) {
        return null;
    }

    @Override
    public List<InvoiceViewModel> getAllIvm() {

    }

//    @Override
//    public List<Invoice> getAllIvm() {
//        return invoiceRepo.findAll();
//    }

    @Override
    public void updateIvm(InvoiceViewModel ivm) {

    }

    @Override
    public void deleteIvm(int invoiceId) {

    }

    @Override
    public List<InvoiceViewModel> getIvmByCustomer(int customerId) {
        return null;
    }
}