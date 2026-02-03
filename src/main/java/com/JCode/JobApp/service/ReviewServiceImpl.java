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
}
