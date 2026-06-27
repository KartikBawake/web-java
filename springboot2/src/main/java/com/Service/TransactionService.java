package com.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.TransactionDTO;
import com.Entity.Transaction;
import com.Repository.TransactionRepository;

@Service
public class TransactionService implements TransactionServiceInterface {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Override
	public TransactionDTO findByCardNumber(int cardNumber) {
		
		Optional<Transaction> optCard = transactionRepository.findById(cardNumber);
		
		if(optCard.isPresent()) {
			TransactionDTO dtoTransaction = new TransactionDTO();
			BeanUtils.copyProperties(optCard.get(), dtoTransaction);
			return dtoTransaction;
		}
		else {
			return null;
		}
	}

	@Override
	public List<TransactionDTO> findAll() {
		
		Iterator<Transaction> iterTransaction = transactionRepository.findAll().iterator();
		List <TransactionDTO> dtoTransactionList = new ArrayList<TransactionDTO>();
		
		while(iterTransaction.hasNext()) {
			Transaction transaction = iterTransaction.next();
			TransactionDTO dtoTransaction = new TransactionDTO();
			BeanUtils.copyProperties(transaction, dtoTransaction);
			dtoTransactionList.add(dtoTransaction);
		}
		
		return dtoTransactionList;
	}

	@Override
	public void addNewCard(TransactionDTO dto) {
		
		Transaction transaction = new Transaction();
		BeanUtils.copyProperties(dto, transaction);
		transactionRepository.save(transaction);

	}

	@Override
	public List<TransactionDTO> findByCompanyAndStatus(String company, String status) {
		
		if(company == null || status == null) {
			return null;
		}
		else {
			Iterator<Transaction> iterTransaction = transactionRepository.findByCompanyAndStatus(company, status).iterator();
			List <TransactionDTO> dtoTransactionList = new ArrayList<TransactionDTO>();
			
			while(iterTransaction.hasNext()) {
				Transaction transaction = iterTransaction.next();
				TransactionDTO dtoTransaction = new TransactionDTO();
				BeanUtils.copyProperties(transaction, dtoTransaction);
				dtoTransactionList.add(dtoTransaction);
			}
			
			return dtoTransactionList;
			
		}
	}

}
