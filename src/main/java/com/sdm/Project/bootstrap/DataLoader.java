package com.sdm.Project.bootstrap;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sdm.Project.domain.ClinicalRecord;
import com.sdm.Project.domain.Diagnosis;
import com.sdm.Project.domain.Doctor;
import com.sdm.Project.domain.Measurement;
import com.sdm.Project.domain.Nurse;
import com.sdm.Project.domain.Patient;
import com.sdm.Project.domain.Person;
import com.sdm.Project.domain.Treatment;
import com.sdm.Project.services.ClinicalRecordService;
import com.sdm.Project.services.DiagnosisService;
import com.sdm.Project.services.MedicalPersonnelService;
import com.sdm.Project.services.PatientService;

@Component
public class DataLoader implements CommandLineRunner {

    private final PatientService patientService;
    private final MedicalPersonnelService medicalPersonnelService;
    private final DiagnosisService diagnosisService;
    private final ClinicalRecordService clinicalRecordService;

    public DataLoader(PatientService patientService, MedicalPersonnelService medicalPersonnelService,
            DiagnosisService diagnosisService, ClinicalRecordService clinicalRecordService) {
        this.patientService = patientService;
        this.medicalPersonnelService = medicalPersonnelService;
        this.diagnosisService = diagnosisService;
        this.clinicalRecordService = clinicalRecordService;
    }

    void ShowPatientInfo(ClinicalRecord clinicalRecord) {
        System.out.println(clinicalRecord.getPatient());
        System.out.println(clinicalRecord.getPatient().getNurse());
        System.out.println(clinicalRecord.getPatient().getDoctor());
        for (Diagnosis diagnosis : clinicalRecord.getDiagnostics()) {
            System.out.println(diagnosis);
            for (Measurement m : diagnosis.getMeasurements()) {
                System.out.println(m);
            }
            System.out.println(diagnosis.getTreatment());
        }
    }

    @Override
    public void run(String... args) throws Exception {

        Patient Andrei = new Patient("Andrei", "Male", 21, new Person.Address("Sector 5", "Berzovia 26"), true);
        Patient Antonia = new Patient("Antonia", "Female", 22, new Person.Address("Sector 6", "Cernisoara 37"), true);
        Patient Gabi = new Patient("Gabi", "Male", 22, new Person.Address("Sector 6", "Bratasanca 102"), true);

        Diagnosis diagnosis1 = new Diagnosis("diagnosis1");
        Diagnosis diagnosis2 = new Diagnosis("diagnosis2");
        Diagnosis diagnosis3 = new Diagnosis("diagnosis3");
        Diagnosis diagnosis4 = new Diagnosis("diagnosis4");

        Measurement measurement1 = new Measurement(37, 100, LocalDate.now());
        Measurement measurement2 = new Measurement(36, 110, LocalDate.now());
        Measurement measurement3 = new Measurement(37.5, 105, LocalDate.now());
        Measurement measurement4 = new Measurement(38, 120, LocalDate.now());
        Measurement measurement5 = new Measurement(39, 130, LocalDate.now());

        Treatment treatment1 = new Treatment("Paracetamol");
        Treatment treatment2 = new Treatment("Nurofen");
        Treatment treatment3 = new Treatment("Fasconal");
        Treatment treatment4 = new Treatment("Painkiller");

        Doctor doctor = new Doctor("Pediatry");
        Doctor doctor1 = new Doctor("Surgery");
        Nurse nurse = new Nurse(0);
        Nurse nurse1 = new Nurse(1);

        ClinicalRecord clinicalRecordAndrei = new ClinicalRecord();
        ClinicalRecord clinicalRecordAntonia = new ClinicalRecord(Antonia);
        ClinicalRecord clinicalRecordGabi = new ClinicalRecord(Gabi);

        doctor.addPatient(Andrei);
        doctor.addPatient(Antonia);

        nurse.addPatient(Andrei);
        nurse.addPatient(Antonia);

        doctor1.addPatient(Gabi);
        nurse1.addPatient(Gabi);

        diagnosis1.addMeasurement(measurement1);
        diagnosis1.addMeasurement(measurement2);
        diagnosis1.setTreatment(treatment1);

        diagnosis2.addMeasurement(measurement3);
        diagnosis2.setTreatment(treatment2);

        diagnosis3.addMeasurement(measurement4);
        diagnosis3.setTreatment(treatment3);

        diagnosis4.addMeasurement(measurement5);
        diagnosis4.setTreatment(treatment4);

        doctor.addDiagnosis(diagnosis1);
        doctor.addDiagnosis(diagnosis2);
        doctor.addDiagnosis(diagnosis3);
        doctor1.addDiagnosis(diagnosis4);

        medicalPersonnelService.saveDoctor(doctor);
        medicalPersonnelService.saveNurse(nurse);
        medicalPersonnelService.saveDoctor(doctor1);
        medicalPersonnelService.saveNurse(nurse1);

        patientService.savePatient(Andrei);
        patientService.savePatient(Antonia);
        patientService.savePatient(Gabi);

        diagnosisService.saveMeasurement(measurement1);
        diagnosisService.saveMeasurement(measurement2);
        diagnosisService.saveMeasurement(measurement3);
        diagnosisService.saveMeasurement(measurement4);
        diagnosisService.saveMeasurement(measurement5);

        clinicalRecordAndrei.setPatient(Andrei);
        clinicalRecordAndrei.addDiagnostics(diagnosis1);
        clinicalRecordAndrei.addDiagnostics(diagnosis2);

        clinicalRecordAntonia.addDiagnostics(diagnosis3);

        clinicalRecordGabi.addDiagnostics(diagnosis4);

        clinicalRecordService.saveClinicalRecord(clinicalRecordAndrei);
        clinicalRecordService.saveClinicalRecord(clinicalRecordAntonia);
        clinicalRecordService.saveClinicalRecord(clinicalRecordGabi);

        diagnosisService.saveDiagnosis(diagnosis1);
        diagnosisService.saveDiagnosis(diagnosis2);
        diagnosisService.saveDiagnosis(diagnosis3);
        diagnosisService.saveDiagnosis(diagnosis4);

        diagnosisService.saveTreatment(treatment1);
        diagnosisService.saveTreatment(treatment2);
        diagnosisService.saveTreatment(treatment3);
        diagnosisService.saveTreatment(treatment4);

        ShowPatientInfo(clinicalRecordAndrei);
        System.out.println();
        ShowPatientInfo(clinicalRecordAntonia);
        System.out.println();
        ShowPatientInfo(clinicalRecordGabi);

    }
}
