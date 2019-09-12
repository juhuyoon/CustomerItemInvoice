package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceRepositoryTest {

    @Autowired
    InvoiceRepository invoiceRepo;
    @Autowired
    InvoiceItemRepository invoiceItemRepo;
    @Autowired
    CustomerRepository customerRepo;
    @Autowired
    ItemRepository itemRepo;

    @Test
    public void findByCustomer() {

        invoiceRepo.deleteAll();
        customerRepo.deleteAll();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("email@email.com");
        customer.setCompany("CorpCo");
        customer.setPhone("7065555555");
        customerRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Poe");
        customer2.setEmail("email@email.com");
        customer2.setCompany("BigCo");
        customer2.setPhone("7064348555");
        customerRepo.save(customer2);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer2.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,5,20));
        invoice.setPickupDate(LocalDate.of(2019,5, 22));
        invoice.setReturnDate(LocalDate.of(2019, 5,25));
        invoice.setLateFee(new BigDecimal(4.00));
        Set<Invoice> invoiceSet =  new HashSet<>();
        invoiceSet.add(invoice);

        Invoice invoice2 = new Invoice();
        invoice2.setCustomerId(customer2.getCustomerId());
        invoice2.setOrderDate(LocalDate.of(2019,8,10));
        invoice2.setPickupDate(LocalDate.of(2019,8, 15));
        invoice2.setReturnDate(LocalDate.of(2019, 8,20));
        invoice2.setLateFee(new BigDecimal(5.00));
        invoiceSet.add(invoice2);

        invoiceRepo.save(invoice);
        invoiceRepo.save(invoice2);

        List<Invoice> invoiceList = invoiceRepo.findInvoicesByCustomerId(customer2.getCustomerId());
        List<Invoice> invoiceList2 = invoiceRepo.findInvoicesByCustomerId(customer.getCustomerId());

        assertEquals(2, invoiceList.size());
        assertEquals(0, invoiceList2.size());
    }

    @Test
    public void addInvoice(){

        invoiceRepo.deleteAll();
        customerRepo.deleteAll();
        invoiceItemRepo.deleteAll();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("email@email.com");
        customer.setCompany("CorpCo");
        customer.setPhone("7065555555");
        customerRepo.save(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,05,20));
        invoice.setPickupDate(LocalDate.of(2019,05, 22));
        invoice.setReturnDate(LocalDate.of(2019, 05,25));
        invoice.setLateFee(new BigDecimal(4.00));
        invoiceRepo.save(invoice);

        List<Invoice> invoiceList = invoiceRepo.findAll();
        assertEquals(1,invoiceList.size());

    }

    @Test
//    @Transactional
    public void deleteInvoice(){

        invoiceRepo.deleteAll();
        customerRepo.deleteAll();
        invoiceItemRepo.deleteAll();
        itemRepo.deleteAll();

        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("email@email.com");
        customer.setCompany("CorpCo");
        customer.setPhone("7065555555");
        customerRepo.save(customer);

        Item item = new Item();
        item.setName("movie1");
        item.setDescription("Action Movie");
        item.setDailyRate(new BigDecimal("5.00"));
        itemRepo.save(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,05,20));
        invoice.setPickupDate(LocalDate.of(2019,05, 22));
        invoice.setReturnDate(LocalDate.of(2019, 05,25));
        invoice.setLateFee(new BigDecimal(4.00));
        invoiceRepo.save(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setItemId(item.getId());
        invoiceItem.setQuantity(20);
        invoiceItem.setUnitRate(new BigDecimal("4.00"));
        invoiceItem.setDiscount(new BigDecimal("1.00"));
        invoiceItemRepo.save(invoiceItem);

        invoiceRepo.deleteById(invoice.getId());

        List<Invoice> invoiceList = invoiceRepo.findAll();
        List<InvoiceItem> invoiceItems = invoiceItemRepo.findAll();
        List<Item> items = itemRepo.findAll();
        List<Customer> customers = customerRepo.findAll();

        assertEquals(0, invoiceList.size());
        assertEquals(0, invoiceItems.size());
        assertNotEquals(0, items.size());
        assertNotEquals(0, customers.size());

    }
}