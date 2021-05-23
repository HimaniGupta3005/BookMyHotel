package com.alore.bookhotel.dto.hoteldto;

import java.util.List;

import com.alore.bookhotel.dao.Facility;
import com.alore.bookhotel.dao.Rating;

public class HotelResponse {

    private int hotelId;
    private String name;
    private String city;
    private int availableRoom;
    private int costOfRoom;
    private List<Facility> facility;
    private Rating overAllRating;

    public HotelResponse() {
    }

    public HotelResponse(int hotelId, String name, String city, int availableRoom, int costOfRoom,
            List<Facility> facility, Rating overAllRating) {
        this.hotelId = hotelId;
        this.name = name;
        this.city = city;
        this.availableRoom = availableRoom;
        this.costOfRoom = costOfRoom;
        this.facility = facility;
        this.overAllRating = overAllRating;
    }

    public Rating getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(Rating overAllRating) {
        this.overAllRating = overAllRating;
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

}
