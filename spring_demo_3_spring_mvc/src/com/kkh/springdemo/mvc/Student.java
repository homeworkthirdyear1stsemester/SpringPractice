package com.kkh.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;
    private String[] operatingSystem;

    private LinkedHashMap<String, String> countryOptions;

    public Student() {

        // populate country options : used ISO country code
        this.countryOptions = new LinkedHashMap<>();

        countryOptions.put("ROK", "Republic of Korea");
        countryOptions.put("BR", "Brazil");
        countryOptions.put("DE", "Germany");
        countryOptions.put("FR", "France");
        countryOptions.put("US", "United States of America");
    }

    public String[] getOperatingSystem() {
        return this.operatingSystem;
    }

    public void setOperatingSystem(String[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String getFavoriteLanguage() {
        return this.favoriteLanguage;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }
}
