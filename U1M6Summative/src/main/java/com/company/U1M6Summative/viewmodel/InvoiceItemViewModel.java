package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.dto.Item;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {
    private Integer id;
    private Integer invoiceId;
    private Item item;
    private Integer quantity;
    private BigDecimal unitRate;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
        InvoiceItemViewModel that = (InvoiceItemViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(invoiceId, that.invoiceId) &&
                Objects.equals(item, that.item) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(unitRate, that.unitRate) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceId, item, quantity, unitRate, discount);
    }
}
