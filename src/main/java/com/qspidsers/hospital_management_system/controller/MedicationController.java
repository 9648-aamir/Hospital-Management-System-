package com.qspidsers.hospital_management_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.MedicationDao;
import com.qspidsers.hospital_management_system.entity.Medication;

@RestController
@RequestMapping("/medicationController")
public class MedicationController {

	@Autowired
	private MedicationDao medicationDao;
	
	@PostMapping("/saveMedication")
	public List<Medication> saveMedicationDao(@RequestBody List<Medication> medication) {
		return medicationDao.saveMedicationDao(medication);
	}
	
	@PostMapping("/updateMedication/{id}")
	public Medication updateMedicationDao(@PathVariable(name="id") int id,@RequestBody Medication updateMedication) {
	       return medicationDao.updateMedicationDao(id, updateMedication);
	}
	
	@GetMapping("/getAllMedication")
	public List<Medication> getAllMedicationDao() {
		return medicationDao.getAllMedicationDao();
	}
	
	@GetMapping("/getMedicationById/{id}")
	public Medication getMedicationByIdDao(@PathVariable(name="id") int id) {
		return medicationDao.getMedicationByIdDao(id);
	}
	
	@DeleteMapping("/deleteMedicationById/{id}")
	public Medication deleteMedicationByIdDao(@PathVariable(name="id") int id) {
		return medicationDao.deleteMedicationById(id);
	}
}
