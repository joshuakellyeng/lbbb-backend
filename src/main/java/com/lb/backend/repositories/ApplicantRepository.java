package com.lb.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.backend.models.Applicant;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {

}
