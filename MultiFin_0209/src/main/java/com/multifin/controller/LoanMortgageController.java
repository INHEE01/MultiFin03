package com.multifin.controller;

import java.util.List;

import com.multifin.api.LoanMortgageAPI;
import com.multifin.model.service.LoanMortgageService;
import com.multifin.model.vo.LoanMortgage;

public class LoanMortgageController {
	private LoanMortgageService loanMortgageService = new LoanMortgageService();

	// LoanMortgage 테이블 초기화
	public void initLoanMortgage() {
		// 권역코드
		String[] bankAreaNo = new String[] { "020000", "030200", "030300", "050000", "060000" };

		for (String num : bankAreaNo) {
			List<LoanMortgage> list = LoanMortgageAPI.parsingMortgage(num, 1);
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (LoanMortgage sp : list) {
				loanMortgageService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		LoanMortgageController controller = new LoanMortgageController();
		controller.initLoanMortgage();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}

}
