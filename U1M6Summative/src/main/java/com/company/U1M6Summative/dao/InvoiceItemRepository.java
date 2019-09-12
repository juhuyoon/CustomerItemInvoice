package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {
    List<InvoiceItem> findByInvoiceId(Integer id);
}
