package com.alore.bookhotel.controller;

import com.alore.bookhotel.dao.Review;
import com.alore.bookhotel.dto.reviewdto.AddReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewRequest;
import com.alore.bookhotel.dto.reviewdto.DeleteReviewResponse;
import com.alore.bookhotel.dto.reviewdto.ReviewResponse;
import com.alore.bookhotel.dto.reviewdto.UpdateReviewRequest;
import com.alore.bookhotel.service.ReviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/BookMyHotel")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review")
    public ResponseEntity<ReviewResponse> addReview(@RequestBody AddReviewRequest addReviewRequest) {

        if (addReviewRequest != null) {

            ReviewResponse result = reviewService.addReview(addReviewRequest);
            if (result != null)
                return ResponseEntity.ok().body(result);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/review")
    public ResponseEntity<DeleteReviewResponse> deleteReview(@RequestBody DeleteReviewRequest deleteReviewRequest) {

        if (deleteReviewRequest != null) {

            DeleteReviewResponse result = reviewService.deleteReview(deleteReviewRequest);
            return ResponseEntity.ok().body(result);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/review")
    public ResponseEntity<ReviewResponse> updateReview(@RequestBody UpdateReviewRequest updateReviewRequest) {

        if (updateReviewRequest != null) {

            ReviewResponse result = reviewService.updateReview(updateReviewRequest);
            if (result != null)
                return ResponseEntity.ok().body(result);

        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
