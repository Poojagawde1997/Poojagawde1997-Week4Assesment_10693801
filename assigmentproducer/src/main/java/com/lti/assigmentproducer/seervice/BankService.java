package com.lti.assigmentproducer.seervice;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lti.assigmentproducer.exception.ResourceNotFoundException;
import com.lti.assigmentproducer.model.Bank;
import com.lti.assigmentproducer.repository.BankRepository;

@Service
public class BankService {
	
	private static Logger logger= LoggerFactory.getLogger(BankService.class);

	@Autowired
	BankRepository bankrepo;
	
	public Bank addcustomer(Bank bank) {
		logger.info("Inside add customer in service");
		return bankrepo.save(bank);
	}
	
	public List<Bank> getallcustomer(){
		logger.info("Inside get customer in service");
		List<Bank> banklist=new ArrayList<>();
		bankrepo.findAll().forEach(b->banklist.add(b));
		return banklist;	
	}
	
	public ResponseEntity<Bank> getcustomerbyid(@PathVariable ("id") Integer id) throws ResourceNotFoundException{
		Bank bank= bankrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with id :" +id+ "not found"));
		logger.info("Inside get customer in service by id");
		return ResponseEntity.ok(bank);
	}
	
	public boolean deletebank(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
		logger.info("Inside delete customer in service");
		Bank bank=bankrepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Bank Customer with id :"+id+"not found"));
		if(bank != null) {
		bankrepo.deleteById(id);
		return true;
		}
		
		return false;
	}

public Bank updateproduct(@PathVariable ("id")Integer id,@RequestBody Bank bank) throws ResourceNotFoundException {
		
		Bank bank1=bankrepo.findById(id).orElseThrow(()->new ResourceNotFoundException("No Customer to update with id :"+id));
		bank1.setName(bank.getName());
		bank1.setAge(bank.getAge());
		bank1.setAddress(bank.getAddress());
		bank1.setTypeofacc(bank.getTypeofacc());
		logger.info("updtes user ");
		final Bank updatedbankcust = bankrepo.save(bank1);
		logger.info("Inside update customer in service by id ");
		return updatedbankcust;
		 
	}
}
