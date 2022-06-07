package com.sdm.Project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdm.Project.domain.Diagnosis;

public interface DiagnosisRepository extends CrudRepository<Diagnosis, Long> {
}
