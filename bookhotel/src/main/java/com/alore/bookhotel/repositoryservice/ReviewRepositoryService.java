package com.alore.bookhotel.repositoryservice;

import java.util.List;

import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.entity.ReviewEntity;

public interface ReviewRepositoryService {

    public ReviewEntity addReview(Review review);

    public void deleteReview(int reviewId);

    public ReviewEntity updateReview(Review review, int reviewId);

    public List<ReviewEntity> getReview(int id);

}
