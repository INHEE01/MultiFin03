package com.multifin.controller;

import java.util.List;

import com.multifin.api.LoanRentHouseAPI;
import com.multifin.model.service.LoanRentHouseService;
import com.multifin.model.vo.LoanRentHouse;

public class LoanRentHouseController {
	private LoanRentHouseService loanRentHouseService = new LoanRentHouseService();

	// LoanRentHouse 테이블 초기화
	public void initLoanRentHouse() {
		// 권역코드
		String[] bankAreaNo = new String[] { "020000", "030200", "030300", "050000", "060000" };

		for (String num : bankAreaNo) {
			List<LoanRentHouse> list = LoanRentHouseAPI.parsingRentHouse(num, 1);
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (LoanRentHouse sp : list) {
				loanRentHouseService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		LoanRentHouseController controller = new LoanRentHouseController();
		controller.initLoanRentHouse();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
}
