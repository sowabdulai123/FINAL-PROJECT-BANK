package com.peopleshores.bankSank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.peopleshores.bankSank.repos")
public class BankSankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankSankApplication.class, args);

	}

}
