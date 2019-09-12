package com.company.U1M6Summative.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="item_id", nullable=false, length=11, unique=true)
    private Integer id;
    @Column(name="name", nullable=false, length=50)
    private String name;
    @Column(name="description", nullable=false, length=255)
    private String description;
    @Column(name="daily_rate", nullable=false, columnDefinition = "Decimal(8,2)")
    private BigDecimal dailyRate;

    @OneToMany(mappedBy = "itemId",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<InvoiceItem> invoiceItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(BigDecimal dailyRate) {
        this.dailyRate = dailyRate;
    }

    public Set<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(Set<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id.equals(item.id) &&
                name.equals(item.name) &&
                Objects.equals(description, item.description) &&
                dailyRate.equals(item.dailyRate) &&
                Objects.equals(invoiceItems, item.invoiceItems);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dailyRate, invoiceItems);
    }
}
