package com.qspidsers.hospital_management_system.dao;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Service;
import com.qspidsers.hospital_management_system.repository.ServiceRepository;

@Repository
public class ServiceDao {

	@Autowired
	private ServiceRepository serviceRepo;
	
	public List<Service> saveServiceDao(List<Service> service) {
		return serviceRepo.saveAll(service);
	}
	
	public Service updateServiceDao(int id,Service updateService) {
		Optional<Service> optional=serviceRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Service service=optional.get();
			
			service.setCost(updateService.getCost());
			service.setDescription(updateService.getDescription());
			service.setName(updateService.getName());
			
			return serviceRepo.save(service);
		}else {
			return null;
		}
	}
	
	public List<Service> getAllServiceDao(){
		return serviceRepo.findAll();
	}
	
	public Service getServiceByIdDao(int id) {
		return serviceRepo.findById(id).orElse(null);
	}
	
	public Service deleteServiceByIdDao(int id) {
		Optional<Service> optinal =serviceRepo.findById(id);
		
		if(optinal.isPresent()) {
			serviceRepo.deleteById(id);
			return optinal.get();
		}else {
			return null;
		}
		
	}
}
