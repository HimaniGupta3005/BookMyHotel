package com.alore.bookhotel.service;

import java.util.ArrayList;
import java.util.List;

import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.dto.reviewdto.AddReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewResponse;
import com.alore.bookhotel.dto.reviewdto.ReviewResponse;
import com.alore.bookhotel.dto.reviewdto.UpdateReviewRequest;
import com.alore.bookhotel.entity.ReviewEntity;
import com.alore.bookhotel.repositoryservice.ReviewRepositoryService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service

public class ReviewServiceImpl implements ReviewService {

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;
    @Autowired
    private ReviewRepositoryService reviewRepositoryService;

    @Override
    public ReviewResponse addReview(AddReviewRequest addReviewRequest) {

        Review review = addReviewRequest.getReview();
        if (review == null)
            return null;
        ReviewEntity reviewEntity = reviewRepositoryService.addReview(review);
        if (reviewEntity == null)
            return null;

        ReviewResponse result = new ReviewResponse(reviewEntity.getId(), reviewEntity.getUserId(),
                reviewEntity.getHotelId(), reviewEntity.getComment(), reviewEntity.getRating());
        return result;

    }

    @Override
    public DeleteReviewResponse deleteReview(DeleteReviewRequest deleteReviewRequest) {

        if (deleteReviewRequest == null)
            return null;

        reviewRepositoryService.deleteReview(deleteReviewRequest.getReviewId());
        DeleteReviewResponse response = new DeleteReviewResponse("Successfully deteled!!");
        return response;
    }

    @Override
    public ReviewResponse updateReview(UpdateReviewRequest updateReviewRequest) {

        if (updateReviewRequest == null)
            return null;

        ReviewEntity reviewEntity = reviewRepositoryService.updateReview(updateReviewRequest.getComment(),
                updateReviewRequest.getRating(), updateReviewRequest.getReviewId());

        ReviewResponse result = new ReviewResponse(reviewEntity.getId(), reviewEntity.getUserId(),
                reviewEntity.getHotelId(), reviewEntity.getComment(), reviewEntity.getRating());
        return result;
    }

    @Override
    public List<Review> getReviews(int id) {

        List<Review> reviews = new ArrayList();
        List<ReviewEntity> reviewEntities = reviewRepositoryService.getReview(id);

        if (reviewEntities != null) {
            for (ReviewEntity e : reviewEntities) {
                Review r = modelMapper.map(e, Review.class);
                reviews.add(r);
            }

        }

        return reviews;
    }

}
