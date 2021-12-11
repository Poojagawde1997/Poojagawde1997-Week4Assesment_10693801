package com.lti.assigmentproducer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.assigmentproducer.exception.ResourceNotFoundException;
import com.lti.assigmentproducer.model.Bank;
import com.lti.assigmentproducer.seervice.BankService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class BankController {
	
	
	private static Logger logger=LoggerFactory.getLogger(BankController.class);
	
	@Autowired
	BankService service;
	
	@PostMapping("/addbankcustomer")
	public Bank addProduct(@RequestBody Bank bank) {
		logger.info("Inside add customer in controller");
		return service.addcustomer(bank);
	}
	        
	@GetMapping("/getbankcustomer")    
	@HystrixCommand(fallbackMethod = "getDataFallBack")
	public List<Bank> getbank(){
		logger.info("Inside get method in controller");
		return service.getallcustomer();    
	}
	
	@GetMapping("/getbankcustomer/{id}")
	public ResponseEntity<Bank> getcustomerbyid(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
		logger.info("Inside get customer by id in controller");
		return service.getcustomerbyid(id);
	}
	
	@DeleteMapping("/deletebankcustomer/{id}")
	public boolean deletebank(@PathVariable ("id") Integer id) throws ResourceNotFoundException {
		logger.info("Inside delete customer by id in controller");
		return service.deletebank(id);
	} 
	
	@PutMapping("/updatebankcustomer/{id}")
	public Bank updateproduct(@PathVariable ("id")Integer id,@RequestBody Bank bank) throws ResourceNotFoundException {
		logger.info("Inside update customer in controller with id ");
		return service.updateproduct(id, bank);
	 
	}

	
public List<Bank> getDataFallBack() {
	logger.info("Fallback method");
		List<Bank> list=new ArrayList<>();
		Bank bank = new Bank();
		bank.setId(1);
		bank.setName("fallback-name");
		bank.setAge(0);
		bank.setAddress("fallback-address");
		bank.setTypeofacc("fallback-accounttype");
		list.add(bank);
		return list;
		
	}
}
