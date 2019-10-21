package com.company.AnnaNicholsU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel {

    @NotNull
    @Size(max = 11)
    private Integer id;
    @NotEmpty
    @Size(max = 50)
    private String size;
    @NotEmpty
    @Size(max = 50)
    private String color;
    @NotEmpty
    @Size(max = 255)
    private String description;
    @NotEmpty
    @DecimalMax("99999.99")
    private BigDecimal price;
    @NotNull
    @Size(max = 11)
    private BigDecimal quantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(size, that.size) &&
                Objects.equals(color, that.color) &&
                Objects.equals(description, that.description) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }
}
