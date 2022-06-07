package com.sdm.Project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdm.Project.domain.Nurse;

public interface NurseRepository extends CrudRepository<Nurse, Long> {
}
