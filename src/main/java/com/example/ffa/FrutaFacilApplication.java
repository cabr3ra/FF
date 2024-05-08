package com.example.ffa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import model.TUser;

@SpringBootApplication
@EntityScan(basePackages = "model")
public class FrutaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrutaFacilApplication.class, args);
		
	}
	
	@Bean
    public void initData() {
        // Insertar usuarios hardcodeados
        TUser user1 = new TUser();
        user1.setNameUser("Nombre1");
        user1.setEmailUser("correo1@example.com");
        // Setear otros atributos según lo necesites

        TUser user2 = new TUser();
        user2.setNameUser("Nombre2");
        user2.setEmailUser("correo2@example.com");
        // Setear otros atributos según lo necesites

        // Agrega más inserciones según sea necesario
    }

}