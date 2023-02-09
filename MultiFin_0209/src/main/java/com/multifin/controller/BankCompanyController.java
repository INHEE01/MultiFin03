package com.multifin.controller;

import java.util.List;

import com.multifin.api.BankCompanyAPI;
import com.multifin.model.service.BankCompanyService;
import com.multifin.model.vo.BankCompany;
import com.multifin.model.vo.StockPrice;

public class BankCompanyController {
	private BankCompanyService bankCompanyService = new BankCompanyService();
	// BankCompany 테이블 초기화
	public void initBankCompany() {
		int pageNum = 1; 
		// 권역코드
		String[] bankAreaNo = new String[] {"020000", "030200", "030300", "050000", "060000"};
		
		for (String num : bankAreaNo) {
			List<BankCompany> list = BankCompanyAPI.parsing(num, "1");
			// 가져온 리스트가 아무것도 없으면 다시 반복
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (BankCompany sp : list) {
				bankCompanyService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		BankCompanyController controller = new BankCompanyController();
		controller.initBankCompany();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
}
