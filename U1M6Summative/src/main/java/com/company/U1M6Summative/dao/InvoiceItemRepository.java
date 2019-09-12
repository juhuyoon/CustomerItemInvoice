package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.InvoiceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Integer> {}
