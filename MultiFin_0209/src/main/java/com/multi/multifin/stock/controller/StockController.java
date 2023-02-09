package com.multi.multifin.stock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/stock")
@Controller
public class StockController {

	@GetMapping("/stockBuying")
	public String stockBuying() {
		return "stock/stockBuying";
	}
	
	@GetMapping("/stockFuture")
	public String stockFuture() {
		return "stock/stockFuture";
	}
	
	@GetMapping("/stockList")
	public String stockList() {
		return "stock/stockList";
	}
	
	@GetMapping("/stockMain")
	public String stockMain() {
		return "stock/stockMain";
	}
	
	@GetMapping("/stockSelling")
	public String stockSelling() {
		return "stock/stockSelling";
	}
	
	@GetMapping("/stockTest")
	public String stockTest() {
		return "stock/stockTest";
	}
}
