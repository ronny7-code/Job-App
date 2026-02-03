package com.JCode.JobApp.service;

import com.JCode.JobApp.entity.Job;

import java.util.List;
import java.util.Optional;

public interface JobService {

    List<Job> findAll();

    Job createJob(Job job);

    Job findJobById(Long id);

    boolean deleteJob(Long id);

    Job updateJob(Long id, Job job);
}