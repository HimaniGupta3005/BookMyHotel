package com.alore.bookhotel.dto.hoteldto;

import java.util.List;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dao.Review;

public class GetHotelResponse {

    private int hotelId;
    private String name;
    private String city;
    private int availableRoom;
    private int costOfRoom;
    private List<Facility> facility;
    private List<Review> reviews;
    private Rating overallRating;

    public GetHotelResponse() {
    }

    public GetHotelResponse(int hotelId, String name, String city, int availableRoom, int costOfRoom,
            List<Facility> facility, List<Review> reviews, Rating overallRating) {
        this.hotelId = hotelId;
        this.name = name;
        this.city = city;
        this.availableRoom = availableRoom;
        this.costOfRoom = costOfRoom;
        this.facility = facility;
        this.reviews = reviews;
        this.overallRating = overallRating;
    }

    public Rating getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Rating overallRating) {
        this.overallRating = overallRating;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

    public int getAvailableRoom() {
        return availableRoom;
    }

    public void setAvailableRoom(int availableRoom) {
        this.availableRoom = availableRoom;
    }

    public int getCostOfRoom() {
        return costOfRoom;
    }

    public void setCostOfRoom(int costOfRoom) {
        this.costOfRoom = costOfRoom;
    }

    public List<Facility> getFacility() {
        return facility;
    }

    public void setFacility(List<Facility> facility) {
        this.facility = facility;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
