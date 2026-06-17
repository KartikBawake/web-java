package com.Service;

import java.util.List;

import com.DTO.TransactionDTO;

public interface TransactionServiceInterface {

	public TransactionDTO findByCardNumber(int cardNumber);
	public List<TransactionDTO> findAll();
	public void addNewCard(TransactionDTO dto);
	
}
