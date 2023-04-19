package com.example.musala;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MusalaDroneApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusalaDroneApplication.class, args);
	}

}
