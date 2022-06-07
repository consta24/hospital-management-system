package com.sdm.Project.services;

import org.springframework.stereotype.Service;

import com.sdm.Project.domain.Patient;
import com.sdm.Project.repositories.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public void savePatient(Patient patient) {
        patientRepository.save(patient);
    }
}
