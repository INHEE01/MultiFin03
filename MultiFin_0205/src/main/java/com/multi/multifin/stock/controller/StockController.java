package com.multi.multifin.stock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.stock.model.service.StockPriceService;
import com.multi.multifin.stock.model.vo.ExchangeRate;
import com.multi.multifin.stock.model.vo.FundProductInfo;
import com.multi.multifin.stock.model.vo.StockPrice;
import com.multi.multifin.stock.model.vo.StockPriceIndex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/stock")
@Controller
public class StockController {
	
	@Autowired
	private StockPriceService service;
	
	@GetMapping("/stockMain")
	public String stockMainPage(Model model) {
		log.info("증권 메인 페이지 요청 성공");
		log.info("지수 정보 요청");
		StockPriceIndex kospiIndex = service.getnowStockIndex("KOSPI");
		StockPriceIndex kosdaqIndex = service.getnowStockIndex("KOSDAQ");
		model.addAttribute("kospiIndex", kospiIndex);
		model.addAttribute("kosdaqIndex", kosdaqIndex);
		
		log.info("리스트 요청");
		List<StockPrice> KOSPI = service.getKospiRankingTop();
		List<StockPrice> KOSDAQ = service.getKosdaqRankingTop();
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		
		log.info("주가동향 요청");
		StockPrice ss = service.findByNo(5930);
		StockPrice sk = service.findByNo(660);
		StockPrice hd = service.findByNo(5380);
		model.addAttribute("ss", ss);
		model.addAttribute("sk", sk);
		model.addAttribute("hd", hd);
		
		log.info("환율 테이블 요청: 원하는 국가만 가져옴");
		ExchangeRate USD = service.findExchangeRate("USD");
		log.info("-: " + USD.toString());
		ExchangeRate JPY = service.findExchangeRate("JPY(100)");
		ExchangeRate GBP = service.findExchangeRate("GBP");
		ExchangeRate HKD = service.findExchangeRate("HKD");
		ExchangeRate EUR = service.findExchangeRate("EUR");
		ExchangeRate CNH = service.findExchangeRate("CNH");
		ExchangeRate AUD = service.findExchangeRate("AUD");
		ExchangeRate SGD = service.findExchangeRate("SGD");
		ExchangeRate THB = service.findExchangeRate("THB");
		ExchangeRate CAD = service.findExchangeRate("CAD");
		model.addAttribute("USD", USD);
		model.addAttribute("JPY", JPY);
		model.addAttribute("GBP", GBP);
		model.addAttribute("HKD", HKD);
		model.addAttribute("EUR", EUR);
		model.addAttribute("CNH", CNH);
		model.addAttribute("AUD", AUD);
		model.addAttribute("SGD", SGD);
		model.addAttribute("THB", THB);
		model.addAttribute("CAD", CAD);
		
		return "stock/stockMain";
	}
	
	
	@RequestMapping("/stockList")
	public String stockList(Model model) {
		log.info("리스트 페이지 요청");
		log.info("지수 정보 요청");
		StockPriceIndex kospiIndex = service.getnowStockIndex("KOSPI");
		StockPriceIndex kosdaqIndex = service.getnowStockIndex("KOSDAQ");
		StockPriceIndex nasdaqIndex = service.getnowStockIndex("NASDAQ");
		
		model.addAttribute("kospiIndex", kospiIndex);
		model.addAttribute("kosdaqIndex", kosdaqIndex);
		model.addAttribute("nasdapIndex", nasdaqIndex);
		
		log.info("코스피/코스닥 상위랭킹 5개 정보 요청");
		List<StockPrice> kospiRanking = service.getKospiRankingTop();
		List<StockPrice> kosdaqRanking = service.getKosdaqRankingTop();
		model.addAttribute("kospiRanking", kospiRanking);
		model.addAttribute("kosdaqRanking", kosdaqRanking);
		
		
		log.info("코스피/코스닥 리스트 정보 요청");
		List<StockPrice> kospiList = service.getKospiList();
		List<StockPrice> kosdaqList = service.getKosdaqList();
		model.addAttribute("kospiList", kospiList);
		model.addAttribute("kosdaqList", kosdaqList);
		
		log.info("각 지수별 최근 6개 정보 요청");
		List<StockPriceIndex> KOSPI = service.currentStockList("KOSPI");
		List<StockPriceIndex> KOSDAQ = service.currentStockList("KOSDAQ");
		List<StockPriceIndex> NASDAQ = service.currentStockList("NASDAQ");
		
		model.addAttribute("KOSPI", KOSPI);
		model.addAttribute("KOSDAQ", KOSDAQ);
		model.addAttribute("NASDAQ", NASDAQ);
		
		return "stock/stockList";
	}
	
	@RequestMapping("/stockBuying")
	public String stockBuying() {
		return "stock/stockBuying";
	}
	
	@GetMapping("/stockFund")
	public String stockFund(Model model, @RequestParam Map<String, String> paramMap) {
		int page = 1;

		// 탐색할 맵을 선언
		Map<String, String> searchMap = new HashMap<String, String>();
		try {
			String searchValue = paramMap.get("searchValue");
			if (searchValue != null && searchValue.length() > 0) {
				String searchType = paramMap.get("searchType");
				searchMap.put(searchType, searchValue);
			} else {
				paramMap.put("searchType", "all");
			}
			
			page = Integer.parseInt(paramMap.get("page"));
			 
		} catch (Exception e) {}
		
		int fundCount = service.getFundCount(searchMap);
		PageInfo pageInfo = new PageInfo(page, 10, fundCount, 10);
		List<FundProductInfo> list = service.getFundList(pageInfo, searchMap);	
		
		model.addAttribute("list", list);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("pageInfo", pageInfo);
		
		return "stock/stockFund";
	}
	
	@RequestMapping("/stockFundDetail")
	public String stockFundDetail() {
		return "stock/stockFundDetail";
	}
	
	@RequestMapping("/stockFuture")
	public String stockFuture() {
		return "stock/stockFuture";
	}
	
	@RequestMapping("/stockSelling")
	public String stockSelling() {
		return "stock/stockSelling";
	}
	
	@RequestMapping("/stockTest")
	public String stockTest() {
		return "stock/stockTest";
	}
}
