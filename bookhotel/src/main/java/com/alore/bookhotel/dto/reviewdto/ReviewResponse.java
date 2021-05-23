package com.alore.bookhotel.dto.reviewdto;

import com.alore.bookhotel.dao.Rating;

public class ReviewResponse {

    private int reviewId;
    private int userId;
    private int hotelId;
    private String comment;
    private Rating rating;

    public ReviewResponse(int reviewId, int userId, int hotelId, String comment, Rating rating) {
        this.reviewId = reviewId;
        this.userId = userId;
        this.hotelId = hotelId;
        this.comment = comment;
        this.rating = rating;
    }

    public ReviewResponse() {

    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
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
