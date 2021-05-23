package com.alore.bookhotel.dto.reviewdto;

public class DeleteReviewRequest {

    private int reviewId;

    public DeleteReviewRequest() {
    }

    public DeleteReviewRequest(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }
}
