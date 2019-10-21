package com.company.AnnaNicholsU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    private int id;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private BigDecimal price;
    private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
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
        Console console = (Console) o;
        return id == console.id &&
                price.equals(console.price) &&
                quantity.equals(console.quantity) &&
                Objects.equals(model, console.model) &&
                Objects.equals(manufacturer, console.manufacturer) &&
                Objects.equals(memoryAmount, console.memoryAmount) &&
                Objects.equals(processor, console.processor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
