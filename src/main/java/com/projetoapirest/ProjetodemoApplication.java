package com.projetoapirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class}) // DESABILITA o SECURITY
public class ProjetodemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetodemoApplication.class, args);
	}

}
