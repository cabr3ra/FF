package com.example.ffa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "model")
public class FrutaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrutaFacilApplication.class, args);
		
	}
}