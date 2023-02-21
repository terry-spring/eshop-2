package main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	

	@RequestMapping("/")
	public String getHome() {
		return "index";
	}
	
	/*
	@GetMapping("/demo")
	public String eshop() {
		return "index";
	}

	 */

}
