//package com.company.U1M6Summative.controller;
//import com.company.U1M6Summative.dao.CustomerRepository;
//import com.company.U1M6Summative.dto.Customer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//
//public class CustomerController {
//  @Autowired
//  private CustomerRepository customerRepo;
//
//  @RequestMapping(value="/customers", method = RequestMethod.POST)
//    public Customer createCustomer(@RequestBody Customer customer){
//      customerRepo.save(customer);
//      return customer;
//  }
//
//  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.GET)
//    public Customer getCustomerById(@PathVariable(name= "customerId") Integer id){
//
//      return customerRepo.getOne(id);
//  }
//
//  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.PUT)
//    public void updateCustomer(@RequestBody Customer aCustomer, @PathVariable(name = "customerId") int id){
//      customerRepo.save(aCustomer);
//  }
//
//  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.DELETE)
//    public void deleteCustomer(@PathVariable(name = "customerId") Integer id){
//      customerRepo.deleteById(id);
//  }
//
//  @RequestMapping(value="/customers", method = RequestMethod.GET)
//    public List<Customer> getAllCustomers(){
//      return customerRepo.findAll();
//  }
//}
