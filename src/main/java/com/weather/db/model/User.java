package com.weather.db.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class User {

    public static Map<String, Country> countries=new HashMap<>();
    public static Map<String, City> cities=new HashMap<>();
//хранить в базе
    public long id;
    public String name; // имя
    public String email;
    public String country;
    public String city;

    public LocalDateTime dateOfLastUpdate;
    public LocalDateTime dateOfCreation;
    public Boolean isDeleted;

    public User(String name, String email, String country, String city) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, String country, String city, LocalDateTime dateOfCreation) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.dateOfCreation = dateOfCreation;
    }

    public User(long id, String name, String email, String country, String city, LocalDateTime dateOfLastUpdate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public User(long id, String name, String email, String country, String city, LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, Boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public User(String name, String email, String country, String city, LocalDateTime dateOfLastUpdate, LocalDateTime dateOfCreation, Boolean isDeleted) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.dateOfLastUpdate = dateOfLastUpdate;
        this.dateOfCreation = dateOfCreation;
        this.isDeleted = isDeleted;
    }

    public User(long id, String name,  String email, String country, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDateTime getDateOfLastUpdate() {
        return dateOfLastUpdate;
    }

    public void setDateOfLastUpdate(LocalDateTime dateOfLastUpdate) {
        this.dateOfLastUpdate = dateOfLastUpdate;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public static Map<String, Country> getCountries() {
        return countries;
    }

    public static void setCountries(Map<String, Country> countries) {
        User.countries = countries;
    }

    public static Map<String, City> getCities() {
        return cities;
    }

    public static void setCities(Map<String, City> cities) {
        User.cities = cities;
    }
}

