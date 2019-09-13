package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dto.Customer;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CustomerServiceLayerTest {

    CustomerServiceLayer Service;
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception{
        setUpCustomerRepositoryMock();

        Service = new CustomerServiceLayer(customerRepo);
    }

    @Test
    public void saveFindAllCustomer() {

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("Angy");
        customer.setLastName("Manni");
        customer.setCompany("Amazon");
        customer.setEmail("Angy@amazon.com");
        customer.setPhone("678-229-7788");

        customer = Service.saveCustomer(customer);
        Customer fromService = Service.findCustomer(customer.getCustomerId());

        assertEquals(customer, fromService);
        List<Customer> cList = Service.findAllCustomers();
        assertEquals(1, cList.size());
        assertEquals(customer, cList.get(0));

    }

    // Helper methods
    private void setUpCustomerRepositoryMock() {
        customerRepo = mock(CustomerRepository);
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

        doReturn(aCustomer).when(customerRepo).addCustomer(aCustomer2);
        doReturn(aCustomer).when(customerRepo).getCustomer(1);
        doReturn(customerList).when(customerRepo).getAllCustomers();
    }

    }

