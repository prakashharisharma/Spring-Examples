package com.td.sb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Controller
public class IndexController {

	@Autowired
	private ResourceUrlProvider resourceUrlProvider;
	
	@GetMapping("/")
	public String index() {
		
		String cs = this.resourceUrlProvider.getForLookupPath("/css/style.css");

		System.out.println("IndexController.index()" + cs);
		
		return "index";
	}
	
}
