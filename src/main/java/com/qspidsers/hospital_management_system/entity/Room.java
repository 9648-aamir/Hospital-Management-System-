package com.qspidsers.hospital_management_system.entity;

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
public class Room {
    @Id
    private int roomId; 
    private int roomNumber;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}