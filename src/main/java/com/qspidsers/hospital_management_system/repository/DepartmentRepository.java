package com.qspidsers.hospital_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.qspidsers.hospital_management_system.entity.Department;

;


public interface DepartmentRepository extends JpaRepository<Department, Integer>{

	
	// Find Department by Name
    Optional<Department> findByDepartmentName(String departmentName);
}
