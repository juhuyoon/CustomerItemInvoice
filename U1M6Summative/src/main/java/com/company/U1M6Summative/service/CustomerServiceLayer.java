package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dao.InvoiceRepository;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceLayer implements CustomerViewDao {
    private CustomerRepository customerRepository;
    private InvoiceViewDao invoiceViewDao;

    @Autowired
    public CustomerServiceLayer(CustomerRepository customerRepository, InvoiceViewDao invoiceViewDao) {
        this.customerRepository = customerRepository;
        this.invoiceViewDao = invoiceViewDao;
    }

    //Customer API

    @Transactional
    @Override
    public CustomerViewModel addCustomerVM(CustomerViewModel customerViewModel) {
        Customer customer = new Customer();
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setCompany(customerViewModel.getCompany());
        customer.setPhone(customerViewModel.getPhone());
        customer = customerRepository.save(customer);
        customerViewModel.setCustomerId(customer.getCustomerId());

        List<InvoiceViewModel> ivmList = customerViewModel.getInvoiceViewModelsList();

        ivmList.stream()
                .forEach(i ->
                {
                    i.setId(customerViewModel.getCustomerId());
                    invoiceViewDao.saveIvm(i);

                });
        return customerViewModel;
    }

    @Override
    public CustomerViewModel getCustomerVM(CustomerViewModel customerViewModel) {
        Customer customer = customerRepository.getOne(customerViewModel.getCustomerId());
        return buildCustomerViewModel(customer);
    }

    @Override
    public List<CustomerViewModel> getAllCustomersVM() {
        List<Customer> cList = customerRepository.findAll();

        List<CustomerViewModel> cvmList = new ArrayList<>();

        for(Customer customer : cList) {
            CustomerViewModel cvm = buildCustomerViewModel(customer);
            cvmList.add(cvm);
        }

        return cvmList;
    }

    @Transactional
    @Override
    public void updateCustomerVM(CustomerViewModel customerViewModel) {
        Customer customer = new Customer();
        customer.setCustomerId(customerViewModel.getCustomerId());
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setEmail(customerViewModel.getEmail());
        customer.setCompany(customerViewModel.getCompany());
        customer.setPhone(customerViewModel.getPhone());


        customerRepository.save(customer);

        List<InvoiceViewModel> ivmList = customerViewModel.getInvoiceViewModelsList();

        ivmList.stream()
                .forEach(i -> invoiceViewDao.deleteIvm(i.getCustomerId()));

        List<InvoiceViewModel> ivmList2 = customerViewModel.getInvoiceViewModelsList();
        ivmList2.stream()
                .forEach(i ->
                {
                    i.setId(customerViewModel.getCustomerId());
                    invoiceViewDao.saveIvm(i);

                });
    }


    @Transactional
    @Override
    public void deleteCustomerVM(int id) {
        List<InvoiceViewModel> ivmList = invoiceViewDao.getIvmByCustomer(id);

        ivmList.stream()
                .forEach(i -> invoiceViewDao.deleteIvm(i.getId()));

        customerRepository.deleteById(id);
    }

    //Helper methods
    private CustomerViewModel buildCustomerViewModel(Customer customer) {
        List<InvoiceViewModel> ivmList = invoiceViewDao.getIvmByCustomer(customer.getCustomerId());

        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setCustomerId(customer.getCustomerId());
        cvm.setFirstName(customer.getFirstName());
        cvm.setLastName(customer.getLastName());
        cvm.setEmail(customer.getEmail());
        cvm.setCompany(customer.getCompany());
        cvm.setPhone(customer.getPhone());
        cvm.setInvoiceViewModelsList(ivmList);

        return cvm;
    }
}
