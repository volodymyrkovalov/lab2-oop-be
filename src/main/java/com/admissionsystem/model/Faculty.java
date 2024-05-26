package com.admissionsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int admissionPlan;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Applicant> applicants;

    // Constructors
    public Faculty() {
    }

    public Faculty(String name, int admissionPlan) {
        this.name = name;
        this.admissionPlan = admissionPlan;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAdmissionPlan() {
        return admissionPlan;
    }

    public void setAdmissionPlan(int admissionPlan) {
        this.admissionPlan = admissionPlan;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    // Additional methods if needed
}
