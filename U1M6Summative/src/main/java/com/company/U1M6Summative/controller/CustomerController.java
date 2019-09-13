package com.company.U1M6Summative.controller;
import com.company.U1M6Summative.dao.CustomerRepository;
import com.company.U1M6Summative.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
  @Autowired
  private CustomerRepository customerRepo;

  @RequestMapping(value="/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer){
      customerRepo.save(customer);
      return customer;
  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable int customerId){
      Optional<Customer> customer = customerRepo.findById(customerId);
      if(!customer.isPresent())
          throw new IllegalArgumentException("Customer not found");

      return customer.get();
  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer){

      customer.setCustomerId(customerId);
      customerRepo.save(customer);
  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int customerId){
      customerRepo.deleteById(customerId);
  }

  @RequestMapping(value="/customer", method = RequestMethod.GET)
    public List<Customer> getAllCustomers(){
      return customerRepo.findAll();
  }
}

