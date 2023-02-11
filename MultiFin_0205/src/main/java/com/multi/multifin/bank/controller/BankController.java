package com.multi.multifin.bank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.bank.model.service.BankCardService;
import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;
import com.multi.multifin.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/bank")
@Controller
public class BankController {

	@Autowired
	private BankCardService cardService;
	
	@GetMapping("/bankCard")
	public String bankCard(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("은행 카드상품 페이지 요청 성공");
		
		log.info("롯데카드 요청");
		List<BankCreditCard> creditLotte = cardService.selectCreditLotte();
		List<BankDebitCard> debitLotte = cardService.selectDebitLotte();
		model.addAttribute("creditLotte", creditLotte);
		model.addAttribute("debitLotte", debitLotte);
		log.info("비씨카드 요청");
		List<BankCreditCard> creditBC = cardService.selectCreditBC();
		List<BankDebitCard> debitBC = cardService.selectDebitBC();
		model.addAttribute("creditBC", creditBC);
		model.addAttribute("debitBC", debitBC);
		log.info("삼성카드 요청");
		List<BankCreditCard> creditSamsung = cardService.selectCreditSamsung();
		List<BankDebitCard> debitSamsung = cardService.selectDebitSamsung();
		model.addAttribute("creditSamsung", creditSamsung);
		model.addAttribute("debitSamsung", debitSamsung);
		log.info("신한카드 요청");
		List<BankCreditCard> creditSinhan = cardService.selectCreditSinhan();
		List<BankDebitCard> debitSinhan = cardService.selectDebitSinhan();
		model.addAttribute("creditSinhan", creditSinhan);
		model.addAttribute("debitSinhan", debitSinhan);
		log.info("우리카드 요청");
		List<BankCreditCard> creditWoori = cardService.selectCreditWoori();
		List<BankDebitCard> debitWoori = cardService.selectDebitWoori();
		model.addAttribute("creditWoori", creditWoori);
		model.addAttribute("debitWoori", debitWoori);
		log.info("하나카드 요청");
		List<BankCreditCard> creditHana = cardService.selectCreditHana();
		List<BankDebitCard> debitHana = cardService.selectDebitHana();
		model.addAttribute("creditHana", creditHana);
		model.addAttribute("debitHana", debitHana);
		log.info("현대카드 요청");
		List<BankCreditCard> creditHyundai = cardService.selectCreditHyundai();
		List<BankDebitCard> debitHyundai = cardService.selectDebitHyundai();
		model.addAttribute("creditHyundai", creditHyundai);
		model.addAttribute("debitHyundai", debitHyundai);
		log.info("국민카드 요청");
		List<BankCreditCard> creditKb = cardService.selectCreditKb();
		List<BankDebitCard> debitKb = cardService.selectDebitKb();
		model.addAttribute("creditKb", creditKb);
		model.addAttribute("debitKb", debitKb);
		
		
		log.info("카드 테이블 요청");
		log.info("신용카드 전체 요청");
		int pageDebit = 1;
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				paramMap.put("companyNm", searchValue);
			}else {
			}
			pageDebit = Integer.parseInt(paramMap.get("pageDebit"));
		} catch (Exception e) {
		}
		
		try {
			String check = paramMap.getOrDefault("check", "0");
			model.addAttribute("check",check);
		} catch (Exception e) {
		}
		
		int debitCount = cardService.getDebitCount(paramMap);
		PageInfo pageDebitInfo = new PageInfo(pageDebit, 5, debitCount, 12);
		List<BankDebitCard> debitList = cardService.selectDebitList(pageDebitInfo, paramMap);
		model.addAttribute("debitList", debitList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDebitInfo", pageDebitInfo);
		
		
		log.info("체크카드 전체 요청");
		int pageCredit = 1;
		try {
			pageCredit = Integer.parseInt(paramMap.get("pageCredit"));
		} catch (Exception e) {
		}
		int creditCount = cardService.getCreditCount(paramMap);
		PageInfo pageCreditInfo = new PageInfo(pageCredit, 5, creditCount, 12);
		List<BankCreditCard> creditList = cardService.selectCreditList(pageCreditInfo, paramMap);
		model.addAttribute("creditList", creditList);
		model.addAttribute("pageCreditInfo", pageCreditInfo);
		
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
