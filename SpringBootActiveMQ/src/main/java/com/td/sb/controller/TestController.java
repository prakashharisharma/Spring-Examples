package com.td.sb.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.td.sb.model.Order;
import com.td.sb.service.OrderService;

@RestController
public class TestController {

    @Autowired
    private OrderService orderService;
	
	@GetMapping("/test")
	public String sendMessage() {
		
		 Order order = new Order(" - New Order", new Date(),1 );
		
		 orderService.send(order);
		 
		return "Message Sent !!!";
		
	}
}
