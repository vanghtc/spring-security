package com.example.spring.secutiry.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping({"/","/home"})
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
}
