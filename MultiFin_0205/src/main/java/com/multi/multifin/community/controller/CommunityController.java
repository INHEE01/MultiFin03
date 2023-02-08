package com.multi.multifin.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/community")
@Controller
public class CommunityController {

	@RequestMapping("/freeList")
	public String freeList() {
		return "community/freeList";
	}
	
	@RequestMapping("/noticeList")
	public String noticeList() {
		return "community/noticeList";
	}
	
}
