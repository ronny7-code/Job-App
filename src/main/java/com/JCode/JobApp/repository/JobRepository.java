package com.JCode.JobApp.repository;

import com.JCode.JobApp.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}