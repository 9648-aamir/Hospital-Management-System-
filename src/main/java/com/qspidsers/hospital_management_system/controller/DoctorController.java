package com.qspidsers.hospital_management_system.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.qspidsers.hospital_management_system.dao.DoctorDao;
import com.qspidsers.hospital_management_system.entity.Doctor;

@RestController
@RequestMapping(value = "/doctorController")
public class DoctorController {

    @Autowired
    private DoctorDao doctorDao;

    // Save a new doctor
    @PostMapping(value = "/saveDoctor")
    public List<Doctor> saveDoctorController(@RequestBody List<Doctor> doctor) {
        return doctorDao.saveDoctorDao(doctor);
    }

    // Get a doctor by ID
    @GetMapping(value = "/getDoctorBy/{id}")
    public Doctor getDoctorByIdController(@PathVariable Integer id) {
        return doctorDao.getDoctorByIdDao(id);
    }

    // Get all doctors
    @GetMapping(value = "/getAllDoctors")
    public List<Doctor> getAllDoctorsController() {
        return doctorDao.getAllDoctorsDao();
    }

    // Update an existing doctor
    @PostMapping(value = "/updateDoctor/{id}")
    public Doctor updateDoctorController(@PathVariable int id, @RequestBody Doctor updateDoctor) {
        return doctorDao.updateDoctorDao(id, updateDoctor);
    }

    // Delete a doctor by ID
    @DeleteMapping(value = "/deleteDoctor/{id}")
    public Doctor deleteDoctorController(@PathVariable int id) {
        return doctorDao.deleteDoctorDao(id);
    }

    // Additional methods can be implemented here
    // public Doctor getDoctorByEmailDao(String email) {
    //     return doctorDao.getDoctorByEmail(email);
    // }

    // public List<Doctor> getDoctorsBySpecializationDao(String specialization) {
    //     return doctorDao.getDoctorsBySpecialization(specialization);
    // }
}
