package com.company.U1M6Summative.dto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="customer_id", nullable=false, length=11, unique=true)
    private Integer customerId;
    @Column(name="first_name", nullable=false, length=50)
    private String firstName;
    @Column(name="last_name", nullable=false, length=50)
    private String lastName;
    @Column(name="email", nullable=false, length=75)
    private String email;
    @Column(name="company", nullable=false, length=50)
    private String company;
    @Column(name="phone", nullable=false, length=50)
    private String phone;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId.equals(customer.customerId) &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                email.equals(customer.email) &&
                company.equals(customer.company) &&
                phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, email, company, phone);
    }
}
