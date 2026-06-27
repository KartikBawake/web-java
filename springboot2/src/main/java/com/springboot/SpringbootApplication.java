package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.DTO.TransactionDTO;
import com.Service.TransactionServiceInterface;

@EntityScan(basePackages = {"com.Entity"})
@EnableJpaRepositories(basePackages = {"com.Repository"})
@SpringBootApplication(scanBasePackages = {"com.Service"})
public class SpringbootApplication implements CommandLineRunner {

	@Autowired
	private TransactionServiceInterface transactionServiceInterface;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//		TransactionDTO dto = new TransactionDTO();
//		dto.setCompany("Visa");
//		dto.setDate("15/10/2002");
//		dto.setTime("10 o clock");
//		dto.setStatus("Failed");
//		System.out.println(dto);
//		transactionServiceInterface.addNewCard(dto);
		
//		TransactionDTO dto = transactionServiceInterface.findByCardNumber(1);
//		System.out.println(dto);
		
//		List<TransactionDTO> dtoList = transactionServiceInterface.findAll();
//		for(TransactionDTO dto: dtoList) {
//			System.out.println(dto);
//		}
		
//		List<TransactionDTO> dtoList = transactionServiceInterface.findByCompanyAndStatus("MasterCard", "Success");
//		for(TransactionDTO dto: dtoList) {
//			System.out.println(dto);
//		}
		
	}

}
