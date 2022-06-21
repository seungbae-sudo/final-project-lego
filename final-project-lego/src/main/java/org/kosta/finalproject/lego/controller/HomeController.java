package org.kosta.finalproject.lego.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/registerForm")
	public String registerForm() {
		return "register-form";
	}
}
