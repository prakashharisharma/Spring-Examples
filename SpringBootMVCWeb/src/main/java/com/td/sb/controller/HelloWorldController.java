package com.td.sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@GetMapping(value = "/")
	 public String hello(Model model) {
		model.addAttribute("msg", "Hello there, This message has been injected from the controller method");
		return "index";
	 }
	
	@RequestMapping("/welcome")
	public ModelAndView firstPage() {
		return new ModelAndView("welcome");
	}
	
}
