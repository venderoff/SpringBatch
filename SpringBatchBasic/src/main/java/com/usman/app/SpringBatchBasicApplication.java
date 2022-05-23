package com.usman.app;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableBatchProcessing
@SpringBootApplication
@ComponentScan({"com.usman.*"})
public class SpringBatchBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchBasicApplication.class, args);
	}

}
