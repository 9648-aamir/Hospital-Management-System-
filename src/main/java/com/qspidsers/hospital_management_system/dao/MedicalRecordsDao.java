package com.qspidsers.hospital_management_system.dao;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.MedicalRecords;
import com.qspidsers.hospital_management_system.repository.MedicalRecordsRepository;


@Repository
public class MedicalRecordsDao {
	
	
//	private static final Logger LOGGER = Logger.getLogger(MedicalRecordsDao.class.getName());

    @Autowired
    private MedicalRecordsRepository medicalRecordsRepo;

    // Save a single medical record
    public List<MedicalRecords> saveMedicalRecordDao(List<MedicalRecords> record) {
        return medicalRecordsRepo.saveAll(record);
    }

    // Save multiple medical records
    public List<MedicalRecords> saveMedicalAllRecordDao(List<MedicalRecords> records) {
        return medicalRecordsRepo.saveAll(records);
    }

    // Retrieve all medical records
    public List<MedicalRecords> getAllMedicalRecordDao() {
        return medicalRecordsRepo.findAll();
    }

    // Retrieve a medical record by ID
    public MedicalRecords getMedicalRecordByIdDao(int recordId) {
        return medicalRecordsRepo.findById(recordId).orElse(null);
    }

    // Retrieve a medical record by patient ID
    public MedicalRecords getMedicalRecordByPatientIdDao(int patientId) {
        return medicalRecordsRepo.findById(patientId).orElse(null);
    }

    // Retrieve a medical record by doctor ID
    public MedicalRecords getMedicalRecordByDoctorIdDao(int doctorId) {
        return medicalRecordsRepo.findById(doctorId).orElse(null);
    }

    // Update a medical record by doctor ID
   
    public MedicalRecords updateMedicalRecordByDoctorIdDao(int recordId, MedicalRecords updateRecord) {
        Optional<MedicalRecords> optional = medicalRecordsRepo.findById(recordId);
        if (optional.isPresent()) {
            MedicalRecords record = optional.get();
            record.setDate(updateRecord.getDate());
            record.setDiagnosis(updateRecord.getDiagnosis());
            record.setTreatment(updateRecord.getTreatment());
            record.setNotes(updateRecord.getNotes());
            return medicalRecordsRepo.save(record);
        }
        return null;
    }

    // Delete a medical record by ID
//    public boolean deleteMedicalRecordByIdDao(int recordId) {
//        if (medicalRecordsRepo.existsById(recordId)) {
//            medicalRecordsRepo.deleteById(recordId);
//            return true;
//        }
//        return false;
//    }

    // Delete medical records by patient's full name
    public int deleteMedicalRecordByPatientFullNameDao(String fullName) {
        return medicalRecordsRepo.deleteByPatientFullName(fullName);
    }

    // Retrieve medical records by patient's full name
    public List<MedicalRecords> getMedicalRecordByPatientFullNameDao(String fullName) {
        return medicalRecordsRepo.findByPatientFullName(fullName);
    }
}
