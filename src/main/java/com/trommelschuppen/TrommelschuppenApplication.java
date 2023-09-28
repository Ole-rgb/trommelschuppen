package com.trommelschuppen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.trommelschuppen.user")
public class TrommelschuppenApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrommelschuppenApplication.class, args);
	}




	
}
