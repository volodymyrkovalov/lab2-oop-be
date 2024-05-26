package com.admissionsystem.model;

import javax.persistence.*;

@Entity
public class SubjectGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private double grade;

    @ManyToOne
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    // Constructors
    public SubjectGrade() {
    }

    public SubjectGrade(String subjectName, double grade, Applicant applicant) {
        this.subjectName = subjectName;
        this.grade = grade;
        this.applicant = applicant;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    // Additional methods if needed
}
