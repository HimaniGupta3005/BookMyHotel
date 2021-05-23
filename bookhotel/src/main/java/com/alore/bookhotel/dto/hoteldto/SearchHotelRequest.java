package com.alore.bookhotel.dto.hoteldto;

import java.time.LocalDate;
import java.util.List;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Rating;

public class SearchHotelRequest {

    private String city;
    private LocalDate date;
    private int roomRequired;
    private Rating rating;
    private List<Facility> facilities;

    public SearchHotelRequest() {
    }

    public SearchHotelRequest(String city, LocalDate date, int roomRequired, Rating rating, List<Facility> facilities) {
        this.city = city;
        this.date = date;
        this.roomRequired = roomRequired;
        this.rating = rating;
        this.facilities = facilities;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getRoomRequired() {
        return roomRequired;
    }

    public void setRoomRequired(int roomRequired) {
        this.roomRequired = roomRequired;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

}
