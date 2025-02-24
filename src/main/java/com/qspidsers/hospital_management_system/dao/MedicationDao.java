package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Medication;
import com.qspidsers.hospital_management_system.repository.MedicationRepository;

@Repository
public class MedicationDao {

	@Autowired
	private MedicationRepository medicationRepo;
	
	public List<Medication> saveMedicationDao(List<Medication> medication) {
		return medicationRepo.saveAll(medication);
	}
	
	public Medication updateMedicationDao(int id, Medication updateMedication) {
		
		Optional<Medication> optional=medicationRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Medication medication=optional.get();
			
			medication.setDescription(updateMedication.getDescription());
			medication.setManufacturer(updateMedication.getManufacturer());
			medication.setName(updateMedication.getName());
			medication.setPrescription(updateMedication.getPrescription());
			medication.setPrice(updateMedication.getPrice());
			
			return medicationRepo.save(medication);
		}else {
			return null;
		}
	}
	
	public List<Medication> getAllMedicationDao() {
		return medicationRepo.findAll();
	}
	
	public Medication getMedicationByIdDao(int id) {
		return medicationRepo.findById(id).orElse(null);
	}
	
	public Medication deleteMedicationById(int id) {
		Optional<Medication> optional=medicationRepo.findById(id); 
		
		if(optional.isPresent()) {
			medicationRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
