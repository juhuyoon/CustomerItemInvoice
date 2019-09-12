//package com.company.U1M6Summative.controller;
//
//import com.company.U1M6Summative.dto.Customer;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//public class CustomerController {
//
//    private List<Customer> customersList = new ArrayList<>();
//
//    @RequestMapping(value = "/customer", method = RequestMethod.POST)
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public Customer postCustomer(@RequestBody @Valid Customer customer) {
//        customersList.add(customer);
//
//        return customer;
//    }
//
//    @RequestMapping(value = "/customer", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public List<Customer> getCustomers() {
//
//        return customersList;
//    }
//
//    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
//    @ResponseStatus(value = HttpStatus.OK)
//    public Customer getOneCustomer(@PathVariable int customerId) {
//        for (Customer customer : customersList) {
//            if (customer.getId().equals(customerId)) {
//                return customer;
//            }
//        }
//
//        throw new IllegalArgumentException("Customer not found");
//    }
//
//    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.DELETE)
//    @ResponseStatus(value = HttpStatus.OK)
//    public void deleteCustomer(@PathVariable int customerId) {
//
//        customersList.remove(customerId);
//    }
//
////    @RequestMapping(value = "/customer/{customerId}", method = RequestMethod.PUT)
////    @ResponseStatus(value = HttpStatus.OK)
////    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
////
////    }
//}
