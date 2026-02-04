package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Company;
import com.JCode.JobApp.entity.Review;
import com.JCode.JobApp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    @Override
    @Transactional(readOnly = true)
    public List<Review> getAllReviews(Long id) {
        return reviewRepository.findByCompanyId(id);
    }

    @Override
    @Transactional
    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Review getReviewById(Long companyId, Long reviewId) {
        return reviewRepository.findByCompanyIdAndId(companyId, reviewId).orElse(null);
    }

    @Override
    @Transactional
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        Review existingReview = reviewRepository.findByCompanyIdAndId(companyId, reviewId).orElse(null);

        if (existingReview != null) {
            existingReview.setTitle(updatedReview.getTitle());
            existingReview.setDescription(updatedReview.getDescription());
            existingReview.setRating(updatedReview.getRating());

            reviewRepository.save(existingReview);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public boolean deleteReview(Long companyId, Long reviewId) {
        Review review = reviewRepository.findByCompanyIdAndId(companyId, reviewId).orElse(null);

        if(review != null){
            reviewRepository.delete(review);
            return true;
        }
        return false;
    }
}
