package com.qspidsers.hospital_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalRecord {

	@Id 
	private Long id;
	private String diagnosis;
	private String treatment;
	private String prescription;
	private String recordDate;
	
	@ManyToOne
	@JoinColumn(name="paient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
}
