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
	private BankCardService cardSerive;
	
	@GetMapping("/bankCard")
	public String bankCard(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("은행 카드상품 페이지 요청 성공");
		log.info("체크카드 전체 요청");
		List<BankCreditCard> creditList = cardSerive.selectCreditList();
		model.addAttribute("creditList", creditList);
		
		
		
		log.info("롯데카드 요청");
		List<BankCreditCard> creditLotte = cardSerive.selectCreditLotte();
		List<BankDebitCard> debitLotte = cardSerive.selectDebitLotte();
		model.addAttribute("creditLotte", creditLotte);
		model.addAttribute("debitLotte", debitLotte);
		log.info("비씨카드 요청");
		List<BankCreditCard> creditBC = cardSerive.selectCreditBC();
		List<BankDebitCard> debitBC = cardSerive.selectDebitBC();
		model.addAttribute("creditBC", creditBC);
		model.addAttribute("debitBC", debitBC);
		log.info("삼성카드 요청");
		List<BankCreditCard> creditSamsung = cardSerive.selectCreditSamsung();
		List<BankDebitCard> debitSamsung = cardSerive.selectDebitSamsung();
		model.addAttribute("creditSamsung", creditSamsung);
		model.addAttribute("debitSamsung", debitSamsung);
		log.info("신한카드 요청");
		List<BankCreditCard> creditSinhan = cardSerive.selectCreditSinhan();
		List<BankDebitCard> debitSinhan = cardSerive.selectDebitSinhan();
		model.addAttribute("creditSinhan", creditSinhan);
		model.addAttribute("debitSinhan", debitSinhan);
		log.info("우리카드 요청");
		List<BankCreditCard> creditWoori = cardSerive.selectCreditWoori();
		List<BankDebitCard> debitWoori = cardSerive.selectDebitWoori();
		model.addAttribute("creditWoori", creditWoori);
		model.addAttribute("debitWoori", debitWoori);
		log.info("하나카드 요청");
		List<BankCreditCard> creditHana = cardSerive.selectCreditHana();
		List<BankDebitCard> debitHana = cardSerive.selectDebitHana();
		model.addAttribute("creditHana", creditHana);
		model.addAttribute("debitHana", debitHana);
		log.info("현대카드 요청");
		List<BankCreditCard> creditHyundai = cardSerive.selectCreditHyundai();
		List<BankDebitCard> debitHyundai = cardSerive.selectDebitHyundai();
		model.addAttribute("creditHyundai", creditHyundai);
		model.addAttribute("debitHyundai", debitHyundai);
		log.info("국민카드 요청");
		List<BankCreditCard> creditKb = cardSerive.selectCreditKb();
		List<BankDebitCard> debitKb = cardSerive.selectDebitKb();
		model.addAttribute("creditKb", creditKb);
		model.addAttribute("debitKb", debitKb);
		
		
		log.info("카드 테이블 요청");
		log.info("신용카드 전체 요청");
		int page = 1;
		Map<String, String> searchMap = new HashMap<>();
		try {
			String searchValue = paramMap.get("searchValue");
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = paramMap.get("searchType");
				searchMap.put(searchType, searchValue);
			}else {
				paramMap.put("searchType", "all");
			}
			page = Integer.parseInt(paramMap.get("page"));
		} catch (Exception e) {
		}
		
		int debitCount = 24;
		PageInfo pageInfo = new PageInfo(page, 12, debitCount, 10);
		List<BankDebitCard> debitList = cardSerive.selectDebitList(pageInfo, searchMap);
		model.addAttribute("debitList", debitList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
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
