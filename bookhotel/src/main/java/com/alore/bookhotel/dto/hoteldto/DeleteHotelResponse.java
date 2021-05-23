package com.alore.bookhotel.dto.hoteldto;

public class DeleteHotelResponse {

    private String message;

    public DeleteHotelResponse(String message) {
        this.message = message;
    }

    public DeleteHotelResponse() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
