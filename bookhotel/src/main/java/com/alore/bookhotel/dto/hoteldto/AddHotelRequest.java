package com.alore.bookhotel.dto.hoteldto;

import com.alore.bookhotel.dao.Hotel;

public class AddHotelRequest {

    private Hotel hotel;

    public AddHotelRequest() {
    }

    public AddHotelRequest(Hotel hotel) {
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
