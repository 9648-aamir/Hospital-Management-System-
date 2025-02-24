package com.qspidsers.hospital_management_system.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qspidsers.hospital_management_system.dao.PaymentDao;
import com.qspidsers.hospital_management_system.entity.Payment;

@RestController
@RequestMapping("/paymentController")
public class PaymentController {

	@Autowired
	private PaymentDao paymentDao;
	
	@PostMapping("/savePayment")
	public List<Payment> savePaymentDao(@RequestBody	List<Payment> payment) {
		return paymentDao.savePaymentDao(payment);
	}
	
	@PostMapping("/updatePayment/{id}")
	public Payment updatePaymentDao(@PathVariable int id,@RequestBody Payment updatePayment) {
		return paymentDao.updatePaymentDao(id, updatePayment);
	}
	
	@GetMapping("/getAllPayment")
	public List<Payment> getAllPaymentDao() {
		return paymentDao.getAllPaymentDao();
	}
	
	@GetMapping("/getPaymentById/{id}")
	public Payment getPaymentByIdDao(@PathVariable(name="id") int id) {
		return paymentDao.getPaymentByIdDao(id);
	}
	
	@DeleteMapping("/deletePaymentById{id}")
	public Payment deletePaymentByIdDao(@PathVariable(name="id") int id) {
	    return paymentDao.deletePaymentByIdDao(id);
	}
}
