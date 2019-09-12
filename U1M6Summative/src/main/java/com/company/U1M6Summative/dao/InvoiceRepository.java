package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

//    List<Invoice> findByCustomer(Integer customerId);

}
