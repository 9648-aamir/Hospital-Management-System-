package com.qspidsers.hospital_management_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qspidsers.hospital_management_system.dao.PatientDao;
import com.qspidsers.hospital_management_system.entity.Patient;

@RestController
@RequestMapping("/patientController")
public class PatientController {

    @Autowired
    private PatientDao patientDao;

    // Save a new patient
    @PostMapping(value = "/savePatient")
    public List<Patient> savePatientDao(@RequestBody List<Patient> patient) {
        return patientDao.savePatientDao(patient);
    }

    // Get a patient by ID
    @GetMapping(value = "/getPatientById/{id}")
    public Patient getPatientByIdDao(@PathVariable Integer id) {
        return patientDao.getPatientByIdDao(id);
    }

    // Get all patients
    @GetMapping(value = "/getAllPatientsDao")
    public List<Patient> getAllPatientsDao() {
        return patientDao.getAllPatientsDao();
    }

    // Update an existing patient
    @PostMapping(value = "/updatePatient/{id}")
    public Patient updatePatientDao(@PathVariable Integer id, @RequestBody Patient updatePatient) {
        return patientDao.updatePatientDao(id, updatePatient);
    }

    // Delete a patient by ID
    @DeleteMapping(value = "/deletePatient/{id}")
    public Patient deletePatientDao(@PathVariable Integer id) {
        return patientDao.deletePatientDao(id);
    }

    // Delete patients by full name
    @DeleteMapping(value = "/deletegetPatientsByFullName/{fullName}")
    public int deletegetPatientsByFullNameDao(@PathVariable String fullName) {
        return patientDao.deletePatientsByFullNameDao(fullName);
    }
}
