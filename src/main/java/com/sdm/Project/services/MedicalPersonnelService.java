package com.sdm.Project.services;

import com.sdm.Project.domain.Doctor;
import com.sdm.Project.domain.Nurse;

public interface MedicalPersonnelService {

    void saveDoctor(Doctor doctor);

    void saveNurse(Nurse nurse);
}
