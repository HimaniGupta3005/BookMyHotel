package com.alore.bookhotel.dto.reviewdto;

import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dao.Review;

public class UpdateReviewRequest {

    private int reviewId;
    private String comment;
    private Rating rating;

    public UpdateReviewRequest() {

    }

    public UpdateReviewRequest(int reviewId, String comment, Rating rating) {
        this.reviewId = reviewId;
        this.comment = comment;
        this.rating = rating;
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

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

}
