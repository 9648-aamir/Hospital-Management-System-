package com.qspidsers.hospital_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Bills {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Double totalAmount;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;
}