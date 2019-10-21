package com.company.AnnaNicholsU1Capstone.viewmodel;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel {

    @NotNull
    @Size(max = 11)
    private Integer id;
    @NotEmpty
    @Size(max = 50)
    private String model;
    @NotEmpty
    @Size(max = 50)
    private String manufacturer;
    @NotEmpty
    @Size(max = 20)
    private String memoryAmount;
    @NotEmpty
    @Size(max = 20)
    private String processor;
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
        ConsoleViewModel that = (ConsoleViewModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(model, that.model) &&
                Objects.equals(manufacturer, that.manufacturer) &&
                Objects.equals(memoryAmount, that.memoryAmount) &&
                Objects.equals(processor, that.processor) &&
                Objects.equals(price, that.price) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
