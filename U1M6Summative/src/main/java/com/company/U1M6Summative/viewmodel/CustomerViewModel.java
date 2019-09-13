package com.company.U1M6Summative.viewmodel;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CustomerViewModel {

    @NotNull
    @Size(max = 11)
    private Integer customerId;
    @NotEmpty
    @Size(max = 50)
    private String firstName;
    @NotEmpty
    @Size(max = 50)
    private String lastName;
    @NotEmpty
    @Size(max = 75)
    private String email;
    @NotEmpty
    @Size(max = 50)
    private String company;
    @NotEmpty
    @Size(max = 50)
    private String phone;
    @NotEmpty
    private List<InvoiceViewModel> invoiceViewModelsList = new ArrayList<>();

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<InvoiceViewModel> getInvoiceViewModelsList() {
        return invoiceViewModelsList;
    }

    public void setInvoiceViewModelsList(List<InvoiceViewModel> invoiceViewModelsList) {
        this.invoiceViewModelsList = invoiceViewModelsList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerViewModel that = (CustomerViewModel) o;
        return customerId.equals(that.customerId) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName) &&
                email.equals(that.email) &&
                company.equals(that.company) &&
                phone.equals(that.phone) &&
                invoiceViewModelsList.equals(that.invoiceViewModelsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, email, company, phone, invoiceViewModelsList);
    }
}
