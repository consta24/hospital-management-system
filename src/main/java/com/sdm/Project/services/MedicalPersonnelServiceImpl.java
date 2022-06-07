package com.sdm.Project.services;

import org.springframework.stereotype.Service;

import com.sdm.Project.domain.Doctor;
import com.sdm.Project.domain.Nurse;
import com.sdm.Project.repositories.DoctorRepository;
import com.sdm.Project.repositories.NurseRepository;

@Service
public class MedicalPersonnelServiceImpl implements MedicalPersonnelService {

    private final DoctorRepository doctorRepository;
    private final NurseRepository nurseRepository;

    public MedicalPersonnelServiceImpl(DoctorRepository doctorRepository, NurseRepository nurseRepository) {
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
    }

    @Override
    public void saveDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public void saveNurse(Nurse nurse) {
        nurseRepository.save(nurse);
    }

}
