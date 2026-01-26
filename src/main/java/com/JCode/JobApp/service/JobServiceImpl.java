package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Job;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public Job createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
        return job;
    }

    @Override
    public Job findJobById(Long id) {
        for(Job job: jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteJob(Long id) {
        return jobs.removeIf(job -> job.getId().equals(id));
    }

    @Override
    public boolean updateJob(Long id, Job newJob) {

        Job existingJob = findJobById(id);

        if (existingJob == null) {
            return false;
        }

        existingJob.setTitle(newJob.getTitle());
        existingJob.setDescription(newJob.getDescription());
        existingJob.setMaxSalary(newJob.getMaxSalary());
        existingJob.setMinSalary(newJob.getMinSalary());
        existingJob.setSalary(newJob.getSalary());
        existingJob.setLocation(newJob.getLocation());

        return true;
    }
}