package com.sdm.Project.repositories;

import com.sdm.Project.domain.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {
}
