package com.td.sb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.td.sb.repo.AccountRepository;
import com.td.sb.repo.RemoteAccountRepository;

@SpringBootApplication
@EnableEurekaClient
public class Start_Application {

	public static final String ACCOUNTS_SERVICE_URL = "http://ACCOUNTS-MICROSERVICE";
	
	public static void main(String[] args) {
		SpringApplication.run(Start_Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public AccountRepository accountRepository(){
		return new RemoteAccountRepository(ACCOUNTS_SERVICE_URL);
	}
	
}
