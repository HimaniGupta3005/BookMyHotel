package com.alore.bookhotel.dto.hoteldto;

public class DeleteHotelRequest {

    private int hotelId;

    public DeleteHotelRequest() {

    }

    public DeleteHotelRequest(int hotelId) {
        this.hotelId = hotelId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

}
