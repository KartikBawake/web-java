package com.Service;

import java.util.List;

import com.DTO.TransactionDTO;
import com.Entity.Transaction;

public interface TransactionServiceInterface {

	public TransactionDTO findByCardNumber(int cardNumber);
	public List<TransactionDTO> findAll();
	public void addNewCard(TransactionDTO dto);
	public List<TransactionDTO> findByCompanyAndStatus(String company, String status);

	
}
