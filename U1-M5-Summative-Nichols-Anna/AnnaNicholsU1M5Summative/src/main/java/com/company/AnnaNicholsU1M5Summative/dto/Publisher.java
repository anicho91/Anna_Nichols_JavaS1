package com.company.AnnaNicholsU1M5Summative.dto;

import java.util.Objects;

public class Publisher {
    private int id;
    private String name;
    private String street;
    private String city;
    private char state;
    private String postalCode;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return id == publisher.id &&
                state == publisher.state &&
                Objects.equals(name, publisher.name) &&
                Objects.equals(street, publisher.street) &&
                Objects.equals(city, publisher.city) &&
                Objects.equals(postalCode, publisher.postalCode) &&
                Objects.equals(phone, publisher.phone) &&
                Objects.equals(email, publisher.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, postalCode, phone, email);
    }
}
