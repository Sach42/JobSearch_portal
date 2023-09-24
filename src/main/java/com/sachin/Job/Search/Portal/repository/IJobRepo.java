package com.sachin.Job.Search.Portal.repository;

import com.sachin.Job.Search.Portal.model.Job;
import com.sachin.Job.Search.Portal.model.JobType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {
    // Custom finder method to search by title and description
    List<Job> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);

    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByDescriptionContainingIgnoreCase(String description);

   // List<Job> findByJobType(JobType jobType);

    //  query to search for job salary above a specific value
    @Query(value ="SELECT * FROM jobs WHERE salary > :salary", nativeQuery = true)
    List<Job> findJobsWithSalaryAbove( double salary);

    @Query(value ="SELECT * FROM jobs WHERE company_name = :companyName", nativeQuery = true)
    List<Job> findJobsByCompanyName(String companyName);

    @Query(value = "SELECT * FROM jobs WHERE employer_Name = :employerName" , nativeQuery = true)
    List<Job> findJobsByEmployerName(String employerName);

    @Query(value = "SELECT * FROM jobs WHERE location = :location" , nativeQuery = true)
    List<Job> findJobsByLocation(@Param("location") String location);
}
