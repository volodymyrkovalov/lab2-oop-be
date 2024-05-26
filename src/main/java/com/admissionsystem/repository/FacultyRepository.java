package com.admissionsystem.repository.custom.impl;

import com.admissionsystem.model.Faculty;
import com.admissionsystem.repository.custom.CustomFacultyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public class FacultyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Faculty> findByAdmissionPlanGreaterThan(int admissionPlan) {
        String jpql = "SELECT f FROM Faculty f WHERE f.admissionPlan > :admissionPlan";
        TypedQuery<Faculty> query = entityManager.createQuery(jpql, Faculty.class);
        query.setParameter("admissionPlan", admissionPlan);
        return query.getResultList();
    }

    @Override
    public Faculty findByName(String name) {
        String jpql = "SELECT f FROM Faculty f WHERE f.name = :name";
        TypedQuery<Faculty> query = entityManager.createQuery(jpql, Faculty.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
