
package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CustomerServiceLayerTest {

    CustomerServiceLayer Service;
    CustomerRepository customerRepo;
    InvoiceViewDao invoiceViewDao;

    @Before
    public void setUp() throws Exception{
        setUpCustomerRepositoryMock();

        Service = new CustomerServiceLayer(customerRepo, invoiceViewDao);
    }

    @Test
    public void saveFindFindAllCustomer() {

        CustomerViewModel cvm = new CustomerViewModel();
        cvm.setFirstName("Angy");
        cvm.setLastName("Manni");
        cvm.setCompany("Amazon");
        cvm.setEmail("Angy@amazon.com");
        cvm.setPhone("678-229-7788");

        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setOrderDate(LocalDate.of(2019,5,20));
        ivm.setPickupDate(LocalDate.of(2019,5, 22));
        ivm.setReturnDate(LocalDate.of(2019, 5,25));
        ivm.setLateFee(new BigDecimal(4.00));

        //cvm.setInvoiceViewModelsList(
        List<InvoiceViewModel > invoiceViewModelsList  = new ArrayList<>();
        invoiceViewModelsList.add(ivm);

        cvm = Service.addCustomerVM(cvm);

        CustomerViewModel fromService = Service.getCustomerVM(cvm.getCustomerId());

        assertEquals(cvm, fromService);


    }

    // Helper methods
    private void setUpCustomerRepositoryMock() {
        customerRepo = mock(CustomerRepository.class);
        Customer aCustomer = new Customer();

        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Angy");
        aCustomer.setLastName("Manni");
        aCustomer.setCompany("Amazon");
        aCustomer.setEmail("Angy@amazon.com");
        aCustomer.setPhone("678-229-7788");

        Customer customer2 = new Customer();
        customer2.setFirstName("Angy");
        customer2.setLastName("Manni");
        customer2.setCompany("Amazon");
        customer2.setEmail("Angy@amazon.com");
        customer2.setPhone("678-229-7788");

        List<Customer> customerList = new ArrayList<>();
        customerList.add( aCustomer);

        doReturn(aCustomer).when(customerRepo).save(customer2);
        doReturn(aCustomer).when(customerRepo).getOne(1);
        doReturn(customerList).when(customerRepo).findAll();
    }

    }


