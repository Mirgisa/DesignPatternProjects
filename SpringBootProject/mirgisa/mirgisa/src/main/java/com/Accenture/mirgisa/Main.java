package com.Accenture.mirgisa;

import jakarta.persistence.GeneratedValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(basePackages = "com.Accenture.mirgisa")
public class Main {

	public static void main(String[] args) {

		SpringApplication.run(Main.class, args);
		//SpringApplication.run(Customer.class, args);
	}


}
