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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Applicant;
import com.example.demo.repositories.ApplicantRepository;
import com.example.demo.services.JobService; 

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantRepository applicantRepository;

    @GetMapping
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Applicant getApplicantById(@PathVariable int id) {
        return applicantRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Applicant createApplicant(@RequestBody Applicant applicant) {
        return applicantRepository.save(applicant);
    }    
    

    @PutMapping("/{id}")
    public Applicant updateApplicant(@PathVariable int id, @RequestBody Applicant applicant) {
        applicant.setId(id);
        return applicantRepository.save(applicant);
    }

    @DeleteMapping("/{id}")
    public void deleteApplicant(@PathVariable int id) {
        applicantRepository.deleteById(id);
    }
}