package com.lti.assigmentproducer.RepositoryTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.lti.assigmentproducer.model.Bank;
import com.lti.assigmentproducer.repository.BankRepository;

import java.util.*;

@DataJpaTest
  class RepositoryTest {
	
	@Autowired
	private BankRepository bankrepo;
	
	@Autowired
    private TestEntityManager testEntityManager;
	
	@Test
	 void createnewcustomer() {
		Bank bank= new Bank();
		Bank saveindb=testEntityManager.persist(bank);
		Bank getfromdb=bankrepo.findById(saveindb.getId()).get();
		assertThat(getfromdb).isEqualTo(saveindb);
	}
	
	@Test
	 void getcustomerbyid() {
		Bank bank=new Bank();
		bank.setName("Pooja");
		bank.setAge(18);
		bank.setAddress("Kalina");
		bank.setTypeofacc("Savings");
		Bank saveindb=testEntityManager.persist(bank);
		Bank getfromdb=bankrepo.findById(bank.getId()).get();
		assertThat(getfromdb).isEqualTo(saveindb);
	}
	
	@Test
	 void getallcustomer() {
		Bank bank1=new Bank();
		bank1.setName("Pooja");
		bank1.setAge(18);
		bank1.setAddress("Kalina");
		bank1.setTypeofacc("Savings");
		
		Bank bank2=new Bank();
		bank2.setName("Omkar");
		bank2.setAge(18);
		bank2.setAddress("Vakola");
		bank2.setTypeofacc("Savings");
		
		testEntityManager.persist(bank1);
		testEntityManager.persist(bank2);
		
		List<Bank> customerlist=bankrepo.findAll();
		assertEquals(2, customerlist.size());
		
	}
	
	@Test
	 void deletebyid() {
		Bank bank1=new Bank();
		bank1.setName("Pooja");
		bank1.setAge(18);
		bank1.setAddress("Kalina");
		bank1.setTypeofacc("Savings");
		
		Bank bank2=new Bank();
		bank2.setName("Omkar");
		bank2.setAge(18);
		bank2.setAddress("Vakola");
		bank2.setTypeofacc("Savings");
		
		Bank bank=testEntityManager.persist(bank1);
		testEntityManager.persist(bank2);
		
		testEntityManager.remove(bank);
		
		List<Bank> customerlist=bankrepo.findAll();
		assertEquals(1, customerlist.size());
	}
	
	
	
	
	 
}
