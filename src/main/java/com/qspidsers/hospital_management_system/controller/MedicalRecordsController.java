package com.qspidsers.hospital_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.MedicalRecordsDao;
import com.qspidsers.hospital_management_system.entity.MedicalRecords;
@RestController
@RequestMapping(value = "/medicalRecordsController")
//@CrossOrigin(origins = "*") 
public class MedicalRecordsController {

    @Autowired
    private MedicalRecordsDao medicalRecordsDao;

    // Save a new medical record
    @PostMapping(value = "/saveMedicalRecord")
    public List<MedicalRecords> saveMedicalRecordController(@RequestBody List<MedicalRecords> record) {
        return medicalRecordsDao.saveMedicalRecordDao(record);
    }
    


//    // Save multiple medical records
//    @PostMapping(value = "/saveMedicalAllRecord")
//    public List<MedicalRecords> saveMedicalAllRecordController(@RequestBody List<MedicalRecords> records) {
//        return medicalRecordsDao.saveMedicalAllRecordDao(records);
//    }

    // Get all medical records
    @GetMapping(value = "/getAllMedicalRecordByName")
    public List<MedicalRecords> getAllMedicalRecordByNameController() {
        return medicalRecordsDao.getAllMedicalRecordDao();
    }

    // Get a medical record by ID
    @GetMapping(value = "/getMedicalRecordById/{recordId}")
    public MedicalRecords getMedicalRecordByIdController(@PathVariable Integer recordId) {
        return medicalRecordsDao.getMedicalRecordByIdDao(recordId);
    }

    // Get a medical record by patient ID
    @GetMapping(value = "/getMedicalRecordByPatientId/{patientId}")
    public MedicalRecords getMedicalRecordByPatientIdController(@PathVariable Integer patientId) {
        return medicalRecordsDao.getMedicalRecordByPatientIdDao(patientId);
    }

    // Get a medical record by doctor ID
    @GetMapping(value = "/getMedicalRecordByDoctorId/{doctorId}")
    public MedicalRecords getMedicalRecordByDoctorIdController(@PathVariable Integer doctorId) {
        return medicalRecordsDao.getMedicalRecordByDoctorIdDao(doctorId);
    }

    // Update a medical record by doctor ID
    @PostMapping(value = "/updateMedicalRecordByDoctorId/{recordId}")
    public MedicalRecords updateMedicalRecordByDoctorIdController(@PathVariable Integer recordId, @RequestBody MedicalRecords updateRecord) {
        return medicalRecordsDao.updateMedicalRecordByDoctorIdDao(recordId, updateRecord);
    }

    // Delete a medical record by ID
//    @DeleteMapping(value = "/deleteMedicalRecordById/{recordId}")
//    public boolean deleteMedicalRecordByIdController(@PathVariable Integer recordId) {
//        return medicalRecordsDao.delete(recordId);
//    }

    // Delete medical records by patient's full name
    @DeleteMapping(value = "/deleteMedicalRecordByName/{fullName}")
    public String deleteMedicalRecordByPatientFullNameController(@RequestParam String fullName) {
        int deletedRecords = medicalRecordsDao.deleteMedicalRecordByPatientFullNameDao(fullName);
        return deletedRecords > 0 ? "Deleted " + deletedRecords + " record(s) for " + fullName : "No records found for " + fullName;
    }

    // Get medical records by patient's full name
    @GetMapping("/getMedicalRecordsByFullName/{fullName}")
    public List<MedicalRecords> getMedicalRecordsByFullNameController(@RequestParam String fullName) {
        return medicalRecordsDao.getMedicalRecordByPatientFullNameDao(fullName);
    }
}
