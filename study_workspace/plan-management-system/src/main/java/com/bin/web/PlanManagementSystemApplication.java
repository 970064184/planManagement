package com.bin.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class PlanManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlanManagementSystemApplication.class, args);
	}
}
