package com.JCode.JobApp.repository;

import com.JCode.JobApp.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}