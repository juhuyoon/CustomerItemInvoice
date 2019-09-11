package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer addCustomer(Customer customer);

    Customer getCustomer(int id);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);

}
