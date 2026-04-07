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

import com.example.demo.entities.Resume;
import com.example.demo.repositories.ResumeRepository;

@RestController
@RequestMapping("/resumes")
public class ResumeController {

    @Autowired
    private ResumeRepository resumeRepository;

    @GetMapping
    public List<Resume> getAllResumes() {
        return resumeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Resume getResumeById(@PathVariable int id) {
        return resumeRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Resume createResume(@RequestBody Resume resume) {
        return resumeRepository.save(resume);
    }

    @PutMapping("/{id}")
    public Resume updateResume(@PathVariable int id, @RequestBody Resume resume) {
        resume.setId(id);
        return resumeRepository.save(resume);
    }

    @DeleteMapping("/{id}")
    public void deleteResume(@PathVariable int id) {
        resumeRepository.deleteById(id);
    }
}