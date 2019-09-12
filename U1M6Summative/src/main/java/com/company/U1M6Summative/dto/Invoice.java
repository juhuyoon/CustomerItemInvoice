package com.company.U1M6Summative.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="invoice")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "invoice_id", nullable = false, length = 11, unique = true)
    private Integer id;
    @Column(name = "customer_id", nullable = false, length = 11)
    private Integer customerId;
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;
    @Column(name = "pickup_date", nullable = false)
    private LocalDate pickupDate;
    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;
    @Column(name = "late_fee", nullable = false, columnDefinition = "Decimal(8,2)")
    private BigDecimal lateFee;



    @OneToMany(mappedBy = "invoiceId",  cascade =  CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<InvoiceItem> invoiceItems;

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(LocalDate pickupDate) {
        this.pickupDate = pickupDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return id.equals(invoice.id) &&
                customerId.equals(invoice.customerId) &&
                orderDate.equals(invoice.orderDate) &&
                pickupDate.equals(invoice.pickupDate) &&
                returnDate.equals(invoice.returnDate) &&
                lateFee.equals(invoice.lateFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderDate, pickupDate, returnDate, lateFee);
    }
}
