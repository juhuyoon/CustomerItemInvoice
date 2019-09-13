package com.company.U1M6Summative.viewmodel;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ItemViewModel {

    @NotNull
    @Size(max = 11)
    private int item_id;

    @NotEmpty
    @Size(max = 50)
    private String name;

    @NotEmpty
    @Size(max = 255)
    private String description;

    @NotEmpty
    @Digits(integer = 8, fraction = 2)
    private BigDecimal daily_rate;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
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

    public BigDecimal getDaily_rate() {
        return daily_rate;
    }

    public void setDaily_rate(BigDecimal daily_rate) {
        this.daily_rate = daily_rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemViewModel that = (ItemViewModel) o;
        return item_id == that.item_id &&
                name.equals(that.name) &&
                description.equals(that.description) &&
                daily_rate.equals(that.daily_rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item_id, name, description, daily_rate);
    }
}
