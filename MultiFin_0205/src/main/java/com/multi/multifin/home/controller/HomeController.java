package com.multi.multifin.home.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.multi.multifin.common.util.PageInfo;
import com.multi.multifin.home.model.service.HomeBlueService;
import com.multi.multifin.home.model.service.HomeService;
import com.multi.multifin.home.model.vo.Aptdetail;
import com.multi.multifin.home.model.vo.Home;
import com.multi.multifin.home.model.vo.MarkerParsing;
import com.multi.multifin.home.model.vo.OfficeDetail;
import com.multi.multifin.home.model.vo.RemainDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/home")
@org.springframework.stereotype.Controller
public class HomeController {

	@Autowired
	private HomeService homeService;

	@Autowired
	private HomeBlueService blueService;

	@GetMapping("/homeAuction")
	public String homeAuction() {
		return "home/homeAuction";
	}


	
	
	@GetMapping("/homeBlue")
	public String homeBlueSearch(Model model, @RequestParam Map<String, String> paramMap) {
		log.info("청약 아파트 조회 페이지 요청 성공");
		int page = 1;
		Map<String, String> searchMap = new HashMap<>();
		
		// TODO 검색기능 다시보기
		try {
			String searchValue = paramMap.get("searchValue"); 
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = paramMap.get("searchType");
				searchMap.put(searchType, searchValue);
			}else {
				paramMap.put("searchType", "all");
			}
		} catch (Exception e) {	}
		
		int aptCount = blueService.selectAptCount(searchMap);
		PageInfo pageInfo = new PageInfo(page, 5, aptCount, 10);
		List<Aptdetail> Aptlist = blueService.searchAptList(pageInfo, searchMap);

		model.addAttribute("Aptlist", Aptlist);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("searchMap", searchMap);
		
		return "home/homeBlue";
	}
	
	@GetMapping("/homeBlue2")
	public String homeBlue2(Model model, @RequestParam Map<String, String> paramMap ) {
		log.info("오피스텔 조회 페이지 요청 성공");
		int page = 1;
		Map<String, String> searchMap = new HashMap<>();
		
		// TODO 검색기능 다시보기
		try {
			String searchValue = paramMap.get("searchValue"); 
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = paramMap.get("searchType");
				searchMap.put(searchType, searchValue);
			}else {
				paramMap.put("searchType", "all");
			}
		} catch (Exception e) {	}
		
		int officeCount = blueService.selectOfficeCount(searchMap);
		PageInfo pageInfo = new PageInfo(page, 5, officeCount, 10);
		List<OfficeDetail> Officelist = blueService.searchOfficeList(pageInfo, searchMap);

		model.addAttribute("Officelist", Officelist);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("searchMap", searchMap);
		
		
		return "home/homeBlue2";
	}
	
	@GetMapping("/homeBlue3")
	public String homeBlue3(Model model, @RequestParam Map<String, String> paramMap ) {
		log.info("기타 조회 페이지 요청 성공");
		int page = 1;
		Map<String, String> searchMap = new HashMap<>();
		
		// TODO 검색기능 다시보기
		try {
			String searchValue = paramMap.get("searchValue"); 
			if(searchValue != null && searchValue.length() > 0) {
				String searchType = paramMap.get("searchType");
				searchMap.put(searchType, searchValue);
			}else {
				paramMap.put("searchType", "all");
			}
		} catch (Exception e) {	}
		
		int remainCount = blueService.selectRemainCount(searchMap);
		PageInfo pageInfo = new PageInfo(page, 5, remainCount, 10);
		List<RemainDetail> Remainlist = blueService.searchRemainList(pageInfo, searchMap);

		model.addAttribute("Remainlist", Remainlist);
		model.addAttribute("pageInfo",pageInfo);
		model.addAttribute("paramMap", paramMap);
		model.addAttribute("searchMap", searchMap);
		
		
		return "home/homeBlue3";
	}
	
	@GetMapping("/homeMain")
	public String homeMain(Model model, @RequestParam Map<String, Object> paramMap) {
		
		
		return "home/homeMain";
	}

	@GetMapping("/homeSell")
	public String homeSellSearch(Model model, @RequestParam Map<String, Object> paramMap,
			@RequestParam(required = false) List<String> searchType, @RequestParam Map<String, Object> searchMap
			) {
		log.info("부동산 매물 페이지 요청 성공");
		
		if(paramMap.get("searchValue") == null ||searchMap.get("searchValue") == null ) {
			searchMap.put("searchValue", "역삼동");
			paramMap.put("searchValue", "역삼동");
		}
		
		if(searchType != null && searchType.size() != 2) {
			searchMap.put("searchType", searchType.get(0));
			paramMap.put("searchType", searchType.get(0));
		}
		if(searchType == null) {
			searchType = new ArrayList<>();
		}
		paramMap.put("searchType", searchType);
		
		System.out.println(paramMap.get("searchValue"));
		System.out.println(searchMap.get("searchValue"));
		System.out.println(searchType);
		
		List<MarkerParsing> markerParsing = homeService.selectHomeByXY(paramMap);
		List<Home> list = homeService.searchHomeBylocatin(searchMap);
		List<Home> home = homeService.searchHomeList(searchMap);
		int homeCount = homeService.getHomeCount(searchMap);
		
		
		if(markerParsing.size() > 0) {
			model.addAttribute("x", markerParsing.get(0).getX());
			model.addAttribute("y", markerParsing.get(0).getY());
		}else {
			model.addAttribute("x", "127.0706095");
			model.addAttribute("y", "37.5407622");
		}
		System.out.println(homeCount);
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
		String apart_img= homeInfo.get(0).getFloor();
		model.addAttribute("homeInfo", homeInfo);
		model.addAttribute("homeInfo", homeInfo);
		model.addAttribute("mainAddress", "https://www.google.com/maps/embed/v1/place?key=AIzaSyC1aON48lqcS91l_x_GJblY_kXTcrUk_ZI&region=KR&language=ko&q="+dong+jibun);
		model.addAttribute("apart_img", "../../assets/img/home/apt"+apart_img+".jpg");

		return "home/homeSellDetail";
	}

}
