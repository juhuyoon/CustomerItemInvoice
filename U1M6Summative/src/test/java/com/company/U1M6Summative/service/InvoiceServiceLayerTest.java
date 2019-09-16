package com.company.U1M6Summative.service;
//
//import com.company.U1M6Summative.dao.CustomerRepository;
//import com.company.U1M6Summative.dao.InvoiceRepository;
//import com.company.U1M6Summative.dto.Customer;
//import com.company.U1M6Summative.dto.Invoice;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//
//public class InvoiceServiceLayerTest {
//
//    InvoiceServiceLayer invoiceService;
//    InvoiceRepository invoiceRepository;
//
//    @Before
//    public void setUp() throws Exception {
//        setUpInvoiceRepositoryMock();
//        invoiceService = new InvoiceServiceLayer(InvoiceRepository);
//    }
//
//    @Test
//    public void saveFindAllInvoice() {
//        Invoice invoice = new Invoice();
//        invoice.setCustomerId(invoice.getCustomerId());
//        invoice.setOrderDate(LocalDate.of(2019,5,20));
//        invoice.setPickupDate(LocalDate.of(2019,5, 22));
//        invoice.setReturnDate(LocalDate.of(2019, 5,25));
//        invoice.setLateFee(new BigDecimal(4.00));
//
//        invoice = invoiceService.saveInvoice(invoice);
//        Invoice fromInvoiceService = invoiceService.findInvoice(invoice.getId());
//
//        assertEquals(invoice, fromInvoiceService);
//        List<Invoice> inList = invoiceService.findAllInvoice();
//        assertEquals(1, inList.size());
//        assertEquals(invoice, inList.get(0));
//    }
//
//    // Helper methods
//    private void setUpInvoiceRepositoryMock() {
//        invoiceRepository = mock(InvoiceRepository);
//        Invoice invoice = new Invoice();
//
//        invoice.setCustomerId(invoice.getCustomerId());
//        invoice.setOrderDate(LocalDate.of(2019,5,20));
//        invoice.setPickupDate(LocalDate.of(2019,5, 22));
//        invoice.setReturnDate(LocalDate.of(2019, 5,25));
//        invoice.setLateFee(new BigDecimal(4.00));
//
//        Invoice invoice2 = new Invoice();
//        invoice2.setOrderDate(LocalDate.of(2019,5,20));
//        invoice2.setPickupDate(LocalDate.of(2019,5, 22));
//        invoice2.setReturnDate(LocalDate.of(2019, 5,25));
//        invoice2.setLateFee(new BigDecimal(4.00));
//
//        List<Invoice> invoiceList = new ArrayList<>();
//        invoiceList.add( invoice);
//
//        doReturn(invoice).when(invoiceRepository).addInvoice(invoice2);
//        doReturn(invoice).when(invoiceRepository).getInvoice(1);
//        doReturn(invoiceList).when(invoiceRepository).getAllInvoice();
//    }
//}
