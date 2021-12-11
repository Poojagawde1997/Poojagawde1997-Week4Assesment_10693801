package com.lti.assigmentproducer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.assigmentproducer.model.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {

}
