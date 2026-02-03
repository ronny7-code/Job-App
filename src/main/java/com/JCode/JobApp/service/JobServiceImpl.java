package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Company;
import com.JCode.JobApp.entity.Job;
import com.JCode.JobApp.repository.CompanyRepository;
import com.JCode.JobApp.repository.JobRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    private final CompanyRepository companyRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    @Transactional
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    @Override
    @Transactional(readOnly = true)
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public boolean deleteJob(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Job updateJob(Long id, Job newJob) {

        Job existingJob = findJobById(id);

        if (existingJob == null) {
            return null;
        }

        existingJob.setTitle(newJob.getTitle());
        existingJob.setDescription(newJob.getDescription());
        existingJob.setSalary(newJob.getSalary());
        existingJob.setLocation(newJob.getLocation());
        return jobRepository.save(existingJob);
    }
}