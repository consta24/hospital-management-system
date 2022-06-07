package com.sdm.Project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sdm.Project.domain.Measurement;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
