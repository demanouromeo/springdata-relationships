package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Job;
import com.example.demo.repositories.JobRepository;
import com.example.demo.services.JobService;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobRepository.findById(id).orElse(null);
    }

    /*
    @PostMapping("/add_job_to_applicant")
    public ResponseEntity<Void> addJob(@RequestParam int applicantId, @RequestParam int jobId) { 
        boolean res = jobService.addJobToApplicant(applicantId, jobId, LocalDateTime.now());
        if(res){
          return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.notFound().build();
        }
    }
    
    */
   @PostMapping("/add_job_to_applicant")
    public String addJob(@RequestParam int applicantId, @RequestParam int jobId) { 
        boolean res = jobService.addJobToApplicant(applicantId, jobId, LocalDateTime.now());
        if(res){
          return "Job successfully assigned.[ "+res+" ]";
        }else{
           return "Failed to add job to applicant.[ "+res+" ]";
        }
    }


    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    @PutMapping("/{id}")
    public Job updateJob(@PathVariable int id, @RequestBody Job job) {
        job.setId(id);
        return jobRepository.save(job);
    }

    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable int id) {
        jobRepository.deleteById(id);
    }
}
