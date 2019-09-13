package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class CustomerRepositoryTest {
    @Before
    public void setUp() throws Exception {
    }


    @Autowired
    private CustomerRepository customerRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void AddAllCustomers() {
        //customerRepo.deleteAll();

        Customer aCustomer = new Customer();

        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Angy");
        aCustomer.setLastName("Manni");
        aCustomer.setCompany("Amazon");
        aCustomer.setEmail("Angy@amazon.com");
        aCustomer.setPhone("678-229-7788");

        customerRepo.save(aCustomer);

        List<Customer> customerList = customerRepo.findAll();
        assertEquals(1, customerList.size());
    }

    @Test
    public void addGetDeleteCustomer() {

        Customer customer = new Customer();
//        customer.setCustomerId(1);
        customer.setFirstName("James");
        customer.setLastName("Twin");
        customer.setCompany("Group co");
        customer.setEmail("ya@yahoo.com");
        customer.setPhone("404-542-0011");

        customer = customerRepo.save(customer);

        Optional<Customer> cust = customerRepo.findById(customer.getCustomerId());

        assertEquals(customer, cust.get());

        customerRepo.deleteById(customer.getCustomerId());

        //customer2 = customerRepo.getOne(1);

        //assertNull(customer2);
    }

    @Test
    public void getAllCustomers() {

        Customer aCustomer = new Customer();
        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Jan");
        aCustomer.setLastName("Mac");
        aCustomer.setCompany("Mac&co");
        aCustomer.setEmail("red@mac.com");
        aCustomer.setPhone("505-333-2211");

        customerRepo.save(aCustomer);

        aCustomer = new Customer();
        aCustomer.setCustomerId(2);
        aCustomer.setFirstName("Jane");
        aCustomer.setLastName("Maco");
        aCustomer.setCompany("Mac&co");
        aCustomer.setEmail("maco@mac.com");
        aCustomer.setPhone("501-333-2211");

        customerRepo.save(aCustomer);

        List<Customer> cList = customerRepo.findAll();

        assertEquals(cList.size(), 2);
    }

    @Test
    public void getCustomerById() {
        Customer aCustomer = new Customer();
        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Jan");
        aCustomer.setLastName("Mac");
        aCustomer.setCompany("Mac&co");
        aCustomer.setEmail("red@mac.com");
        aCustomer.setPhone("505-333-2211");

        customerRepo.save(aCustomer);

        Customer customer = customerRepo.getOne(aCustomer.getCustomerId());
        assertEquals((int) customer.getCustomerId(), 1);

    }

    @Test
    public void updateCustomer() {

        Customer aCustomer = new Customer();
        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Jan");
        aCustomer.setLastName("Mac");
        aCustomer.setCompany("Mac&co");
        aCustomer.setEmail("red@mac.com");
        aCustomer.setPhone("505-333-2211");

        customerRepo.save(aCustomer);

        aCustomer.setCustomerId(1);
        aCustomer.setFirstName("Manny");
        aCustomer.setLastName("Jude");
        aCustomer.setCompany("Company&co");
        aCustomer.setEmail("jude@company.com");
        aCustomer.setPhone("502-333-2211");

        customerRepo.save(aCustomer);

        Customer aCustomer2 = customerRepo.getOne(aCustomer.getCustomerId());

        assertEquals(aCustomer2, aCustomer);
    }
}