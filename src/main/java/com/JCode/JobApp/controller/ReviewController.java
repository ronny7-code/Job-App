package com.JCode.JobApp.controller;

import com.JCode.JobApp.entity.Review;
import com.JCode.JobApp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review){
        boolean isReviewAdded = reviewService.addReview(companyId, review);
        if(isReviewAdded){
            return new ResponseEntity<>("Review added successfully!", HttpStatus.CREATED);
        }
        return  new ResponseEntity<>("Review not saved!", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId, @PathVariable Long reviewId){
        Review review = reviewService.getReviewById(companyId, reviewId);
        if(review != null){
            return ResponseEntity.ok(review);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId,
                                               @PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean isUpdated = reviewService.updateReview(companyId, reviewId, review);
        if(isUpdated){
            return new ResponseEntity<>("Review has been updated!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not updated!", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isDeleted = reviewService.deleteReview(companyId, reviewId);
        if(isDeleted){
            return new ResponseEntity<>("Review has been deleted!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not deleted!", HttpStatus.NOT_FOUND);
    }
}
