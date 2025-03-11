package com.example.AccountService;

import com.example.AccountService.Model.AccountType;
import com.example.AccountService.Model.Customer;
import com.example.AccountService.Model.SavingsAccount;
import com.example.AccountService.Repository.CustomerRepository;
import com.example.AccountService.Repository.SavingsAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.example.AccountService.Model.AccountType.Savings;

@SpringBootApplication
public class AccountServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountServiceApplication.class, args);
	}

	//Created this to generate temporary values in h2 db
	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository, SavingsAccountRepository savingsAccountRepository) {
		return (args) -> {

			Customer customer =  new Customer(null,"Test","09081234567","test12345@gmail.com", "test", "test", Savings, null);
			customer = customerRepository.save(customer);
			savingsAccountRepository.save(new SavingsAccount(null, Savings, 500.00, customer));



		};
	}

}
