package com.company.U1M6Summative.controller;
import com.company.U1M6Summative.service.CustomerServiceLayer;
import com.company.U1M6Summative.service.InvoiceServiceLayer;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

  @Autowired
  private CustomerServiceLayer customerService;
  @Autowired
  private InvoiceServiceLayer invoiceService;

  @RequestMapping(value="/customer", method = RequestMethod.POST)
    public CustomerViewModel createCustomer(@RequestBody CustomerViewModel customer){

      return customerService.addCustomerVM(customer);
  }

  @RequestMapping(value="/customer", method = RequestMethod.GET)
  public List<CustomerViewModel> getAllCustomers(){

    return customerService.getAllCustomersVM();
  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.GET)
    public CustomerViewModel getCustomerById(@PathVariable int customerId){
      return customerService.getCustomerVM(customerId);
  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.PUT)
    public void updateCustomer(@PathVariable int customerId, @RequestBody CustomerViewModel customer){

    customerService.updateCustomerVM(customer);

  }

  @RequestMapping(value="/customer/{customerId}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable int customerId){

      customerService.deleteCustomerVM(customerId);

  }


}

