package com.multi.multifin.common.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.bank.model.service.BankCardService;
import com.multi.multifin.bank.model.service.BankCompanyService;
import com.multi.multifin.bank.model.service.BankDepsitSavingService;
import com.multi.multifin.bank.model.service.LoanCreditService;
import com.multi.multifin.bank.model.service.LoanMortgageService;
import com.multi.multifin.bank.model.service.LoanRentHouseService;
import com.multi.multifin.bank.model.vo.BankCreditCard;
import com.multi.multifin.bank.model.vo.BankDebitCard;
import com.multi.multifin.bank.model.vo.BankDeposit;
import com.multi.multifin.bank.model.vo.BankSaving;
import com.multi.multifin.bank.model.vo.LoanCredit;
import com.multi.multifin.bank.model.vo.LoanMortgage;
import com.multi.multifin.bank.model.vo.LoanRentHouse;
import com.multi.multifin.common.util.PageInfo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/common")
@Controller
public class CommonController {

	@Autowired
	private BankCardService cardService;
	
	@Autowired
	private BankDepsitSavingService bankbookService;
	
	@Autowired
	private LoanCreditService lcService;
	
	@Autowired
	private LoanMortgageService lmService;
	
	@Autowired
	private LoanRentHouseService lrhService;
	
	@RequestMapping("/searchTotal")
	public String searchTotal(Model model, @RequestParam("searchValue") String param, Map<String, String> paramMap) {
		log.info("통합검색 결과페이지 요청");
		model.addAttribute("searchValue", param);
		
		log.info("예금상품 전체 요청");
		int pageDeposit = 1;
		try {
			paramMap.put("korCoNm", param);
			pageDeposit = Integer.parseInt(paramMap.get("pageDeposit"));
		} catch (Exception e) {
		}
		
		int depositCount = bankbookService.getDepositCountUnique(paramMap);
		PageInfo pageDepositInfo = new PageInfo(pageDeposit, 5, depositCount, 10);
		List<BankDeposit> depositList = bankbookService.selectDepositListUnique(pageDepositInfo, paramMap);
		
		model.addAttribute("depositList", depositList);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageDepositInfo", pageDepositInfo);
		
		log.info("적금상품 전체 요청");
		int pageSaving = 1;
		try {
			pageSaving = Integer.parseInt(paramMap.get("pageSaving"));
		} catch (Exception e) {
		}
		int savingCount = cardService.getCreditCount(paramMap);
		PageInfo pageSavingInfo = new PageInfo(pageSaving, 5, savingCount, 10);
		List<BankSaving> savingList = bankbookService.selectSavingListUnique(pageSavingInfo, paramMap);
		
		model.addAttribute("savingList", savingList);
		model.addAttribute("pageSavingInfo", pageSavingInfo);
		
		log.info("개인신용대출 전체 요청");
		int pageLc = 1;
		try {
			paramMap.put("korCoNm", param);
			pageLc = Integer.parseInt(paramMap.get("pageLc"));
		} catch (Exception e) {
		}
		
		int lcCount = lcService.selectLoanCreditCountUnique(paramMap);
		PageInfo pageLcInfo = new PageInfo(pageLc, 5, lcCount, 10);
		List<LoanCredit> loanCreditList0 = lcService.selectLoanCreditListUnique(pageLcInfo, paramMap);
		model.addAttribute("loanCreditList0", loanCreditList0);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageLcInfo", pageLcInfo);
		
		log.info("주택담보대출 전체 요청");
		int pageLm = 1;
		try {
			pageLm = Integer.parseInt(paramMap.get("pagdLm"));
		} catch (Exception e) {
		}
		int lmCount = lmService.selectLoanMortgageCountUnique(paramMap);
		PageInfo pageLmInfo = new PageInfo(pageLm, 5, lmCount, 10);
		List<LoanMortgage> loanMortgageList0 = lmService.selectLoanMortgageListUnique(pageLmInfo, paramMap);
		model.addAttribute("loanMortgageList0", loanMortgageList0);
		model.addAttribute("pageLmInfo", pageLmInfo);
		
		log.info("전세자금대출 전체 요청");
		int pageLrh = 1;
		try {
			pageLrh = Integer.parseInt(paramMap.get("pageLrh"));
		} catch (Exception e) {
		}
		int lrhCount = lrhService.selectLoanRentHouseCountUnique(paramMap);
		PageInfo pageLrhInfo = new PageInfo(pageLrh, 5, lrhCount, 10);
		List<LoanRentHouse> loanRentHoustList0 = lrhService.selectLoanRentHouseListUnique(pageLmInfo, paramMap);
		model.addAttribute("loanRentHoustList0", loanRentHoustList0);
		model.addAttribute("pageLrhInfo", pageLrhInfo);
		
		
		
		log.info("신용카드 전체 요청");
		int pageDebit = 1;
		try {
				paramMap.put("companyNm", param);
			pageDebit = Integer.parseInt(paramMap.get("pageDebit"));
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
		
		return "common/searchTotal";
	}
	
	@RequestMapping("/sitemap")
	public String sitemap() {
		return "common/sitemap";
	}
	
}
