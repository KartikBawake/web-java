package com.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	
	
}
