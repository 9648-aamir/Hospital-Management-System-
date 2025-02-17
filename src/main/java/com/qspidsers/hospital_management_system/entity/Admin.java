package com.qspidsers.hospital_management_system.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin {

	@Id
	private int id;
	private String name;
	private String email;
	private long phoneNumber;
	private String role;         //e.g-> like manager etc
	
	@OneToMany(mappedBy = "admin")
	private List<Appointment> appointments;
	
	@OneToMany(mappedBy = "admin")
	private List<Doctor> doctors;
	
}
