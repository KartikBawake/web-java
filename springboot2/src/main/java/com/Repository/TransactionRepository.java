package com.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.DTO.TransactionDTO;
import com.Entity.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

	@Query("select t from Transaction t where t.company = :company and t.status = :status")
	public List<Transaction> findByCompanyAndStatus(@Param("company")String company,@Param("status")String status);
	
}
