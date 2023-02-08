package com.multi.multifin.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {

	@RequestMapping("/homeAuction")
	public String homeAuction() {
		return "home/homeAuction";
	}
	
	@RequestMapping("/homeBlue")
	public String homeBlue() {
		return "home/homeBlue";
	}
	
	@RequestMapping("/homeMain")
	public String homeMain() {
		return "home/homeMain";
	}
	
	@GetMapping("/homeSell")
	public String homeSell() {
		return "home/homeSell";
	}
	
	@GetMapping("/homeSellDetial")
	public String homeSellDetial() {
		return "home/homeSellDetial";
	}

}
