package com.sdm.Project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdm.Project.domain.Doctor;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
}
