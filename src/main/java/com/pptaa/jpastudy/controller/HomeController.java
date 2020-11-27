package com.pptaa.jpastudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@ResponseBody
	@GetMapping("/")
	public String home() {
		return "test";
	}
	
	
}
