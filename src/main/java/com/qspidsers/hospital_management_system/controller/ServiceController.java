package com.qspidsers.hospital_management_system.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.ServiceDao;
import com.qspidsers.hospital_management_system.entity.Service;

@RestController
@RequestMapping("/serviceController")
public class ServiceController {

	@Autowired
	private ServiceDao serviceDao;
	
	@PostMapping("/saveService")
	public List<Service> saveServiceDao(@RequestBody  List<Service> service) {
		return serviceDao.saveServiceDao(service);
	}
	
	@PostMapping("/updateService/{id}")
	public Service updateServiceDao(@PathVariable(name="id") int id,@RequestBody Service updateService) {
		return serviceDao.updateServiceDao(id, updateService);
	}
	
	@GetMapping("/getAllService")
	public List<Service> getAllServiceDao(){
		return serviceDao.getAllServiceDao();
	}
	
	@GetMapping("/getServiceById/{id}")
	public Service getServiceByIdDao(@PathVariable(name="id") int id) {
		return serviceDao.getServiceByIdDao(id);
	}
	
	@DeleteMapping("/deleteServiceById/{id}")
	public Service deleteServiceByIdDao(@PathVariable(name="id") int id) {
		return serviceDao.deleteServiceByIdDao(id);
	}
}
