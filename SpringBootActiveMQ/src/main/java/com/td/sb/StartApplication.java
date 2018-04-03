package com.td.sb;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.td.sb.model.Order;
import com.td.sb.service.OrderService;

@SpringBootApplication
public class StartApplication implements ApplicationRunner{

	private static Logger log = LoggerFactory.getLogger(StartApplication.class);

    @Autowired
    private OrderService orderService;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        log.info("Spring Boot Embedded ActiveMQ Configuration Example");

        for (int i = 0; i < 5; i++){
        	int priority=i+1;
            Order myMessage = new Order(i + " - Sending JMS Message using Embedded activeMQ", new Date(),priority );
            orderService.send(myMessage);
            
        }

        log.info("Waiting for all ActiveMQ JMS Messages to be consumed");
        //TimeUnit.SECONDS.sleep(3);
        //System.exit(-1);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
}
