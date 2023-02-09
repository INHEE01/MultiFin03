package com.multifin.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.multifin.api.ExchangeRateAPI;
import com.multifin.model.service.ExchangeRateService;
import com.multifin.model.vo.ExchangeRate;

public class ExchangeRateController {
	private ExchangeRateService exchangeRateService = new ExchangeRateService();
	
	public void initExchangeRate() {
		Calendar cal = new GregorianCalendar(2023, 0, 1); // 2023년 1월 1일
		Calendar today = Calendar.getInstance();
		
		while (true) {
			System.out.println(cal.getTime());
			if (cal.after(today) == true) {
				break;
			}
			// 데이터 불러오기
			List<ExchangeRate> list = ExchangeRateAPI.getExchangeRate(cal.getTime());
			cal.add(Calendar.DATE, 1);
			
			// 가져온 리스트가 아무것도 없으면 다시 반복
			if (list == null || list.isEmpty()) {
				continue;
			}
			
			// 가져온 데이터를 DB에 저장
			for (ExchangeRate ex : list) {
				System.out.println(ex);
				exchangeRateService.insert(ex);
			}
		}
	}
	
	public static void main(String[] args) {
		ExchangeRateController controller = new ExchangeRateController();
		controller.initExchangeRate();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
	
	
	

}
