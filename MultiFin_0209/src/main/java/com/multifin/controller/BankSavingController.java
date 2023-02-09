package com.multifin.controller;

import java.util.List;

import com.multifin.api.BankSavingAPI;
import com.multifin.model.service.BankSavingService;
import com.multifin.model.vo.BankSaving;

public class BankSavingController {
	private BankSavingService bankSavingService = new BankSavingService();
	// BankSaving 테이블 초기화
	public void initBankSaving() {
		// 권역코드
		String[] bankAreaNo = new String[] { "020000", "030200", "030300", "050000", "060000" };

		for (String num : bankAreaNo) {
			List<BankSaving> list = BankSavingAPI.parsingSaving(num, 1);
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (BankSaving sp : list) {
				bankSavingService.insert(sp);
			}
		}
	}
	
	public static void main(String[] args) {
		BankSavingController controller = new BankSavingController();
		controller.initBankSaving();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
}
