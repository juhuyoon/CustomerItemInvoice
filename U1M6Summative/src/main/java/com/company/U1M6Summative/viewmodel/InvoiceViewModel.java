package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.dto.InvoiceItem;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {

    @NotNull
    @Size(max = 11)
    private int id;
    @NotNull
    @Size(max = 11)
    private int customerId;
    @NotNull

    private LocalDate orderDate;

    private LocalDate pickupDate;

    private LocalDate returnDate;

    @NotNull
    @Digits(integer = 8, fraction = 2)
    private BigDecimal lateFee;

    @NotEmpty
    private List<InvoiceItemViewModel> invoiceItemViewModelList = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
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

    public List<InvoiceItemViewModel> getInvoiceItemViewModelList() {
        return invoiceItemViewModelList;
    }

    public void setInvoiceItemViewModelList(List<InvoiceItemViewModel> invoiceItemViewModelList) {
        this.invoiceItemViewModelList = invoiceItemViewModelList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return id == that.id &&
                customerId == that.customerId &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(pickupDate, that.pickupDate) &&
                Objects.equals(returnDate, that.returnDate) &&
                Objects.equals(lateFee, that.lateFee) &&
                Objects.equals(invoiceItemViewModelList, that.invoiceItemViewModelList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderDate, pickupDate, returnDate, lateFee, invoiceItemViewModelList);
    }
}
