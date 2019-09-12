package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.dto.Item;

import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {
    private int id;
    private int invoiceId;
    private Item item;
    private int quantity;
    private BigDecimal unitRate;
    private BigDecimal discount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
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
        return id == that.id &&
                invoiceId == that.invoiceId &&
                quantity == that.quantity &&
                Objects.equals(item, that.item) &&
                Objects.equals(unitRate, that.unitRate) &&
                Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invoiceId, item, quantity, unitRate, discount);
    }
}
