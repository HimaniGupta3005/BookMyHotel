package com.alore.bookhotel.dao;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.NonNull;

public class User {

    @NonNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @JsonProperty("gender")
    private Gender gender;

    public User() {
    }

    public User(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
