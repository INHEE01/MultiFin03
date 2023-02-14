package com.multi.multifin.home.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.home.model.service.HomeService;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;

import lombok.extern.slf4j.Slf4j;

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
	public String homeSellSearch(Model model, @RequestParam Map<String, Object> paramMap,
			@RequestParam(required = false) List<String> searchType
			) {
		log.info("부동산 매물 페이지 요청 성공");
		if(paramMap.get("searchValue") == null) {
			paramMap.put("searchValue", "역삼동");
		}
		paramMap.put("searchType", searchType);
		System.out.println(searchType);
		List<MarkerParsing> markerParsing = homeService.selectHomeByXY(paramMap);
		List<Home> list = homeService.searchHomeBylocatin(paramMap);
		List<Home> home = homeService.searchHomeList(paramMap);
		int homeCount = homeService.getHomeCount(paramMap);
		
		if(searchType == null) {
			searchType = new ArrayList<>();
			paramMap.put("searchType", searchType);
		}
		
		if(markerParsing.size() > 0) {
			model.addAttribute("x", markerParsing.get(0).getX());
			model.addAttribute("y", markerParsing.get(0).getY());
		}else {
			model.addAttribute("x", "127.0706095");
			model.addAttribute("y", "37.5407622");
		}
		model.addAttribute("markerParsing", markerParsing);
		model.addAttribute("homeCount", homeCount);
		model.addAttribute("list", list);
		model.addAttribute("home", home);
		model.addAttribute("paramMap", paramMap);

		return "home/homeSell";
	}

	@GetMapping("/homeSellDetail")
	public String homeSellDetail(Model model,  @RequestParam("RealEstateDealNo") String param) {
		log.info("부동산 매물 상세 페이지 요청 성공");
		System.out.println(param); // OK

		List<Home> homeInfo = homeService.selectHomeInfo(param);
		String dong= homeInfo.get(0).getDong();
		String jibun= homeInfo.get(0).getJibun();
		model.addAttribute("homeInfo", homeInfo);
		model.addAttribute("mainAddress", "https://www.google.com/maps/embed/v1/place?key=AIzaSyC1aON48lqcS91l_x_GJblY_kXTcrUk_ZI&region=KR&language=ko&q="+dong+jibun);

		return "home/homeSellDetail";
	}

}
