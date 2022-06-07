package com.sdm.Project.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@EqualsAndHashCode(exclude = "patientSet")
@ToString(exclude = "patientSet")
public class Nurse {
    @Id
    @GeneratedValue
    private long id;
    private int floor;

    public Nurse(int floor) {
        this.floor = floor;
    }

    @OneToMany(mappedBy = "nurse", cascade = CascadeType.REMOVE)
    private Set<Patient> patientSet = new HashSet<>();

    public void addPatient(Patient patient) {
        patientSet.add(patient);
        patient.setNurse(this);
    }

    public void removePatient(Patient patient) {
        patientSet.remove(patient);
        patient.setNurse(null);
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Patient> getPatientSet() {
        return patientSet;
    }

    public void setPatientSet(Set<Patient> patientSet) {
        this.patientSet = patientSet;
    }

}
