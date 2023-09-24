package com.sachin.Job.Search.Portal.service;

import com.sachin.Job.Search.Portal.model.Job;
import com.sachin.Job.Search.Portal.model.JobType;
import com.sachin.Job.Search.Portal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class JobService {

    @Autowired
    IJobRepo jobRepo;

    public String createJob(Job job) {
        jobRepo.save(job);
        return "Job added";
    }

    public String getJobById(Long id) {
        Optional<Job> jobOptional = jobRepo.findById(id);
        return jobOptional.map(job -> "Job found: " + job.toString()).orElse("Job not found");
    }

    public String updateJob(Long id, Job job) {
        Optional<Job> existingJobOptional = jobRepo.findById(id);
        if (existingJobOptional.isPresent()) {
            Job existingJob = existingJobOptional.get();
            existingJob.setTitle(job.getTitle());
            existingJob.setDescription(job.getDescription());
            existingJob.setLocation(job.getLocation());
            existingJob.setSalary(job.getSalary());
            existingJob.setCompanyEmail(job.getCompanyEmail());
            existingJob.setCompanyName(job.getCompanyName());
            existingJob.setEmployerName(job.getEmployerName());
            existingJob.setJobType(job.getJobType());
            existingJob.setAppliedDate(job.getAppliedDate());
            jobRepo.save(existingJob);
            return "Job updated with ID: " + existingJob.getId();
        } else {
            return "Job not found";
        }
    }

    public String deleteJob(Long id) {
        jobRepo.deleteById(id);
        return "deleted" ;
    }

    public String searchJobsByTitleAndDescription(String title, String description) {
        List<Job> jobs = jobRepo.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(title, description);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByTitle(String title) {
        List<Job> jobs = jobRepo.findByTitleContainingIgnoreCase(title);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsByDescription(String description) {
        List<Job> jobs = jobRepo.findByDescriptionContainingIgnoreCase(description);
        return "Search result: " + jobs.toString();
    }

    public String searchJobsWithSalaryAbove(double salary) {
        List<Job> jobs = jobRepo.findJobsWithSalaryAbove(salary);
        return "Search result: " + jobs.toString();}




    public String searchJobsByCompanyName(String companyName) {
        List<Job> jobs = jobRepo.findJobsByCompanyName(companyName);
        return "Search result: " + jobs.toString();
    }
    public String searchJobsByEmployerName(String employerName) {
        List<Job> jobs = jobRepo.findJobsByEmployerName(employerName);
        return "Search result: " + jobs.toString();
    }

//    public String searchJobsByType(JobType jobType) {
//        List<Job> jobs = jobRepo.findByJobType(jobType);
//        return "Search result: " + jobs.toString();
//    }


    public String searchJobsByLocation(String location) {
        List<Job> jobs = jobRepo.findJobsByLocation(location);
        return "Search result: " + jobs.toString();
    }

//    public String searchJobsByType(JobType jobType) {
//        List<Job> jobList = jobRepo.findByJobType(jobType);
//        return "retrieve";
//    }
}
