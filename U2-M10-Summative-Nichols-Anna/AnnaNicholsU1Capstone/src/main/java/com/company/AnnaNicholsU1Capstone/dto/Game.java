package com.company.AnnaNicholsU1Capstone.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Game {

    private int id;
    private String title;
    private String esrbRating;
    private String description;
    private BigDecimal price;
    private String studio;
    private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEsrbRating() {
        return esrbRating;
    }

    public void setEsrbRating(String esrbRating) {
        this.esrbRating = esrbRating;
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

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
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
        Game game = (Game) o;
        return id == game.id &&
                price.equals(game.price) &&
                quantity.equals(game.quantity) &&
                Objects.equals(title, game.title) &&
                Objects.equals(esrbRating, game.esrbRating) &&
                Objects.equals(description, game.description) &&
                Objects.equals(studio, game.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, esrbRating, description, price, studio, quantity);
    }
}
