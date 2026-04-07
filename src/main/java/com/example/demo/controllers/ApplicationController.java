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

import com.example.demo.entities.Application;
import com.example.demo.repositories.ApplicationRepository;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Application getApplicationById(@PathVariable int id) {
        return applicationRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Application createApplication(@RequestBody Application application) {
        return applicationRepository.save(application);
    }

    @PutMapping("/{id}")
    public Application updateApplication(@PathVariable int id, @RequestBody Application application) {
        application.setId(id);
        return applicationRepository.save(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable int id) {
        applicationRepository.deleteById(id);
    }
}