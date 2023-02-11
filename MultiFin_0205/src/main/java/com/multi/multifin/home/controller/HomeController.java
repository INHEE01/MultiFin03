package com.multi.multifin.home.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.multifin.home.model.service.HomeService;
import com.multi.multifin.home.model.vo.Home;
import com.multifin.model.service.RealEstateParsingService;

import org.springframework.ui.Model;

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
	public String homeSellSearch(Model model) {
		RealEstateParsingService rps= new RealEstateParsingService();
		
		
		
		model.addAttribute("xyList", rps.selectAllXY());	
		model.addAttribute("nameList", rps.selectAllName());	
	
		return "home/homeSell";
	}
	
	
	@GetMapping("/homeSellDetail")
	public String homeSellDetial(Model model, String searchValue,String[] searchType) {
		
		Map<String, Object> map = new HashMap<>();
		if(searchValue != null) {
			map.put("searchValue", searchValue);
		}else if(searchValue==null) {
		//	model.addAttribute("msg", "力格阑 利绢林技夸.");
		//	model.addAttribute("location", "/");
		//	return "common/msg"; 
		}
		if(searchType != null && searchType.length > 0) {
			map.put("searchType", searchType);
		}else {
			searchType = new String[] {};
		}
		List<Home> list = homeService.searchRealEstateByDong(map);

		model.addAttribute("list", list); 
		model.addAttribute("searchValue", searchValue);
		model.addAttribute("genre", Arrays.asList(searchType));
		return "home/homeSellDetail";
	}

}
