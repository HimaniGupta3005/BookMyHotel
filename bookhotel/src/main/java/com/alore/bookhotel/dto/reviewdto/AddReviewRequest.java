package com.alore.bookhotel.dto.reviewdto;

import com.alore.bookhotel.dao.Review;

import lombok.NonNull;

public class AddReviewRequest {

    @NonNull
    private Review review;

    public AddReviewRequest() {
    }

    public AddReviewRequest(Review review) {
        this.review = review;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

}
