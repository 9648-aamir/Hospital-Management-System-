package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Bills;
import com.qspidsers.hospital_management_system.repository.BillsRepository;

@Repository
public class BillsDao {

	@Autowired
	private BillsRepository billsRepo;
	
	public List<Bills> saveBillsDao(List<Bills> bills) {
		return billsRepo.saveAll(bills);
	}
	
	public Bills updateBillsDao(int id, Bills updateBills) {
		
		Optional<Bills> optional=billsRepo.findById(id);
		
		if(optional.isPresent()) {
			Bills bills=optional.get();
			
			bills.setDate(updateBills.getDate());
			bills.setPatient(updateBills.getPatient());
			bills.setStatus(updateBills.getStatus());
			bills.setTotalAmount(updateBills.getTotalAmount());
		
			return billsRepo.save(bills);
		}else {
			return null;
		}
	}
	
	public List<Bills> getAllBillsDao() {
		return billsRepo.findAll();
	}
	
	public Bills getBillsByIdDao(int id) {
		return billsRepo.findById(id).orElse(null);
	}
	
	public Bills deleteBillsByIdDao(int id) {
		
		Optional<Bills> optional=billsRepo.findById(id);
		
		if(optional.isPresent()) {
			billsRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
