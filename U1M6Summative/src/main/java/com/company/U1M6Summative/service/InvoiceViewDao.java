package com.company.U1M6Summative.service;

import com.company.U1M6Summative.viewmodel.InvoiceViewModel;

import java.util.List;

public interface InvoiceViewDao {

    InvoiceViewModel saveIvm(InvoiceViewModel ivm);

    InvoiceViewModel getIvm(int invoiceId);

    List<InvoiceViewModel> getAllIvm();

    void updateIvm(InvoiceViewModel ivm);

    void deleteIvm(int invoiceId);

    List<InvoiceViewModel> getIvmByCustomer(Integer customerId);
}
