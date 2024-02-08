package com.youcode.aftas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class AftasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AftasApplication.class, args);
	}

}
