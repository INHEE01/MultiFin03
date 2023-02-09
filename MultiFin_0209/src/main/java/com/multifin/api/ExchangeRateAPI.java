package com.multifin.api;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.multifin.model.vo.ExchangeRate;

public class ExchangeRateAPI {
// [증권] 한국수출입은행 환율 정보 | 공공데이터포털 (data.go.kr)
//	(https://www.koreaexim.go.kr/ir/HPHKIR020M01?apino=2&viewtype=C
//		&searchselect=&searchword=)
	public static final String KEY = "dvOOksyNzkqP8LUiZJFdI38L0HkHJ1B0"; // API KEY
	public static final String REQUEST_URL  = "https://www.koreaexim.go.kr/site/program/financial/exchangeJSON"; // 요청 URL
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static List<ExchangeRate> getExchangeRate(Date searchDate) {
		List<ExchangeRate> list = new ArrayList<>();
		String dateStr = sdf2.format(searchDate);
		
		try {
			
			StringBuilder urlBuilder = new StringBuilder(REQUEST_URL); /*URL*/
			urlBuilder.append("?" + URLEncoder.encode("authkey","UTF-8") + "=" + URLEncoder.encode(KEY, "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("searchdate","UTF-8") + "=" + dateStr); /* search Date */
			urlBuilder.append("&" + URLEncoder.encode("data","UTF-8") + "=" + URLEncoder.encode("AP01", "UTF-8")); /**/
			
			System.out.println(urlBuilder);
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");

			int code = conn.getResponseCode(); // 실제 page를 요청하는 코드부
			System.out.println("ResponseCode : " + code);
			if (code < 200 || code >= 300) {
				System.out.println("페이지가 잘못되었습니다.");
				return list;
			}
			
			InputStreamReader isr = new InputStreamReader(conn.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
	       
			JSONParser jsonParser = new JSONParser(); 
			JSONArray jsonArr = (JSONArray) jsonParser.parse(br);
			
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject obj = (JSONObject) jsonArr.get(i);
				
				int rno = 0;
				Date recordDate = searchDate;
				String cur_unit = getStrData(obj, "cur_unit");
				String ttb = getStrData(obj, "ttb");
				String tts = getStrData(obj, "tts");
				String deal_bas_r = getStrData(obj, "deal_bas_r");
				String bkpr = getStrData(obj, "bkpr");
				String yy_efee_r = getStrData(obj, "yy_efee_r");
				String ten_dd_efee_r = getStrData(obj, "ten_dd_efee_r");
				String kftc_bkpr = getStrData(obj, "kftc_bkpr");
				String kftc_deal_bas_r = getStrData(obj, "kftc_deal_bas_r");
				String cur_nm = getStrData(obj, "cur_nm");
				
				ExchangeRate sp = new ExchangeRate(rno, recordDate, cur_unit, ttb, tts, deal_bas_r, bkpr, yy_efee_r, ten_dd_efee_r, kftc_bkpr, kftc_deal_bas_r, cur_nm);
				list.add(sp);
				System.out.println(sp);
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		
		return list;
	}
	
	private static String getStrData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str == null) {
			return "-";
		}else {
			return str;
		}
	}
	
	private static Date getDateData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return sdf2.parse(str);
			} catch (Exception e) {}
		}
		return null;
	}
	
	private static long getLongData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Long.parseLong(str);
			} catch (Exception e) {}
		}
		return 0;
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
	
	private static double getDoubleData(JSONObject obj , String key){
		String str = (String) obj.get(key);
		if(str != null) {
			try {
				return Double.parseDouble(str);
			} catch (Exception e) {}
		}
		return 0;
	}
	
}
