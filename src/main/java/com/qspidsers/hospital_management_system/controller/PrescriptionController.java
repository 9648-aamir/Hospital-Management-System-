package com.qspidsers.hospital_management_system.controller;

import java.util.List;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.PrescriptionDao;
import com.qspidsers.hospital_management_system.entity.Prescription;

@RestController
@RequestMapping
public class PrescriptionController {
   
	@Autowired
	private PrescriptionDao prescriptionDao;
	
	@PostMapping("/savePrescription")
	public List<Prescription> savePrescriptionDao(@RequestBody List<Prescription> prescription) {
		return prescriptionDao.savePrescriptionDao(prescription);
	}
	
	@PostMapping("/updatePrescription/{id}")
	public Prescription updatePrescriptionDao(@PathVariable(name="id") int id,@RequestBody Prescription updatePrescription) {
		return prescriptionDao.updatePrescriptionDao(id, updatePrescription);
	}
	
	@GetMapping("/getAllPrescription")
	public List<Prescription> getAllPrescriptionDao(){
		return prescriptionDao.getAllPrescriptionDao();
	}
	
	@GetMapping("/getPrescriptionById/{id}")
	public Prescription getPrescriptionByIdDao(@PathVariable(name="id") int id) {
		return prescriptionDao.getPrescriptionByIdDao(id);
	}
	
	@DeleteMapping("/deletePrescriptionById/{id}")
	public Prescription deletePrescriptionByIdDao(@PathVariable(name="id") int id) {
		return prescriptionDao.deletePrescriptionByIdDao(id);
	}
}
