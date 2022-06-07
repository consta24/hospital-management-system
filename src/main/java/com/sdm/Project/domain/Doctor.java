package com.sdm.Project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = { "patientSet", "diagnostics" })
@ToString(exclude = { "patientSet", "diagnostics" })
public class Doctor {

    @Id
    @GeneratedValue
    private long id;
    private String specialization;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.REMOVE)
    private Set<Patient> patientSet = new HashSet<>();

    @ManyToMany(mappedBy = "doctors", cascade = CascadeType.ALL)
    private Set<Diagnosis> diagnostics = new HashSet<>();

    public void addDiagnosis(Diagnosis diagnosis) {
        diagnostics.add(diagnosis);
        diagnosis.doctors.add(this);
    }

    public void addPatient(Patient patient) {
        patientSet.add(patient);
        patient.setDoctor(this);
    }

    public void removePatient(Patient patient) {
        patientSet.remove(patient);
        patient.setDoctor(null);
    }

    public Doctor(String specialization) {
        this.specialization = specialization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

    public Set<Diagnosis> getDiagnoses() {
        return diagnostics;
    }

    public void setDiagnoses(Set<Diagnosis> diagnostics) {
        this.diagnostics = diagnostics;
    }

}
