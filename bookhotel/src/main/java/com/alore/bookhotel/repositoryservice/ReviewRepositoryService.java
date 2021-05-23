package com.alore.bookhotel.repositoryservice;

import java.util.List;

import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.entity.ReviewEntity;

public interface ReviewRepositoryService {

    public ReviewEntity addReview(Review review);

    public void deleteReview(int reviewId);

    public ReviewEntity updateReview(String comment, Rating ratings, int reviewId);

    public List<ReviewEntity> getReview(int id);

}
