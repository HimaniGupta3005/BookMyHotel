package com.alore.bookhotel.repositoryservice;

import java.util.List;
import java.util.Optional;

import com.alore.bookhotel.dao.Rating;
import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.entity.HotelEntity;
import com.alore.bookhotel.entity.ReviewEntity;
import com.alore.bookhotel.entity.UserEntity;
import com.alore.bookhotel.repository.HotelRepository;
import com.alore.bookhotel.repository.ReviewRepository;
import com.alore.bookhotel.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class ReviewRepositoryServiceImpl implements ReviewRepositoryService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private HotelRepository hotelRepo;

    @Autowired
    @Qualifier("modelMapper")
    private ModelMapper modelMapper;

    @Override
    public ReviewEntity addReview(Review review) {
        ReviewEntity reviewEntity = modelMapper.map(review, ReviewEntity.class);

        Optional<HotelEntity> optionalHotel = hotelRepo.findById(review.getHotelId());
        Optional<UserEntity> optionalUser = userRepo.findById(review.getUserId());

        if (optionalHotel.isPresent() && optionalUser.isPresent()) {
            HotelEntity hotelEntity = optionalHotel.get();
            int reviewCount = reviewRepo.countReviewPerHotel(hotelEntity.getId());
            int hotelRatting = hotelEntity.getOverallRating() != null ? hotelEntity.getOverallRating().ordinal() : 0;
            int rating = hotelRatting + 1;

            rating = rating * reviewCount + review.getRating().ordinal() + 1;
            rating /= (reviewCount + 1);

            hotelEntity.setOverallRating(Rating.values()[rating - 1]);
            hotelRepo.save(hotelEntity);
            reviewRepo.save(reviewEntity);
            return reviewEntity;
        }
        return null;
    }

    @Override
    public void deleteReview(int reviewId) {

        if (reviewRepo.findById(reviewId).isPresent()) {
            int hotelId = reviewRepo.findById(reviewId).get().getHotelId();
            HotelEntity hotelEntity = (hotelRepo.findById(hotelId)).get();

            int reviewCount = reviewRepo.countReviewPerHotel(hotelEntity.getId());
            if (reviewCount == 1) {
                hotelEntity.setOverallRating(null);
            } else {
                int rating = hotelEntity.getOverallRating().ordinal() + 1;

                rating = rating * reviewCount - reviewRepo.findById(reviewId).get().getRating().ordinal() - 1;
                rating /= (reviewCount - 1);

                hotelEntity.setOverallRating(Rating.values()[rating - 1]);

            }
            hotelRepo.save(hotelEntity);

            reviewRepo.deleteById(reviewId);
        }

    }

    @Override
    public ReviewEntity updateReview(String comment, Rating ratings, int reviewId) {

        ReviewEntity reviewEntity = reviewRepo.getById(reviewId);

        if (reviewEntity == null)
            return null;
        if (comment != null && !comment.equals("")) {
            reviewEntity.setComment(comment);
        }

        if (ratings != null) {
            HotelEntity hotelEntity = (hotelRepo.findById(reviewEntity.getHotelId())).get();

            int reviewCount = reviewRepo.countReviewPerHotel(hotelEntity.getId());
            int rating = hotelEntity.getOverallRating().ordinal() + 1;

            rating = rating * reviewCount + ratings.ordinal() + 1 - reviewEntity.getRating().ordinal() - 1;
            rating /= (reviewCount);

            hotelEntity.setOverallRating(Rating.values()[rating - 1]);
            hotelRepo.save(hotelEntity);
            reviewEntity.setRating(ratings);
        }

        reviewRepo.save(reviewEntity);
        return reviewEntity;

    }

    @Override
    public List<ReviewEntity> getReview(int id) {

        // return null;
        return reviewRepo.getReviewByHotelId(id);

    }

}
