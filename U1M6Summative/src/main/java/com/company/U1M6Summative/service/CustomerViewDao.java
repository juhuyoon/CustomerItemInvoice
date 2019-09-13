package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;

import java.util.List;

public interface CustomerViewDao {
    CustomerViewModel addCustomerVM(CustomerViewModel customerViewModel);

    CustomerViewModel getCustomerVM(CustomerViewModel customerViewModel);

    List<CustomerViewModel> getAllCustomersVM();

    void updateCustomerVM(CustomerViewModel customerViewModel);

    void deleteCustomerVM(int id);

}
