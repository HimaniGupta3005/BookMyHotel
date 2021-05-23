package com.alore.bookhotel.dto.hoteldto;

import com.alore.bookhotel.dao.Hotel;

public class UpdateHotelRequest {

    private int hotelId;
    private Hotel hotel;

    public UpdateHotelRequest() {
    }

    public UpdateHotelRequest(int hotelId, Hotel hotel) {
        this.hotelId = hotelId;
        this.hotel = hotel;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
