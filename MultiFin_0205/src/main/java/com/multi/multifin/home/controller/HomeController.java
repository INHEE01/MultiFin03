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
	public String homeSellSearch(Model model, @RequestParam Map<String, Object> paramMap) {
		log.info("부동산 매물 페이지 요청 성공");

		String searchValue = (String)(paramMap.get("searchValue"));
		if (searchValue != null && searchValue.length() > 0) {
			paramMap.put("searchValue", searchValue);
		} else {
//			model.addAttribute("msg", "제목을 적어주세요.");
//			model.addAttribute("location", "/");
//			return "common/msg";
		}
		String[] searchType = (String[])paramMap.get("searchType");
		if (searchType != null  && searchType.length > 0) {
			paramMap.put("searchType", searchType);
		} else {
			searchType = new String[] {};
		}
		List<MarkerParsing> markerParsing = homeService.selectHomeByXY(paramMap);
		List<Home> list = homeService.searchHomeBylocatin(paramMap);
		List<Home> home = homeService.searchHomeList(paramMap);
		int homeCount = homeService.getHomeCount(paramMap);
		model.addAttribute("markerParsing", markerParsing);
		model.addAttribute("homeCount", homeCount);
		model.addAttribute("list", list);
		model.addAttribute("home", home);
		System.out.println(paramMap.toString());

		return "home/homeSell";
	}

	@GetMapping("/homeSellDetail")
	public String homeSellDetail(Model model,  @RequestParam("RealEstateDealNo") String param) {
		log.info("부동산 매물 상세 페이지 요청 성공");
		System.out.println(param); // OK

//			String RealEstateDealNo = (String)(paramMap.get("RealEstateDealNo"));
//			if (RealEstateDealNo != null && RealEstateDealNo.length() > 0) {
//				paramMap.put("RealEstateDealNo", RealEstateDealNo);
//			} else {
//				model.addAttribute("msg", "제목을 적어주세요.");
//				model.addAttribute("location", "/");
//				return "common/msg";
//			}
		List<Home> homeInfo = homeService.selectHomeInfo(param);
		String dong= homeInfo.get(0).getDong();
		String jibun= homeInfo.get(0).getJibun();
		model.addAttribute("homeInfo", homeInfo);
		model.addAttribute("mainAddress", "https://www.google.com/maps/embed/v1/place?key=AIzaSyC1aON48lqcS91l_x_GJblY_kXTcrUk_ZI&region=KR&language=ko&q="+dong+jibun);

		return "home/homeSellDetail";
	}

}
