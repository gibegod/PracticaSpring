package com.practicaspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PracticaspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticaspringApplication.class, args);
	}

}
