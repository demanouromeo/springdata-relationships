package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.ApplicantJob;
import com.example.demo.repositories.ApplicantJobRepository;

@RestController
@RequestMapping("/applicantjobs")
public class ApplicantJobController {

    @Autowired
    private ApplicantJobRepository applicantJobRepository;

    @GetMapping
    public List<ApplicantJob> getAllApplicantJobs() {
        return applicantJobRepository.findAll();
    }

    @GetMapping("/{id}")
    public ApplicantJob getApplicantJobById(@PathVariable int id) {
        return applicantJobRepository.findById(id).orElse(null);
    }

    @PostMapping
    public ApplicantJob createApplicantJob(@RequestBody ApplicantJob applicantJob) {
        return applicantJobRepository.save(applicantJob);
    }

    @PutMapping("/{id}")
    public ApplicantJob updateApplicantJob(@PathVariable int id, @RequestBody ApplicantJob applicantJob) {
        applicantJob.setId(id);
        return applicantJobRepository.save(applicantJob);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicantJob(@PathVariable int id) {
        applicantJobRepository.deleteById(id);
    }
}
