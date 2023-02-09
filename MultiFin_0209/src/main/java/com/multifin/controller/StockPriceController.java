package com.multifin.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.multifin.api.StockPriceAPI;
import com.multifin.model.service.StockPriceService;
import com.multifin.model.vo.StockPrice;

public class StockPriceController {
	private StockPriceService stockPriceService = new StockPriceService();

	public void initStockPrice() {
		int pageNum = 1;
		Calendar cal = new GregorianCalendar(2023, 0, 1); // 2023년 1월 1일
		Calendar today = Calendar.getInstance();

		while (true) {
			System.out.println(cal.getTime()); // 현재 날짜
			// 현재 날짜에 해당하는 데이터 페이지 수 구하기
			int endPage = StockPriceAPI.getPageNum(cal.getTime());
			// 데이터 불러오기
			for (int i = 1; i <= endPage; i++) {
				List<StockPrice> list = StockPriceAPI.getStockPriceInfo(cal.getTime(), i);
				// 가져온 리스트가 아무것도 없으면 다시 반복
				if (list == null || list.isEmpty()) {
					continue;
				}
				// 가져온 데이터를 DB에 저장
				for (StockPrice sp : list) {
					stockPriceService.insert(sp);
				}
			}
		
			cal.add(Calendar.DATE, 1);
			
			if (cal.after(today) == true) {
				break;
			}
		}
	}
	
	public static void main(String[] args) {
		StockPriceController controller = new StockPriceController();
		controller.initStockPrice();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}

}
