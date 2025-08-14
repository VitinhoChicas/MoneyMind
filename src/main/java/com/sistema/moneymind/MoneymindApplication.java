package com.sistema.moneymind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@ComponentScan(basePackages =  "com.sistema.moneymind")
@EntityScan(basePackages = {"com.sistema.moneymind.domains", "com.sistema.moneymind.domains.enums"})
@EnableJpaRepositories(basePackages =  "com.sistema.moneymind.repositories")
@SpringBootApplication
public class MoneymindApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoneymindApplication.class, args);
	}

}
