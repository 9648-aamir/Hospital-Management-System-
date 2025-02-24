package com.qspidsers.hospital_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Prescription {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prescriptionId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String dosage;

    @Column(nullable = false)
    private String frequency;

    @OneToOne
    @JoinColumn(name = "medicalRecordId")
    private MedicalRecords medicalRecords;
}