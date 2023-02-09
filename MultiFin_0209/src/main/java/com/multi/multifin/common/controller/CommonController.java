package com.multi.multifin.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/common")
@Controller
public class CommonController {

	@GetMapping("/searchTotal")
	public String searchTotal() {
		return "common/searchTotal";
	}
	
	@GetMapping("/sitemap")
	public String sitemap() {
		return "common/sitemap";
	}
	
}
