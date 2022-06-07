package com.sdm.Project.services;

import com.sdm.Project.domain.*;


public interface DiagnosisService {
    void saveDiagnosis(Diagnosis diagnosis);
    void saveMeasurement(Measurement measurement);

    void saveTreatment(Treatment treatment);
}
