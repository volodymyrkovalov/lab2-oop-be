package com.admissionsystem.repository;

import com.admissionsystem.model.Applicant;

import java.util.List;

public class ApplicationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Applicant> findApplicantsWithAverageGradeGreaterThan(double grade) {
        String jpql = "SELECT a FROM Applicant a WHERE a.averageGrade > :grade";
        TypedQuery<Applicant> query = entityManager.createQuery(jpql, Applicant.class);
        query.setParameter("grade", grade);
        return query.getResultList();
    }

    @Override
    public List<Applicant> findByLastNameIgnoreCase(String lastName) {
        String jpql = "SELECT a FROM Applicant a WHERE LOWER(a.lastName) = LOWER(:lastName)";
        TypedQuery<Applicant> query = entityManager.createQuery(jpql, Applicant.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
