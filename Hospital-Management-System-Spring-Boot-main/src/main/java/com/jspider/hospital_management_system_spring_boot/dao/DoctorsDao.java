package com.jspider.hospital_management_system_spring_boot.dao;

import java.util.List;
import java.util.Optional;

import com.jspider.hospital_management_system_spring_boot.entity.Doctor;

public interface DoctorsDao {
	
	Doctor saveDoctorDao(Doctor doctor);
	List<Doctor> getAllDoctorDao();
	Optional<Doctor> getDoctorByIdDao(long id);
	Doctor findByEmailDao(String email);
	Doctor findByContactNumberDao(String contactNumber);
	List<Doctor> findBySpecializationDao(String specialization);
	boolean existsByEmailDao(String email);
	boolean existsByContactNumberDao(String contactNumber);
	boolean authenticateDoctorDao(Long doctorId, String password);
	void deleteDoctorById(long id);

}
