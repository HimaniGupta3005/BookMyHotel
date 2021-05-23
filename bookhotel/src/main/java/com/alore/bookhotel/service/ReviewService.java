package com.alore.bookhotel.service;

import java.util.List;

import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.dto.reviewdto.AddReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewResponse;
import com.alore.bookhotel.dto.reviewdto.ReviewResponse;
import com.alore.bookhotel.dto.reviewdto.UpdateReviewRequest;

public interface ReviewService {

    public ReviewResponse addReview(AddReviewRequest addReviewRequestd);

    public DeleteReviewResponse deleteReview(DeleteReviewRequest deleteReviewRequest);

    public ReviewResponse updateReview(UpdateReviewRequest updateReviewRequest);

    public List<Review> getReviews(int id);

}
