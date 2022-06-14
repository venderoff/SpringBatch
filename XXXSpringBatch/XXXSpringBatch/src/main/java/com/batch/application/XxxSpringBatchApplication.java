package com.batch.application;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.batch.*","com.batch.writer","com.batch.reader","com.batch.processor"})
@EnableBatchProcessing
@SpringBootApplication
public class XxxSpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(XxxSpringBatchApplication.class, args);
	}

}
