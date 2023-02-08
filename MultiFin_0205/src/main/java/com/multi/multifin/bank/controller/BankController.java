package com.multi.multifin.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bank")
@Controller
public class BankController {

	@RequestMapping("/bankCard")
	public String bankCard() {
		return "bank/bankCard";
	}
	
	@RequestMapping("/bankDeposit")
	public String bankDeposit() {
		return "bank/bankDeposit";
	}
	
	@RequestMapping("/bankDetail")
	public String bankDetail() {
		return "bank/bankDetail";
	}
	
	@RequestMapping("/bankFind")
	public String bankFind() {
		return "bank/bankFind";
	}
	
	@RequestMapping("/bankLoan")
	public String bankLoan() {
		return "bank/bankLoan";
	}

	@RequestMapping("/bankMain")
	public String bankMain() {
		return "bank/bankMain";
	}
	
}
