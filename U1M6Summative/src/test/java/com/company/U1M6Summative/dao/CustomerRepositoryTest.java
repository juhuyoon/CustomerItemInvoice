package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerRepositoryTest {
    @Before
    public void setUp() throws Exception {
    }


    @Autowired
    CustomerRepository customerRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void createTest() {
        customerRepo.deleteAll();

        Customer aCustomer = new Customer();

        aCustomer.setCustomerId(1);
        aCustomer.setFirst_name("");
        aCustomer.setLast_name("");
        aCustomer.setCompany("");
        aCustomer.setEmail("");
        aCustomer.setPhone("");

        customerRepo.save(aCustomer);

        List<Customer> customerList = customerRepo.findAll();
        assertEquals(1, customerList.size());
    }

    @Test
    public void addGetDeleteCustomer() {

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirst_name("");
        customer.setLast_name("Twin");
        customer.setCompany("");
        customer.setEmail("");
        customer.setPhone("");

        customer = customerRepo..addCustomer(customer);

        Customer customer2 = dao.getCustomer(customer.getId());

        assertEquals(customer, customer2);

        dao.deleteCustomer(customer.getId());

        customer2 = dao.getCustomer(customer.getId());

        assertNull(customer2);
    }
}
