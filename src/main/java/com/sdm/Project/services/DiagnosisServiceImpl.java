package com.sdm.Project.services;

import com.sdm.Project.domain.Diagnosis;
import com.sdm.Project.domain.Measurement;
import com.sdm.Project.domain.Treatment;
import com.sdm.Project.repositories.DiagnosisRepository;
import com.sdm.Project.repositories.MeasurementRepository;
import com.sdm.Project.repositories.TreatmentRepository;
import org.springframework.stereotype.Service;

@Service
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;
    private final MeasurementRepository measurementRepository;

    private final TreatmentRepository treatmentRepository;

    public DiagnosisServiceImpl(DiagnosisRepository diagnosisRepository, MeasurementRepository measurementRepository, TreatmentRepository treatmentRepository) {
        this.diagnosisRepository = diagnosisRepository;
        this.measurementRepository = measurementRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public void saveDiagnosis(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public void saveMeasurement(Measurement measurement) {
        measurementRepository.save(measurement);
    }

    @Override
    public void saveTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }


}
