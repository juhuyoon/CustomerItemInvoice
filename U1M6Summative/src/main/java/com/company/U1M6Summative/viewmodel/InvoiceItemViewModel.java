package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.dto.Item;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItemViewModel {
    @NotNull
    @Size(max = 11)
    private int id;
    @NotNull
    @Size(max = 11)
    private int invoiceId;
    @NotEmpty
    private Item item;
    @NotNull
    @Size(max = 11)
    private int quantity;
    @NotNull
    @Digits(integer=8, fraction=2)
    private BigDecimal unitRate;
    @NotNull
    @Digits(integer=8, fraction=2)
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
