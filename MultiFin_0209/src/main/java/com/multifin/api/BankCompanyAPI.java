package com.multifin.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.multifin.model.vo.BankCompany;

// 금융감독원 금융회사개요 API
// http://finlife.fss.or.kr/PageLink.do?link=openapi/detail&menuId=2000125
public class BankCompanyAPI {
	
	public static final String KEY = "781549c1ac8e3a2e2521b79f392e648e";
	public static final String COMPANYSEARCH_JSON_URL = "http://finlife.fss.or.kr/finlifeapi/companySearch.json";
	
	public static void main(String[] args) {
		 /* 권역코드 | 은행(020000), 여신전문금융(030200), 저축은행(030300), 보험(050000), 금융투자(060000)*/
		bcMainmenu();
		System.out.println("프로그램이 종료되었습니다.");
	} // main 끝
	
	public static List<BankCompany> parsing(String topFinGrpNo, String pageNo){
		List<BankCompany> list = new ArrayList<BankCompany>();
		try {
			StringBuffer urlBuilder = new StringBuffer(COMPANYSEARCH_JSON_URL);
			urlBuilder.append("?" + "auth=" + KEY);
			urlBuilder.append("&" + "topFinGrpNo=" + topFinGrpNo); /* 권역코드 */
			urlBuilder.append("&" + "pageNo=" + pageNo);
			
			System.out.println(urlBuilder.toString()); // 요청 url
			
			// 객체 생성 및 url 연결
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "appliciation/json");
			
			int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
			System.out.println("ResponseCode : " + code);
			
			if(code < 200 || code > 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return null;
			}
			
			// 데이터 받아오기
			StringBuffer sb = new StringBuffer();
			InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			while(br.ready()) {
				sb.append(br.readLine());
			}
			JSONObject result = (JSONObject) new JSONParser().parse(sb.toString());
			
			// JSON데이터에서 "result"라는 JSONObject를 가져온다.
			JSONObject data = (JSONObject) result.get("result");
			// JSONObject에서 Array데이터를 get하여 JSONArray에 저장한다.
			JSONArray baseList = (JSONArray) data.get("baseList");
			JSONArray optionList = (JSONArray) data.get("optionList");
			
			for(int i = 0; i < baseList.size(); i++) {
				JSONObject object = (JSONObject) baseList.get(i);
                
				int bankCompanyNo = 0;
				String dcls_month = getStrData(object, "dcls_month");
				String fin_co_no = getStrData(object, "fin_co_no");
				String kor_co_nm = getStrData(object, "kor_co_nm");
				String dcls_chrg_man = getStrData(object, "dcls_chrg_man");
				String homp_url = getStrData(object, "homp_url");
				String cal_tel = getStrData(object, "cal_tel");
				
				for(int j = 0; j < optionList.size(); j++) {
					JSONObject object2 = (JSONObject) optionList.get(j);
					if(getStrData(object2, "fin_co_no").equals(fin_co_no)) {
						int area_cd = getIntData(object2, "area_cd");
						String area_nm = getStrData(object2, "area_nm");
						String exis_yn = getStrData(object2, "exis_yn");
						BankCompany bc = new BankCompany(bankCompanyNo, dcls_month, fin_co_no, kor_co_nm, dcls_chrg_man, homp_url, cal_tel, area_cd, area_nm, exis_yn);
						list.add(bc);
						
						System.out.println(bc.toString() + "삽입 완료!");
					}
				} // option for문 끝
				
			} // baseList for문 끝
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	} // 파싱 끝
	
	private static String getStrData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str == null) {
			return "-";
		}else {
			return str;
		}
	}
	
	private static int getIntData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Integer.parseInt(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
	public static void bcMainmenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			String menu = "========== BankCompany Info Main ===========\n"
					+ "1. 은행\n"
					+ "2. 여신전문금융\n"
					+ "3. 저축은행\n"
					+ "4. 보험\n"
					+ "5. 금융투자\n"
					+ "0.프로그램 끝내기\n"
					+ "---------------------------------------------\n"
					+ "선택 : ";
			while(true) {
				System.out.print(menu);
				int select = sc.nextInt();
				switch (select) {
					case 1:
						parsing("020000", "1");
						System.out.println("완료되었습니다!!");
						break;
					case 2:
						parsing("030200", "1");
						System.out.println("완료되었습니다!!");
						break;
					case 3:
						parsing("030300", "1");
						System.out.println("완료되었습니다!!");
						break;
					case 4:
						parsing("050000", "1");
						System.out.println("완료되었습니다!!");
						break;
					case 5:
						parsing("060000", "1");
						System.out.println("완료되었습니다!!");
						break;
					case 0: 
						System.out.print("정말로 끝내시겠습니까?(y/n) : ");
						String yn = sc.next();
						if(yn.equals("y") || yn.equals("Y")) {
							return;
						}
						break;
					default: 
						System.out.println("잘못 입력하셨습니다.");
				}
			}
		} // while 끝
		
	} // 메인메뉴 메소드 끝
}
