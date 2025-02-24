package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Appointment;
import com.qspidsers.hospital_management_system.repository.AppointmentRepository;

@Repository
public class AppointmentDao {

	@Autowired
	private AppointmentRepository appointmentRepo;
	
	public List<Appointment> saveAppointmentDao(List<Appointment> appointment) {
		return appointmentRepo.saveAll(appointment);
	}
	
	public Appointment UpdateAppointmentDao(int id,Appointment updateAppointment) {
		
		Optional<Appointment> optional=appointmentRepo.findById(id);
		
		if(optional.isPresent()) {
			Appointment appointment=optional.get();
			
			appointment.setAppointmentDate(updateAppointment.getAppointmentDate());
			appointment.setDoctor(updateAppointment.getDoctor());
			appointment.setPatient(updateAppointment.getPatient());
			appointment.setPurpose(updateAppointment.getPurpose());
			appointment.setStatus(updateAppointment.getStatus());
			
			return appointmentRepo.save(appointment);
		}else {
			return null;
		}
	}
	
	public List<Appointment> getAllAppointmentDao() {
		return appointmentRepo.findAll();
	}
	
	public Appointment getAppointmentByIdDao(int id) {
		return appointmentRepo.findById(id).orElse(null);
	}
	
	public Appointment deleteAppointmentByIdDao(int id) {
		
		Optional<Appointment> optional=appointmentRepo.findById(id);
		
		if(optional.isPresent()) {
			appointmentRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
