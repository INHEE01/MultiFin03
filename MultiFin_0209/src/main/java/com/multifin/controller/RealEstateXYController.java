package com.multifin.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.multifin.api.RealEstateDealAPI2;
import com.multifin.model.service.RealEstateParsingService;
import com.multifin.model.vo.MarkerParsing;
import com.multifin.model.dao.MarkerDao;

public class RealEstateXYController {

	private RealEstateParsingService RealEstateParsingService = new RealEstateParsingService();

	// 테이블 초기화
	public void initRealEstate() throws IOException, ParseException {
		// 권역코드
		ArrayList<String> searchAddr = new ArrayList<>();

		for (int i = 0; i < RealEstateParsingService.selectAll().size(); i++) {
			if(RealEstateParsingService.selectAll().get(i).equals(null)||RealEstateParsingService.selectAll().get(i).toString().isEmpty()) {
				continue;	
			}
			searchAddr.add(RealEstateParsingService.selectAll().get(i).getDong()
					+ RealEstateParsingService.selectAll().get(i).getJibun());
		}
		System.out.println("FINISH");
		for (String address : searchAddr) {
			List<MarkerParsing> list = RealEstateDealAPI2.MarkerParsing(address);
			if (list == null || list.isEmpty()) {
				continue;
			}
			// 가져온 데이터를 DB에 저장
			for (MarkerParsing sp : list) {
				RealEstateParsingService.insert(sp); //
			}
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		RealEstateXYController controller = new RealEstateXYController();
		controller.initRealEstate();
		System.out.println("데이터 업데이트가 완료되었습니다.");
	}
}
