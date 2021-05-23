package com.alore.bookhotel.dto.reviewdto;

public class DeleteReviewResponse {

    private String message;

    public DeleteReviewResponse() {

    }

    public DeleteReviewResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
