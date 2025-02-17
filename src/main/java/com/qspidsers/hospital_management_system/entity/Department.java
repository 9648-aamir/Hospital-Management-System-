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
public class Department {

	@Id
	private int id;
	private String name;
	private String location;
	private String head;
	
	@OneToMany(mappedBy = "department")
	private List<Doctor> doctors;
}
