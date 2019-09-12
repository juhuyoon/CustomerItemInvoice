package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {

//    List<Invoice> findByCustomer(Integer customerId);

}
