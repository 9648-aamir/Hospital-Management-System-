package com.qspidsers.hospital_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;

import com.qspidsers.hospital_management_system.entity.MedicalRecords;




public interface MedicalRecordsRepository extends JpaRepository<MedicalRecords, Integer>{
	
	List<MedicalRecords> findByPatient_FirstNameAndPatient_LastName(String firstName, String lastName);
	
	
	@Query("SELECT m FROM MedicalRecords m WHERE CONCAT(m.patient.firstName, ' ', m.patient.lastName) = :fullName")
	
	
	
	@Modifying
	@Transactional
	List<MedicalRecords> findByPatientFullName(@Param("fullName") String fullName);

	@Query("DELETE FROM MedicalRecords m WHERE CONCAT(m.patient.firstName, ' ', m.patient.lastName) = :fullName")
	@Modifying
	@Transactional
    int deleteByPatientFullName(@Param("fullName") String fullName);
	
}
