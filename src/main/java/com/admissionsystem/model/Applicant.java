package com.admissionsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;
    private double averageGrade;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    @OneToMany(mappedBy = "applicant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubjectGrade> subjectGrades;

    // Constructors
    public Applicant() {
    }

    public Applicant(String firstName, String lastName, String email, double averageGrade, Faculty faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.averageGrade = averageGrade;
        this.faculty = faculty;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public List<SubjectGrade> getSubjectGrades() {
        return subjectGrades;
    }

    public void setSubjectGrades(List<SubjectGrade> subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    // Additional methods if needed
}
