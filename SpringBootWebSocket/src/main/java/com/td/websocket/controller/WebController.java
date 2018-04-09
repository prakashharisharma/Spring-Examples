package com.td.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.td.websocket.model.Hello;
import com.td.websocket.model.User;

@Controller
public class WebController {
	
	@MessageMapping("/hello")
	@SendTo("/topic/hi")
	public Hello greeting(User user) throws Exception {
	    return new Hello("Hi, " + user.getName() + "!");
	}
}
