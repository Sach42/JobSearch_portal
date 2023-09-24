package com.sachin.Job.Search.Portal.controller;

import com.sachin.Job.Search.Portal.model.Job;
import com.sachin.Job.Search.Portal.model.JobType;
import com.sachin.Job.Search.Portal.service.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @PostMapping
    public  String createJob(@Valid @RequestBody Job job){
        return jobService.createJob(job);
    }

    @GetMapping("/{id}")
    public String getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PutMapping("/{id}")
    public String updateJob(@PathVariable Long id, @Valid @RequestBody Job job) {
        return jobService.updateJob(id, job);
    }

    @DeleteMapping("/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }

    @GetMapping("/search")
    public String searchJobs(@RequestParam(required = false) String title, @RequestParam(required = false) String description) {
        if (title != null && description != null) {
            return jobService.searchJobsByTitleAndDescription(title, description);
        } else if (title != null) {
            return jobService.searchJobsByTitle(title);
        } else if (description != null) {
            return jobService.searchJobsByDescription(description);
        } else {
            return "Invalid search criteria";
        }
    }

    @GetMapping("/search/salary")
    public String searchJobsWithSalaryAbove(@RequestParam double salary) {
        return jobService.searchJobsWithSalaryAbove(salary);
    }
    @GetMapping("/search/company-name")
    public String searchJobsByCompanyName(@RequestParam String companyName) {
        return jobService.searchJobsByCompanyName(companyName);
    }

    @GetMapping("/search/employer-name")
    public String searchJobsByEmployerName(@RequestParam String employerName) {
        return jobService.searchJobsByEmployerName(employerName);
    }

//    @GetMapping("/search/job-type")
//    public String searchJobsByType(@RequestParam JobType jobType) {
//        return jobService.searchJobsByType(jobType);
//    }


    @GetMapping("/search/location")
    public String searchJobsByLocation(@RequestParam String location) {
        return jobService.searchJobsByLocation(location);
    }
}
