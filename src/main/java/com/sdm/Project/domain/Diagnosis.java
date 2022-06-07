package com.sdm.Project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "doctors", "treatment", "measurements", "clinicalRecord" })
@ToString(exclude = { "doctors", "treatment", "measurements", "clinicalRecord" })
public class Diagnosis {

    @Id
    @GeneratedValue
    private long diagnosisId;
    private String diagnosisDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatment_id", referencedColumnName = "id")
    private Treatment treatment;

    @OneToMany(mappedBy = "diagnosis", cascade = CascadeType.REMOVE)
    private Set<Measurement> measurements = new HashSet<>();

    public void addMeasurement(Measurement measurement) {
        measurements.add(measurement);
        measurement.setDiagnosis(this);
    }

    public void removeMeasurement(Measurement measurement) {
        measurements.remove(measurement);
        measurement.setDiagnosis(null);
    }

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "doctor_diagnostics", joinColumns = { @JoinColumn(name = "diagnosis_id") }, inverseJoinColumns = {
            @JoinColumn(name = "doctor_id") })
    Set<Doctor> doctors = new HashSet<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        doctor.getDiagnostics().add(this);
    }

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "clinical_record_id")
    private ClinicalRecord clinicalRecord;

    public ClinicalRecord getClinicalRecord() {
        return clinicalRecord;
    }

    public void setClinicalRecord(ClinicalRecord clinicalRecord) {
        this.clinicalRecord = clinicalRecord;
    }

    public Diagnosis(String diagnosisDescription) {
        this.diagnosisDescription = diagnosisDescription;
    }

    public long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public String getDiagnosisDescription() {
        return diagnosisDescription;
    }

    public void setDiagnosisDescription(String diagnosisDescription) {
        this.diagnosisDescription = diagnosisDescription;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Set<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Set<Measurement> measurements) {
        this.measurements = measurements;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
        treatment.setDiagnosis(this);
    }

}
