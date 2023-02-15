package com.multi.multifin;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.multi.multifin.bank.model.service.BankCardService;
import com.multi.multifin.bank.model.service.BankCompanyService;
import com.multi.multifin.bank.model.service.BankDepsitSavingService;
import com.multi.multifin.bank.model.service.LoanCreditService;
import com.multi.multifin.bank.model.service.LoanMortgageService;
import com.multi.multifin.bank.model.service.LoanRentHouseService;
import com.multi.multifin.bank.model.vo.BankCompany;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.bank.model.vo.LoanRentHouse;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@Autowired
	private BankDepsitSavingService bankbookService;
	
	@Autowired
	private BankCompanyService companyService;
	
	@Autowired
	private LoanCreditService lcService;
	
	@Autowired
	private LoanMortgageService lmService;
	
	@Autowired
	private LoanRentHouseService lrhService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session, Map<String, String> paramMap) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		logger.info("예적금상품 요청");
		List<BankDeposit> depositList0 = bankbookService.selectDepositList();
		List<BankSaving> savingList0 = bankbookService.selectSavingList();
		List<BankCompany> logoList = companyService.selectLogoList(paramMap);
		model.addAttribute("logoList", logoList);
		
		for(BankDeposit deposit : depositList0) {
			String coName = deposit.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					deposit.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		for(BankSaving saving : savingList0) {
			String coName = saving.getKorCoNm();
			for(BankCompany logoInfo :  logoList) {
				if(logoInfo.getKorCoNm().equals(coName)) {
					saving.setLogoUrl(logoInfo.getLogoUrl());
					break;
				}
			}
		}
		model.addAttribute("depositList0", depositList0);
		model.addAttribute("savingList0", savingList0);
		
		logger.info("대출 상품 요청 성공");
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditList();
		model.addAttribute("loanCreditList0", loanCreditList0);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageList();
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseList();
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		
		return "index";
	}
}
