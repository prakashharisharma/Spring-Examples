package com.td.sb.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.td.sb.model.User;

@Controller
public class FormController {

	@GetMapping(value = "/")
	public String viewLogin(Map<String, Object> model) {
		User user = new User();
		model.put("userForm", user);
		return "LoginForm";
	}

	@PostMapping(value = "/login")
	public String doLogin(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult,
			Map<String, Object> model) {

		if (bindingResult.hasErrors()) {
			return "LoginForm";
		}

		return "LoginSuccess";
	}
}