package com.example.amazonclonefront;

import controllers.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controllers")
public class AmazonCloneFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazonCloneFrontApplication.class, args);
	}

}
