package com.multi.multifin.home.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.bank.controller.BankController;
import com.multi.multifin.home.model.service.HomeService;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;
import lombok.extern.slf4j.Slf4j;

import org.springframework.ui.Model;
@Slf4j
@RequestMapping("/home")
@org.springframework.stereotype.Controller
public class HomeController {
	
	@Autowired
	private HomeService homeService;
	
	@GetMapping("/homeAuction")
	public String homeAuction() {
		return "home/homeAuction";
	}
	
	@GetMapping("/homeBlue")
	public String homeBlue() {
		return "home/homeBlue";
	}
	
	@GetMapping("/homeMain")
	public String homeMain(Model model) {
		
		return "home/homeMain";
	}
	
	
	@GetMapping("/homeSell")
	public String homeSellSearch(Model model,@RequestParam Map<String, Object> paramMap) {
		log.info("부동산 매물 페이지 요청 성공");
		List<MarkerParsing> markerParsing = homeService.selectHomeByXY();
		List<Home> home = homeService.searchHomeList(paramMap);
		model.addAttribute("markerParsing", markerParsing);
		model.addAttribute("home", home);
		return "home/homeSell";
	}
	
	
	@GetMapping("/homeSellDetail")
	public String homeSellDetial(Model model, String searchValue,String[] searchType) {
		
		Map<String, Object> map = new HashMap<>();
		if(searchValue != null) {
			map.put("searchValue", searchValue);
		}else if(searchValue==null) {
		//	model.addAttribute("msg", "������ �����ּ���.");
		//	model.addAttribute("location", "/");
		//	return "common/msg"; 
		}
		if(searchType != null && searchType.length > 0) {
			map.put("searchType", searchType);
		}else {
			searchType = new String[] {};
		}
		List<Home> list = homeService.searchHomeByDong(map);

		model.addAttribute("list", list); 
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("genre", Arrays.asList(searchType));
		return "home/homeSellDetail";
	}

}
