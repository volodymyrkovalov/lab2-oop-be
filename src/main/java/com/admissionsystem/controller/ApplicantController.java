package com.admissionsystem.controller;

import com.admissionsystem.model.Applicant;
import com.admissionsystem.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/register")
    public ResponseEntity<Applicant> registerApplicant(@RequestBody Applicant applicant) {
        Applicant savedApplicant = applicantService.registerApplicant(applicant);
        return new ResponseEntity<>(savedApplicant, HttpStatus.CREATED);
    }

    @GetMapping("/calculate-results")
    public ResponseEntity<List<Applicant>> calculateResults() {
        List<Applicant> acceptedApplicants = applicantService.calculateResults();
        return new ResponseEntity<>(acceptedApplicants, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id) {
        Applicant applicant = applicantService.getApplicantById(id);
        if (applicant != null) {
            return new ResponseEntity<>(applicant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Applicant> updateApplicant(@PathVariable Long id, @RequestBody Applicant applicantDetails) {
        Applicant updatedApplicant = applicantService.updateApplicant(id, applicantDetails);
        if (updatedApplicant != null) {
            return new ResponseEntity<>(updatedApplicant, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        boolean isDeleted = applicantService.deleteApplicant(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}