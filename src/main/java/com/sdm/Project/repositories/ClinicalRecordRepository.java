package com.sdm.Project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdm.Project.domain.ClinicalRecord;

public interface ClinicalRecordRepository extends CrudRepository<ClinicalRecord, Long> {
}
