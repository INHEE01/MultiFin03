package com.multi.multifin.law.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/law")
@Controller
public class LawController {

	@RequestMapping("/lawSearch")
	public String lawSearch() {
		return "law/lawSearch";
	}
	
}
