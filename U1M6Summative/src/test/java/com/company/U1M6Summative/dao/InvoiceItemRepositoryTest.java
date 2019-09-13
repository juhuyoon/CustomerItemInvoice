package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.dto.Customer;
import com.company.U1M6Summative.dto.Invoice;
import com.company.U1M6Summative.dto.InvoiceItem;
import com.company.U1M6Summative.dto.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceItemRepositoryTest {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void contextLoads() {
        //Just to see the test runs.
    }

    @Before
    public void setUp() throws Exception {
        invoiceItemRepository.deleteAll();
        invoiceRepository.deleteAll();
        customerRepository.deleteAll();
        itemRepository.deleteAll();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveGetFindAllDeleteInvoiceItem() {
        Customer customer = new Customer();
        customer.setFirstName("Jung");
        customer.setLastName("Yoon");
        customer.setEmail("jung@yah.com");
        customer.setCompany("Cognizant");
        customer.setPhone("111-111-1111");

        customerRepository.save(customer);

        Item item = new Item();
        item.setName("Cheese");
        item.setDescription("It's sweet and delicious");
        item.setDailyRate(new BigDecimal(15.55));

        itemRepository.save(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,04,19));
        invoice.setPickupDate(LocalDate.of(2019, 05, 10));
        invoice.setReturnDate(LocalDate.of(2019, 06,10));
        invoice.setLateFee(new BigDecimal("15.50"));

        invoiceRepository.save(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setItemId(item.getId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitRate(new BigDecimal("10.00"));
        invoiceItem.setDiscount(new BigDecimal("5.00"));

        InvoiceItem invoiceItem1 = new InvoiceItem();
        invoiceItem1.setInvoiceId(invoice.getId());
        invoiceItem1.setItemId(item.getId());
        invoiceItem1.setQuantity(15);
        invoiceItem1.setUnitRate(new BigDecimal("15.00"));
        invoiceItem1.setDiscount(new BigDecimal("7.00"));

        invoiceItemRepository.save(invoiceItem);
        invoiceItemRepository.save(invoiceItem1);

        List<InvoiceItem> allInvoice = invoiceItemRepository.findAll();

        assertEquals(2, allInvoice.size());

        invoiceItemRepository.deleteAll();

        allInvoice = invoiceItemRepository.findAll();

        assertEquals(allInvoice.size(), 0);
    }

    @Test
    public void updateInvoiceItem() {
        Customer customer = new Customer();
        customer.setFirstName("Jung");
        customer.setLastName("Yoon");
        customer.setEmail("jung@yah.com");
        customer.setCompany("Cognizant");
        customer.setPhone("111-111-1111");

        customerRepository.save(customer);

        Item item = new Item();
        item.setName("Cheese");
        item.setDescription("It's sweet and delicious");
        item.setDailyRate(new BigDecimal(15.55));

        itemRepository.save(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,04,19));
        invoice.setPickupDate(LocalDate.of(2019, 05, 10));
        invoice.setReturnDate(LocalDate.of(2019, 06,10));
        invoice.setLateFee(new BigDecimal("15.50"));

        invoiceRepository.save(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setItemId(item.getId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitRate(new BigDecimal("10.00"));
        invoiceItem.setDiscount(new BigDecimal("5.00"));

        invoiceItemRepository.save(invoiceItem);

        invoiceItem.setQuantity(15);
        invoiceItem.setUnitRate(new BigDecimal("15.00"));
        invoiceItem.setDiscount(new BigDecimal("3.00"));

        InvoiceItem invoiceItem2 = invoiceItemRepository.getOne(invoiceItem.getId());

        assertEquals((int) invoiceItem2.getId(), (int) invoiceItem.getId());

    }
    @Test
    public void findByInvoiceId() {
        Customer customer = new Customer();
        customer.setFirstName("Jung");
        customer.setLastName("Yoon");
        customer.setEmail("jung@yah.com");
        customer.setCompany("Cognizant");
        customer.setPhone("111-111-1111");

        customerRepository.save(customer);

        Item item = new Item();
        item.setName("Cheese");
        item.setDescription("It's sweet and delicious");
        item.setDailyRate(new BigDecimal(15.55));

        itemRepository.save(item);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(LocalDate.of(2019,04,19));
        invoice.setPickupDate(LocalDate.of(2019, 05, 10));
        invoice.setReturnDate(LocalDate.of(2019, 06,10));
        invoice.setLateFee(new BigDecimal("15.50"));

        invoiceRepository.save(invoice);

        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setInvoiceId(invoice.getId());
        invoiceItem.setItemId(item.getId());
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitRate(new BigDecimal("10.00"));
        invoiceItem.setDiscount(new BigDecimal("5.00"));

        invoiceItemRepository.save(invoiceItem);

        List<InvoiceItem> invoiceItemList = invoiceItemRepository.findByInvoiceId(invoice.getId());

        assertEquals(invoiceItemList.size(), 1);
    }
}