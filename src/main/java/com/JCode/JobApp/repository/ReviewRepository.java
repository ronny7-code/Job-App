package com.JCode.JobApp.repository;

import com.JCode.JobApp.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByCompanyId(Long id);

    Optional<Review> findByCompanyIdAndId(Long companyId, Long id);
}