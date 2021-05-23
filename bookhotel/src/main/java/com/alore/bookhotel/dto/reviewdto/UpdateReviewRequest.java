package com.alore.bookhotel.dto.reviewdto;

import com.alore.bookhotel.dao.Review;

public class UpdateReviewRequest {

    private Review review;
    private int reviewId;

    public UpdateReviewRequest() {

    }

    public UpdateReviewRequest(Review review, int reviewId) {
        this.review = review;
        this.reviewId = reviewId;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

}
