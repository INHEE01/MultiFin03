package com.multifin.controller;

import java.util.List;

import com.multifin.api.LoanCreditAPI;
import com.multifin.model.service.LoanCreditService;
import com.multifin.model.vo.LoanCredit;

public class LoanCreditController {
	private LoanCreditService loanCreditService = new LoanCreditService();

	// LoanCredit 테이블 초기화
	public void initLoanCredit() {
		// 권역코드
		String[] bankAreaNo = new String[] { "020000", "030200", "030300", "050000", "060000" };

		for (String num : bankAreaNo) {
			List<LoanCredit> list = LoanCreditAPI.parsingCredit(num, 1);
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (LoanCredit sp : list) {
				loanCreditService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		LoanCreditController controller = new LoanCreditController();
		controller.initLoanCredit();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}

}
