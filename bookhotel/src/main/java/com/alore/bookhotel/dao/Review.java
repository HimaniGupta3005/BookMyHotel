package com.alore.bookhotel.dao;

import lombok.Data;

public class Review {

    private int userId;
    private int hotelId;
    private String comment;
    private Rating rating;

    public Review() {
    }

    public Review(int userId, int hotelId, String comment, Rating rating) {
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

}
