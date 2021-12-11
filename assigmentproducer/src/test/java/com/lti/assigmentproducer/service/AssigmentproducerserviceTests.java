package com.lti.assigmentproducer.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.lti.assigmentproducer.exception.ResourceNotFoundException;
import com.lti.assigmentproducer.model.Bank;
import com.lti.assigmentproducer.repository.BankRepository;
import com.lti.assigmentproducer.seervice.BankService;

@SpringBootTest
class AssigmentproducerserviceTests {
	
	@Autowired
	private BankService bankservice;
	
	@MockBean
	private BankRepository bankrepo;

	@Test
	 void getcustomertest() {
		when(bankrepo.findAll()).thenReturn(Stream.of(new Bank (1,"Ramesh",18,"Parle","Current")).collect(Collectors.toList()));
		assertEquals(1, bankservice.getallcustomer().size());
		}

	@Test
	 void addcutomer() {
		Bank bank=new Bank(2,"Rita",25,"Mulund","Savigs");
		when(bankrepo.save(bank)).thenReturn(bank);
		assertEquals(bank, bankservice.addcustomer(bank));
	}
	
 }
