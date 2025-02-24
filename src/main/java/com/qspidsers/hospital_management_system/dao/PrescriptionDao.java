package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Prescription;
import com.qspidsers.hospital_management_system.repository.PrescriptionRepository;

@Repository
public class PrescriptionDao {

	@Autowired
	private PrescriptionRepository prescriptionRepo;
	
	public List<Prescription> savePrescriptionDao(List<Prescription> prescription) {
		return prescriptionRepo.saveAll(prescription);
	}
	
	public Prescription updatePrescriptionDao(int id, Prescription updatePrescription) {
		Optional<Prescription> optional=prescriptionRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Prescription prescription=optional.get();
			
			prescription.setDate(updatePrescription.getDate());
			prescription.setDosage(updatePrescription.getDosage());
			prescription.setFrequency(updatePrescription.getFrequency());
			prescription.setMedicalRecords(updatePrescription.getMedicalRecords());
			
			return prescriptionRepo.save(prescription);
		}else {
			return null;
		}
		
	}
	
	public List<Prescription> getAllPrescriptionDao(){
		return prescriptionRepo.findAll();
	}
	
	public Prescription getPrescriptionByIdDao(int id) {
		return prescriptionRepo.findById(id).orElse(null);
	}
	
	public Prescription deletePrescriptionByIdDao(int id) {
		Optional<Prescription> optional=prescriptionRepo.findById(id);
		
		if(optional.isPresent()) {
			prescriptionRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
