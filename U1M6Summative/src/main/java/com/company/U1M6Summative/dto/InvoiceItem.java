package com.company.U1M6Summative.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="InvoiceItem")
public class InvoiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="invoice_item_id", nullable=false, length=11, unique=true)
    private Integer id;
    @Column(name="invoice_id", nullable=false, length=11)
    private Integer invoiceId;
    @Column(name="item_id", nullable=false, length=11)
    private Integer itemId;
    @Column(name="quantity", nullable=false, length=11)
    private Integer quantity;
    @Column(name="unit_rate", nullable=false, columnDefinition = "Decimal(8,2)")
    private BigDecimal unitRate;
    @Column(name="discount", nullable=false, columnDefinition = "Decimal(8,2)")
    private BigDecimal discount;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return id.equals(that.id) &&
                invoiceId.equals(that.invoiceId) &&
                itemId.equals(that.itemId) &&
                quantity.equals(that.quantity) &&
                unitRate.equals(that.unitRate) &&
                discount.equals(that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceId, itemId, quantity, unitRate, discount);
    }
}
