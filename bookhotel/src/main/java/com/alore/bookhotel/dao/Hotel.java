package com.alore.bookhotel.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

public class Hotel {

    @NonNull
    @JsonProperty("name")
    private String name;
    @NonNull
    @JsonProperty("city")
    private String city;
    @NonNull
    @JsonProperty("totalRoom")
    private int totalRoom;
    @NonNull
    @JsonProperty("costOfRoom")
    private int costOfRoom;
    @NonNull
    @JsonProperty("facility")
    private ArrayList<Facility> facility;
    private Rating overAllRating;

    public Hotel(@NonNull String name, @NonNull String city, @NonNull int totalRoom, @NonNull int costOfRoom,
            @NonNull ArrayList<Facility> facility) {
        this.name = name;
        this.city = city;
        this.totalRoom = totalRoom;
        this.costOfRoom = costOfRoom;
        this.facility = facility;
    }

    public Rating getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(Rating overAllRating) {
        this.overAllRating = overAllRating;
    }

    public Hotel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTotalRoom() {
        return totalRoom;
    }

    public void setTotalRoom(int totalRoom) {
        this.totalRoom = totalRoom;
    }

    public int getCostOfRoom() {
        return costOfRoom;
    }

    public void setCostOfRoom(int costOfRoom) {
        this.costOfRoom = costOfRoom;
    }

    public ArrayList<Facility> getFacility() {
        return facility;
    }

    public void setFacility(ArrayList<Facility> facility) {
        this.facility = facility;
    }

}