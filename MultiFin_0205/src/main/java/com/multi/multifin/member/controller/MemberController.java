package com.multi.multifin.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/member")
@Controller
public class MemberController {

	@RequestMapping("/forgot-password")
	public String forgotPassword() {
		return "member/forgot-password";
	}
	
	@RequestMapping("/mypage")
	public String mypage() {
		return "member/mypage";
	}
	
	@RequestMapping("/sign-in")
	public String signIn() {
		return "member/sign-in";
	}
	
	@GetMapping("/sign-up")
	public String signUp() {
		return "member/sign-up";
	}

}
