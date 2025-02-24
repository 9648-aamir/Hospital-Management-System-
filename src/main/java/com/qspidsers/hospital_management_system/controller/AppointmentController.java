package com.qspidsers.hospital_management_system.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.AppointmentDao;
import com.qspidsers.hospital_management_system.entity.Appointment;

import ch.qos.logback.core.rolling.helper.FileStoreUtil;

@RestController
@RequestMapping("/appointmentController")
@CrossOrigin(value = "http://localhost:8181")
public class AppointmentController {

	@Autowired
	private AppointmentDao  appointmentDao;
	
	@PostMapping("/saveAppointment")
	public List<Appointment> saveAppointmentDao(@RequestBody List<Appointment> appointment) {
		return appointmentDao.saveAppointmentDao(appointment);
	}
	
	@PostMapping("/UpdateAppointment/{id}")
   public Appointment UpdateAppointmentDao(@PathVariable(name="id") int id,@RequestBody Appointment updateAppointment) {
		return appointmentDao.UpdateAppointmentDao(id, updateAppointment);
	}
	
	@GetMapping("/getAllAppointment")
	public List<Appointment> getAllAppointmentDao() {
		return appointmentDao.getAllAppointmentDao();
	}
	
	@GetMapping("/getAppointmentById/{id}")
	public Appointment getAppointmentByIdDao(@PathVariable(name="id") int id) {
		return appointmentDao.getAppointmentByIdDao(id);
	}
	
	@DeleteMapping("/deleteAppointmentById")
	public Appointment deleteAppointmentByIdDao(@PathVariable(name="id") int id) {
		return appointmentDao.deleteAppointmentByIdDao(id);
	}
}
