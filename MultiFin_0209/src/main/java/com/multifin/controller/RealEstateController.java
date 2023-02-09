package com.multifin.controller;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;

import com.multifin.api.RealEstateDealAPI;
import com.multifin.api.RealEstateDealAPI2;
import com.multifin.api.RealEstateSvcOffiRentAPI;
import com.multifin.api.RealEstateSvcSHRentAPI;
import com.multifin.model.service.RealEstateDealService;
import com.multifin.model.service.RealEstateParsingService;
import com.multifin.model.service.RealEstateSvcOffiRentService;
import com.multifin.model.service.RealEstateSvcSHRentService;
import com.multifin.model.vo.MarkerParsing;
import com.multifin.model.vo.RealEstate;
import com.multifin.model.vo.RealEstateSvcOffiRent;
import com.multifin.model.vo.RealEstateSvcSHRent;

public class RealEstateController {

	private RealEstateDealService RealEstateDealService = new RealEstateDealService();

	private RealEstateSvcSHRentService RealEstateSvcSHRentService = new RealEstateSvcSHRentService();
	private RealEstateSvcOffiRentService RealEstateSvcOffiRentService = new RealEstateSvcOffiRentService();
	private RealEstateParsingService RealEstateParsingService = new RealEstateParsingService();

	//  테이블 초기화
	public void initRealEstate() throws IOException, ParseException {
		

		String[] Regional_Code = new String[] { "11680", "11740", "11305", "11500", "11620", "11215", "11530", "11545", // 권역코드
				"11350", "11320", "11230", "11590", "11440", "11410", "11650", "11200", "11290", "11710", "11470",
				"11560", "11170", "11380", "11110", "11140", "11260", "26440", "26410", "26710", "26290", "26170",
				"26260", "26230", "26320", "26530", "26380", "26140", "26500", "26470", "26200", "26110", "26350",
				"27200", "27290", "27710", "27140", "27230", "27170", "27260", "27110", "28710", "28245", "28200",
				"28140", "28177", "28237", "28260", "28185", "28720", "28110", "29200", "29155", "29110", "29170",
				"29140", "30230", "30110", "30170", "30200", "30140", "31140", "31170", "31200", "31710", "31110",
				"36110", "41820", "41281", "41285", "41287", "41290", "41210", "41610", "41310", "41410", "41570",
				"41360", "41250", "41190", "41135", "41131", "41133", "41113", "41117", "41111", "41115", "41390",
				"41273", "41271", "41550", "41173", "41171", "41630", "41830", "41670", "41800", "41463", "41465",
				"41461", "41430", "41150", "41500", "41480", "41220", "41650", "41450", "41590", "42150", "42820",
				"42170", "42230", "42210", "42800", "42830", "42750", "42130", "42810", "42770", "42780", "42110",
				"42190", "42760", "42720", "42790", "42730", "43760", "43800", "43720", "43740", "43730", "43770",
				"43150", "43745", "43750", "43111", "43112", "43114", "43113", "43130", "44250", "44150", "44710",
				"44230", "44270", "44180", "44760", "44210", "44770", "44200", "44810", "44131", "44133", "44790",
				"44825", "44800", "45790", "45130", "45210", "45190", "45730", "45800", "45770", "45710", "45140",
				"45750", "45740", "45113", "45111", "45180", "45720", "46810", "46770", "46720", "46230", "46730",
				"46170", "46710", "46110", "46840", "46780", "46150", "46910", "46130", "46870", "46830", "46890",
				"46880", "46800", "46900", "46860", "46820", "46790", "47290", "47130", "47830", "47190", "47720",
				"47150", "47280", "47920", "47250", "47840", "47170", "47770", "47760", "47210", "47230", "47900",
				"47940", "47930", "47730", "47820", "47750", "47850", "47111", "47113", "50110", "50130", "48310",
				"48880", "48820", "48250", "48840", "48270", "48240", "48860", "48330", "48720", "48170", "48740",
				"48125", "48127", "48123", "48121", "48129", "48220", "48850", "48870", "48890" };

		String year = "202302";  //적용 년도 월


		for (String num : Regional_Code) {
			List<RealEstate> list = RealEstateDealAPI.parsingRealEstate(num, year);  //아파트 전월세
			if (list == null || list.isEmpty()) {
				continue;
			} // 가져온 데이터를 DB에 저장
			for (RealEstate sp : list) {
				RealEstateDealService.insert(sp);
			}
		}

//		for (String num : Regional_Code) {
//			List<RealEstateSvcSHRent> list = RealEstateSvcSHRentAPI.parsingRealEstateSvcSHRent(num, year);  //단독 다가구 전월세
//			if (list == null || list.isEmpty()) {
//				continue;
//			} // 가져온 데이터를 DB에 저장
//			for (RealEstateSvcSHRent sp : list) {
//				RealEstateSvcSHRentService.insert(sp);
//			}
//		}
//
//		for (String num : Regional_Code) {
//			List<RealEstateSvcOffiRent> list = RealEstateSvcOffiRentAPI.parsingRealEstateSvcOffiRent(num, year); //오피스텔 전월세
//			if (list == null || list.isEmpty()) {
//				continue;
//			} // 가져온 데이터를 DB에 저장
//			for (RealEstateSvcOffiRent sp : list) {
//				RealEstateSvcOffiRentService.insert(sp);
//			}
//		}

	}

	public static void main(String[] args) throws IOException, ParseException {
		RealEstateController controller = new RealEstateController();
		controller.initRealEstate();

		System.out.println("데이터 업데이트가 완료되었습니다.");
	}

}
