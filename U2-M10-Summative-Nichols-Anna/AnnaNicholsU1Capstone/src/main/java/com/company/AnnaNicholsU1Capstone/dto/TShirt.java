package com.company.AnnaNicholsU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirt {

    private int id;
    private String size;
    private String color;
    private String description;
    private BigDecimal price;
    private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        TShirt tShirt = (TShirt) o;
        return id == tShirt.id &&
                price.equals(tShirt.price) &&
                quantity.equals(tShirt.quantity) &&
                Objects.equals(size, tShirt.size) &&
                Objects.equals(color, tShirt.color) &&
                Objects.equals(description, tShirt.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, size, color, description, price, quantity);
    }
}
