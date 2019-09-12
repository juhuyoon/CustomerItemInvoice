package com.company.U1M6Summative.controller;

import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepo;

    private List<Customer> customersList = new ArrayList<>();

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer postCustomer(@RequestBody @Valid Customer customer) {
        return customerRepo.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Customer> getCustomers() {

        return customerRepo.findAll();
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Customer getOneCustomer(@PathVariable int customerId) {
       Optional<Customer> customer = customerRepo.findById(customerId);
        if(!customer.isPresent())
            throw new IllegalArgumentException("Customer not found");

        return customer.get();
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteCustomer(@PathVariable int customerId) {

        customerRepo.deleteById(customerId);
    }

    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        Optional<Customer> customerOp = customerRepo.findById(customerId);
        customer.setId(customerId);
        customerRepo.save(customer);
    }
}
