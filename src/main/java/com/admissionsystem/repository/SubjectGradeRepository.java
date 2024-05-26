package com.admissionsystem.repository;

public class SubjectGradeRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<SubjectGrade> findByApplicantId(Long applicantId) {
        String jpql = "SELECT sg FROM SubjectGrade sg WHERE sg.applicant.id = :applicantId";
        TypedQuery<SubjectGrade> query = entityManager.createQuery(jpql, SubjectGrade.class);
        query.setParameter("applicantId", applicantId);
        return query.getResultList();
    }

    @Override
    public List<SubjectGrade> findByGradeGreaterThan(double grade) {
        String jpql = "SELECT sg FROM SubjectGrade sg WHERE sg.grade > :grade";
        TypedQuery<SubjectGrade> query = entityManager.createQuery(jpql, SubjectGrade.class);
        query.setParameter("grade", grade);
        return query.getResultList();
    }
}
