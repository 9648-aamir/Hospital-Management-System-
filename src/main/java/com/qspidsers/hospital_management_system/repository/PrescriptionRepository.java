package com.qspidsers.hospital_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspidsers.hospital_management_system.entity.Prescription;

public interface PrescriptionRepository extends JpaRepository<Prescription, Integer>{

}
