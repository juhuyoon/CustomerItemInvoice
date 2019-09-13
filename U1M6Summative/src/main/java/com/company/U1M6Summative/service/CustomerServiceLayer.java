package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CustomerServiceLayer {
    private CustomerRepository customerRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public CustomerServiceLayer(CustomerRepository customerRepository, InvoiceRepository invoiceRepository) {
        this.customerRepository = customerRepository;
        this.invoiceRepository = invoiceRepository;
    }

    //Customer API
    @Transactional
    public CustomerViewModel saveCustomer(CustomerViewModel viewModel) {

        Customer customer = new Customer();
        customer.setFirstName(viewModel.getFirstName());
        customer.setLastName(viewModel.getLastName());
        customer.setEmail(viewModel.getEmail());
        customer.setCompany(viewModel.getCompany());
        customer.setPhone(viewModel.getPhone());
        customer = customerRepository.save(customer);
        viewModel.setCustomerId(customer.getCustomerId());

        return viewModel;

//        List<InvoiceViewModel> invoices = viewModel.getInvoiceViewModelsList();

//        invoices.stream()
//                .forEach(i ->
//                        {
//                            i.setId(viewModel.getCustomerId());
//                            InvoiceViewInterface.saveInvoice(i);
//
//                        });
//
//       // invoices = invoiceRepository.findById(viewModel.getCustomerId());
//
//    return invoices;
//    }
//        return null;
    }
}
