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
            return new ResponseEntity<>("Review added successfully!", HttpStatus.OK);
        }
        return  new ResponseEntity<>("Review not saved!", HttpStatus.NOT_FOUND);
    }
}
