package com.admissionsystem.controller;

import com.admissionsystem.model.SubjectGrade;
import com.admissionsystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/register-results")
    public ResponseEntity<Void> registerResults(@RequestBody List<SubjectGrade> grades) {
        adminService.registerResults(grades);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/view-applicants")
    public ResponseEntity<List<SubjectGrade>> viewApplicants() {
        List<SubjectGrade> applicants = adminService.getAllApplicants();
        return new ResponseEntity<>(applicants, HttpStatus.OK);
    }

    @GetMapping("/applicant/{id}/grades")
    public ResponseEntity<List<SubjectGrade>> getApplicantGrades(@PathVariable Long id) {
        List<SubjectGrade> grades = adminService.getApplicantGrades(id);
        if (grades != null) {
            return new ResponseEntity<>(grades, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/update-grade/{id}")
    public ResponseEntity<SubjectGrade> updateGrade(@PathVariable Long id, @RequestBody SubjectGrade gradeDetails) {
        SubjectGrade updatedGrade = adminService.updateGrade(id, gradeDetails);
        if (updatedGrade != null) {
            return new ResponseEntity<>(updatedGrade, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete-grade/{id}")
    public ResponseEntity<Void> deleteGrade(@PathVariable Long id) {
        boolean isDeleted = adminService.deleteGrade(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}