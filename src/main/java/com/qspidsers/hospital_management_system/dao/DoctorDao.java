package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qspidsers.hospital_management_system.entity.Doctor;
import com.qspidsers.hospital_management_system.repository.DoctorRepository;


@Repository
public class DoctorDao {

    @Autowired
    private DoctorRepository doctorRepo;

    // Save a new doctor
    public List<Doctor> saveDoctorDao(List<Doctor> doctor) {
        return doctorRepo.saveAll(doctor);
    }

    // Get a doctor by ID
    public Doctor getDoctorByIdDao(int id) {
        return doctorRepo.findById(id).orElse(null);
    }

    // Get all doctors
    public List<Doctor> getAllDoctorsDao() {
        return doctorRepo.findAll();
    }

    // Update an existing doctor
    @Transactional
    public Doctor updateDoctorDao(int id, Doctor updateDoctor) {
        Optional<Doctor> optional = doctorRepo.findById(id);

        if (optional.isPresent()) {
            Doctor doctor = optional.get();
            doctor.setFirstName(updateDoctor.getFirstName());
            doctor.setLastName(updateDoctor.getLastName());
            doctor.setContactNumber(updateDoctor.getContactNumber());
            doctor.setEmail(updateDoctor.getEmail());
//            doctor.setDepartment(updateDoctor.getDepartment());
            doctor.setSpecialization(updateDoctor.getSpecialization());

            return doctorRepo.save(doctor);
        } else {
            return null;
        }
    }

    // Delete a doctor by ID
    public Doctor deleteDoctorDao(int id) {
        Optional<Doctor> optional = doctorRepo.findById(id);

        if (optional.isPresent()) {
            Doctor doctor = optional.get();
            doctorRepo.deleteById(id);
            return doctor;
        } else {
            return null;
        }
    }

    // Additional methods can be implemented here
    // public Doctor getDoctorByEmailDao(String email) {
    //     return doctorRepo.findByEmail(email);
    // }

    // public List<Doctor> getDoctorsBySpecializationDao(String specialization) {
    //     return doctorRepo.findBySpecialization(specialization);
    // }
}
