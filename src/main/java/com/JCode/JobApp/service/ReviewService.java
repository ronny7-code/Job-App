package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getAllReviews(Long id);

    boolean addReview(Long companyId, Review review);

}
