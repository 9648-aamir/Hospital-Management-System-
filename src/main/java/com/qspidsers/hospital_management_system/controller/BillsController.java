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

import com.qspidsers.hospital_management_system.dao.BillsDao;
import com.qspidsers.hospital_management_system.entity.Bills;

@RestController
@RequestMapping("/billsController")
public class BillsController {

	@Autowired
	private BillsDao billsDao;
	
	@PostMapping("/saveBills")
	public List<Bills> saveBillsDao(@RequestBody List<Bills> bills) {
		return billsDao.saveBillsDao(bills);
	}
	
	@PostMapping("/updateBills/{id}")
	public Bills updateBillsDao(@PathVariable(name="id") int id,@RequestBody Bills updateBills) {
		return billsDao.updateBillsDao(id, updateBills);
	}
	
	@GetMapping("/getAllBills")
	public List<Bills> getAllBillsDao() {
		return billsDao.getAllBillsDao();
	}
	
	@GetMapping("/getBillsById/{id}")
	public Bills getBillsByIdDao(@PathVariable(name="id") int id) {
		return billsDao.getBillsByIdDao(id);
	}
	
	@DeleteMapping("/deleteBillsById")
	public Bills deleteBillsByIdDao(@PathVariable(name="id") int id) {
		return billsDao.deleteBillsByIdDao(id);
	}
}
