package com.company.AnnaNicholsCoffeeInventoryJpaRepository.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="roaster")
public class Roaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String email;
    private String note;

    @OneToMany(mappedBy = "roasterId",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Coffee> coffee;

    public Set<Coffee> getCoffee() {
        return coffee;
    }

    public void setCoffee(Set<Coffee> coffee) {
        this.coffee = coffee;
    }

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return id == roaster.id &&
                Objects.equals(name, roaster.name) &&
                Objects.equals(street, roaster.street) &&
                Objects.equals(city, roaster.city) &&
                Objects.equals(state, roaster.state) &&
                Objects.equals(zipCode, roaster.zipCode) &&
                Objects.equals(phone, roaster.phone) &&
                Objects.equals(email, roaster.email) &&
                Objects.equals(note, roaster.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, city, state, zipCode, phone, email, note);
    }
}
