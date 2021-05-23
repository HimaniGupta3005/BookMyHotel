package com.alore.bookhotel.dto.hoteldto;

import java.util.List;

import com.alore.bookhotel.dao.Hotel;

public class SearchHotelResponse {

    private List<Hotel> hotel;

    public SearchHotelResponse() {
    }

    public SearchHotelResponse(List<Hotel> hotel) {
        this.hotel = hotel;
    }

    public List<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(List<Hotel> hotel) {
        this.hotel = hotel;
    }

}
