package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qspidsers.hospital_management_system.entity.Patient;
import com.qspidsers.hospital_management_system.repository.PatientRepository;


@Repository
public class PatientDao {
    
    @Autowired
    private PatientRepository patientsRepo;

    // Save a new patient
    public List<Patient> savePatientDao(List<Patient> patient) {
        return patientsRepo.saveAll(patient);
    }

    // Get a patient by ID
    public Patient getPatientByIdDao(int id) {
        return patientsRepo.findById(id).orElse(null);
    }

    // Get all patients
    public List<Patient> getAllPatientsDao(){
        return patientsRepo.findAll();
    }

    // Update an existing patient
    @Transactional
    public Patient updatePatientDao(int id, Patient updatePatient) {
        Optional<Patient> optional = patientsRepo.findById(id);
        
        if(optional.isPresent()) {
            Patient patient = optional.get();
            patient.setFirstName(updatePatient.getFirstName());
            patient.setLastName(updatePatient.getLastName());
            patient.setAddress(updatePatient.getAddress());
            patient.setBloodType(updatePatient.getBloodType());
            patient.setContactNumber(updatePatient.getContactNumber());
            patient.setDateOfBirth(updatePatient.getDateOfBirth());
            patient.setEmail(updatePatient.getEmail());
            patient.setEmergencyContact(updatePatient.getEmergencyContact());
            patient.setGender(updatePatient.getGender());
            return patientsRepo.save(patient);
        } else {
            return null;
        }
    }

    // Delete a patient by ID
    public Patient deletePatientDao(int id) {
        Optional<Patient> optional = patientsRepo.findById(id);
        if(optional.isPresent()) {
            patientsRepo.deleteById(id);
            return optional.get();
        } else {
            return null;
        }
    }

    // Delete patients by full name
    public int deletePatientsByFullNameDao(String fullName){
        return patientsRepo.deleteByPatientFullName(fullName);
    }
}
