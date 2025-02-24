package com.qspidsers.hospital_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspidsers.hospital_management_system.entity.Payment;
import com.qspidsers.hospital_management_system.repository.PaymentRepository;

@Repository
public class PaymentDao {

	@Autowired
	private PaymentRepository paymentRepo;
	
	public List<Payment> savePaymentDao(List<Payment> payment) {
		return paymentRepo.saveAll(payment);
	}
	
	public Payment updatePaymentDao(int id,Payment updatePayment) {
		
		Optional<Payment> optional=paymentRepo.findById(id);
		
		if(optional.isPresent()) {
			
			Payment payment=optional.get();
			
			payment.setAmount(updatePayment.getAmount());
			payment.setBills(updatePayment.getBills());
			payment.setPaymentDate(updatePayment.getPaymentDate());
			payment.setPaymentMethod(updatePayment.getPaymentMethod());
			
			return paymentRepo.save(payment);
		}else {
			return null;
		}
	}
	
	public List<Payment> getAllPaymentDao() {
		return paymentRepo.findAll();
	}
	
	public Payment getPaymentByIdDao(int id) {
		return paymentRepo.findById(id).orElse(null);
	}
	
	public Payment deletePaymentByIdDao(int id) {
		
		Optional<Payment> optional=paymentRepo.findById(id);
		
		if(optional.isPresent()) {
			paymentRepo.deleteById(id);
			return optional.get();
		}else {
			return null;
		}
	}
}
