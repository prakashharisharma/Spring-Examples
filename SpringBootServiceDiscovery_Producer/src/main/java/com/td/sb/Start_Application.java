package com.td.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class Start_Application {

	public static void main(String[] args) {
		SpringApplication.run(Start_Application.class, args);
	}
}
