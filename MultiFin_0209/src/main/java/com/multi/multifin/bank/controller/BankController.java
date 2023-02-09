package com.multi.multifin.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bank")
@Controller
public class BankController {

	@GetMapping("/bankCard")
	public String bankCard() {
		return "bank/bankCard";
	}
	
	@GetMapping("/bankDeposit")
	public String bankDeposit() {
		return "bank/bankDeposit";
	}
	
	@GetMapping("/bankDetail")
	public String bankDetail() {
		return "bank/bankDetail";
	}
	
	@GetMapping("/bankFind")
	public String bankFind() {
		return "bank/bankFind";
	}
	
	@GetMapping("/bankLoan")
	public String bankLoan() {
		return "bank/bankLoan";
	}

	@GetMapping("/bankMain")
	public String bankMain() {
		return "bank/bankMain";
	}
	
}
