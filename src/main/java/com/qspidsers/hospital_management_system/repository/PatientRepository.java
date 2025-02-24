package com.qspidsers.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.qspidsers.hospital_management_system.entity.Patient;




public interface PatientRepository extends JpaRepository<Patient, Integer>{

	@Query("delete FROM Patient p WHERE CONCAT(p.firstName, ' ', p.lastName) = :fullName")
	
	@Modifying
	@Transactional
	int deleteByPatientFullName(@Param("fullName") String fullName);

}
