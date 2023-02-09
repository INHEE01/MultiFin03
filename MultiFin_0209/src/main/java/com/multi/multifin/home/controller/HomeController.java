package com.multi.multifin.home.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multifin.model.service.RealEstateDealService;
import com.multifin.model.service.RealEstateParsingService;

import org.springframework.ui.Model;

@RequestMapping("/home")
@Controller
public class HomeController {

	@GetMapping("/homeAuction")
	public String homeAuction() {
		return "home/homeAuction";
	}
	
	@GetMapping("/homeBlue")
	public String homeBlue() {
		return "home/homeBlue";
	}
	
	@GetMapping("/homeMain")
	public String homeMain() {
		return "home/homeMain";
	}
	
	@GetMapping("/homeSell")
	public String homeSell(Model model) {
		RealEstateParsingService rps= new RealEstateParsingService();
		//rps.selectAllXY().get(0).getText();
//		 Map<String, Object> map = new HashMap<String, Object>();
//		 for(int i=0;i<rps.selectAll().size();i++) {
//		 map.put("dataText", rps.selectAllXY().get(i).getText());
//		 map.put("dataX", rps.selectAllXY().get(i).getX());
//		 map.put("dataY", rps.selectAllXY().get(i).getY());
//		 }
		model.addAttribute("xyList", rps.selectAllXY());	
		model.addAttribute("nameList", rps.selectAllName());	
		return "home/homeSell";
	}
	
	@GetMapping("/homeSellDetial")
	public String homeSellDetial() {
		return "home/homeSellDetial";
	}

}
