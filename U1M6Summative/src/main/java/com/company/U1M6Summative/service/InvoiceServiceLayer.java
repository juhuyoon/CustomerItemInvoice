package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.InvoiceItemRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dao.ItemRepository;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
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
    private ItemRepository itemRepo;

    @Autowired
    public InvoiceServiceLayer(InvoiceItemRepository invoiceItemRepo, InvoiceRepository invoiceRepo) {
        this.invoiceItemRepo = invoiceItemRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @Transactional
    InvoiceItemViewModel saveIivm(InvoiceItemViewModel iivm) {
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(iivm.getInvoiceId());
        invoiceItem.setItemId(iivm.getItem().getId());
        invoiceItem.setQuantity(iivm.getQuantity());
        invoiceItem.setUnitRate(iivm.getUnitRate());
        invoiceItem.setDiscount(iivm.getDiscount());
        invoiceItem = invoiceItemRepo.save(invoiceItem);
        iivm.setId(invoiceItem.getId());

        return iivm;
    }

    private InvoiceItemViewModel findIivm(Integer id) {
        //Get the InvoiceItem object first
        InvoiceItem invoiceItem = invoiceItemRepo.getOne(id);

        return buildInvoiceItemViewModel(invoiceItem);
    }

    private List<InvoiceItemViewModel> findIivmByInvoiceId(int invoiceId) {
        List<InvoiceItem> invoiceItemList = invoiceItemRepo.findByInvoiceId(invoiceId);
        List<InvoiceItemViewModel> iivmList = new ArrayList<>();

        for (InvoiceItem invoiceItem : invoiceItemList) {
            InvoiceItemViewModel iivm = buildInvoiceItemViewModel(invoiceItem);
            iivmList.add(iivm);
        }

        return iivmList;
    }

    private void updateIivm(InvoiceItemViewModel iivm) {
        //update InvoiceItem database
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setId(iivm.getId());
        invoiceItem.setInvoiceId(iivm.getInvoiceId());
        invoiceItem.setItemId(iivm.getItem().getId());
        invoiceItem.setQuantity(iivm.getQuantity());
        invoiceItem.setUnitRate(iivm.getUnitRate());
        invoiceItem.setDiscount(iivm.getDiscount());
        invoiceItemRepo.save(invoiceItem);
    }

    private void deleteIivm(Integer id) {
        invoiceItemRepo.deleteById(id);
    }

    private InvoiceItemViewModel buildInvoiceItemViewModel(InvoiceItem invoiceItem) {
        //Get the associated Item
        Item item = itemRepo.getOne(invoiceItem.getItemId());

        //Assemble the InvoiceItemViewModel
        InvoiceItemViewModel iivm = new InvoiceItemViewModel();
        iivm.setId(invoiceItem.getId());
        iivm.setInvoiceId(invoiceItem.getInvoiceId());
        iivm.setItem(item);
        iivm.setQuantity(invoiceItem.getQuantity());
        iivm.setUnitRate(invoiceItem.getUnitRate());
        iivm.setDiscount(invoiceItem.getDiscount());

        return iivm;
    }

    //-----------------------Start of Invoice view model

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

        List<InvoiceItemViewModel> iivmList = ivm.getInvoiceItemViewModelList();
        iivmList.stream()
                .forEach(iivm -> {
                    iivm.setInvoiceId(ivm.getId());
                    saveIivm(iivm);
                });

        iivmList = findIivmByInvoiceId(ivm.getId());
        ivm.setInvoiceItemViewModelList(iivmList);

        return ivm;
    }

    @Override
    public InvoiceViewModel getIvm(Integer invoiceId) {
        //Get the invoice object first
        Invoice invoice = invoiceRepo.getOne(invoiceId);

        return buildInvoiceViewModel(invoice);
    }

    @Override
    public List<InvoiceViewModel> getAllIvm() {
        List<Invoice> invoiceList = invoiceRepo.findAll();
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    @Override
    public void updateIvm(InvoiceViewModel ivm) {
        //update Invoice database
        Invoice invoice = new Invoice();
        invoice.setId(ivm.getId());
        invoice.setCustomerId(ivm.getCustomerId());
        invoice.setOrderDate(ivm.getOrderDate());
        invoice.setPickupDate(ivm.getPickupDate());
        invoice.setReturnDate(ivm.getReturnDate());
        invoice.setLateFee(ivm.getLateFee());
        invoiceRepo.save(invoice);

        // We don't know if any invoice items have been removed so delete all associated invoice items in DB
        // and then associate the invoice items in the InvoiceViewModel with the invoice
        List<InvoiceItemViewModel> iivmList = findIivmByInvoiceId(ivm.getId());
        iivmList.stream()
                .forEach(iivm -> deleteIivm(iivm.getId()));

        iivmList = ivm.getInvoiceItemViewModelList();
        iivmList.stream()
                .forEach(iivm -> {
                    iivm.setInvoiceId(ivm.getId());
                    saveIivm(iivm);
                });
    }

    @Override
    public void deleteIvm(Integer invoiceId) {
        //Delete all associated invoice items first
        List<InvoiceItemViewModel> iivmList = findIivmByInvoiceId(invoiceId);

        iivmList.stream()
                .forEach(iivm -> {
                    deleteIivm(iivm.getId());
                });
    }

    @Override
    public List<InvoiceViewModel> getIvmByCustomer(Integer customerId) {
        List<Invoice> invoiceList = invoiceRepo.findInvoicesByCustomerId(customerId);
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }

        return ivmList;
    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        //List of associated invoice item view models
        List<InvoiceItemViewModel> iivmList = findIivmByInvoiceId(invoice.getId());

        //Assemble the invoice view model
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getId());
        ivm.setCustomerId(invoice.getCustomerId());
        ivm.setOrderDate(invoice.getOrderDate());
        ivm.setPickupDate(invoice.getPickupDate());
        ivm.setReturnDate(invoice.getReturnDate());
        ivm.setLateFee(invoice.getLateFee());
        ivm.setInvoiceItemViewModelList(iivmList);

        return ivm;
    }
}