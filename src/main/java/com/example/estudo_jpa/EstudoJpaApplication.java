package com.example.estudo_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class EstudoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstudoJpaApplication.class, args);
	}

}
