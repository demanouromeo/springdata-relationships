package com.example.demo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.ApplicantJob;
import com.example.demo.repositories.ApplicantJobRepository;
import com.example.demo.repositories.ApplicantRepository;
import com.example.demo.repositories.JobRepository;

@Service
public class JobService {

    @Autowired
    private ApplicantRepository applicantRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    public ApplicantJobRepository applicantJobRepository;

    public boolean addJobToApplicant(int applicantId, int jobId, LocalDateTime startDate) {
        // Logic to add a job to an applicant

        try {
            var applicant = applicantRepository.findById(applicantId);
            var job = jobRepository.findById(jobId);
            if (applicant.isPresent() && job.isPresent()) {
                var applicantJob = new ApplicantJob();
                applicantJob.setApplicant(applicant.get());
                applicantJob.setJob(job.get());
                applicantJob.setData(startDate);
                applicant.get().getJobs().add(job.get());
                job.get().getApplicants().add(applicant.get());
                applicantJobRepository.save(applicantJob);
            } else {
                System.out.println("Applicant or Job not found");
                return false; // Applicant or Job not found
            }
        } catch (Exception e) {
            System.out.println("Error adding job to applicant: " + e.getMessage());
            return false;
        }
        return true; // Placeholder return value
    }
}
