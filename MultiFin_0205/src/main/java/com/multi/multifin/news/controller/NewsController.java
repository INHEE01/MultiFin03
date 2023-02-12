package com.multi.multifin.news.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.multifin.news.naverapi.NaverSearchAPI;
import com.multi.multifin.news.naverapi.News;

@RequestMapping("/news")
@Controller

public class NewsController {

	public static List<News> newsList1 = null;
	public static List<News> newsList2 = null;
	public static List<News> newsList3 = null;

	@RequestMapping("/newsMain")
	public String newsMain(Model model) {
		if (newsList1 == null) {
			initNews();
		}
		
		model.addAttribute("newsList1", newsList1);
		model.addAttribute("newsList2", newsList2);
		model.addAttribute("newsList3", newsList3);

		return "news/newsMain";
	}

	public void initNews() {
		newsList1 = NaverSearchAPI.getNewsList("경제", 100, 1);
		newsList2 = NaverSearchAPI.getNewsList("유아인", 3, 1);
		newsList3 = NaverSearchAPI.getNewsList("부동산", 5, 1);
	}
}
