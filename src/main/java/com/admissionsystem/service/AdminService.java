package com.admissionsystem.service;

import com.admissionsystem.model.Applicant;
import com.admissionsystem.model.SubjectGrade;
import com.admissionsystem.repository.ApplicationRepository;
import com.admissionsystem.repository.SubjectGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicationRepository applicantRepository;

    @Autowired
    private SubjectGradeRepository subjectGradeRepository;

    @Transactional
    public Applicant registerApplicant(Applicant applicant) {
        // Save the applicant and their grades
        Applicant savedApplicant = applicantRepository.save(applicant);
        if (applicant.getSubjectGrades() != null) {
            for (SubjectGrade grade : applicant.getSubjectGrades()) {
                grade.setApplicant(savedApplicant);
                subjectGradeRepository.save(grade);
            }
        }
        return savedApplicant;
    }

    public List<Applicant> calculateResults() {
        // Logic for calculating results and determining admitted applicants
        List<Applicant> allApplicants = applicantRepository.findAll();
        allApplicants.sort((a1, a2) -> Double.compare(calculateTotalScore(a2), calculateTotalScore(a1)));
        // Assuming the top N applicants are admitted based on their scores
        return allApplicants;
    }

    private double calculateTotalScore(Applicant applicant) {
        double totalScore = applicant.getAverageGrade();
        for (SubjectGrade grade : applicant.getSubjectGrades()) {
            totalScore += grade.getGrade();
        }
        return totalScore;
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id).orElse(null);
    }

    @Transactional
    public Applicant updateApplicant(Long id, Applicant applicantDetails) {
        Applicant existingApplicant = applicantRepository.findById(id).orElse(null);
        if (existingApplicant != null) {
            existingApplicant.setFirstName(applicantDetails.getFirstName());
            existingApplicant.setLastName(applicantDetails.getLastName());
            existingApplicant.setEmail(applicantDetails.getEmail());
            existingApplicant.setAverageGrade(applicantDetails.getAverageGrade());
            existingApplicant.setFaculty(applicantDetails.getFaculty());
            existingApplicant.setSubjectGrades(applicantDetails.getSubjectGrades());

            applicantRepository.save(existingApplicant);
            if (applicantDetails.getSubjectGrades() != null) {
                subjectGradeRepository.deleteAll(existingApplicant.getSubjectGrades());
                for (SubjectGrade grade : applicantDetails.getSubjectGrades()) {
                    grade.setApplicant(existingApplicant);
                    subjectGradeRepository.save(grade);
                }
            }
            return existingApplicant;
        }
        return null;
    }

    @Transactional
    public boolean deleteApplicant(Long id) {
        if (applicantRepository.existsById(id)) {
            applicantRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
