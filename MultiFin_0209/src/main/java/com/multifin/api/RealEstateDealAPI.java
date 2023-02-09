package com.multifin.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.multifin.model.vo.RealEstate;

public class RealEstateDealAPI {

	public static final String KEY = "CrQAeD%2BSU82YAfpqJhPuqvkm%2BhNCaipkTLAWETUU0KrHmXwnLGqIazEIG7uayc0m6UcHEotPHCgEiFH0hxZ53A%3D%3D";
	public static final String REQUEST_URL = "http://openapi.molit.go.kr:8081/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptRent";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws IOException {
		//parsingRealEstate("11110","201512");
	}
	
	public static List<RealEstate> parsingRealEstate(String LAWD_CD, String DEAL_YMD) throws IOException {
		List<RealEstate> list = new ArrayList<>();
		
		try {
			
			// ============= 인증서 허용 코드 =================
	    	TrustManager[] trustAllCerts = new TrustManager[] { 
	    	    (TrustManager) new X509TrustManager() {
	    	        public X509Certificate[] getAcceptedIssuers() {
	    	            return null;
	    	        }

	    	        public void checkClientTrusted(X509Certificate[] certs, String authType) {}
	    	        public void checkServerTrusted(X509Certificate[] certs, String authType) {}
	    		}
	    	};

	    	SSLContext sc = SSLContext.getInstance("SSL");
	    	sc.init(null, trustAllCerts, new SecureRandom());
	    	HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	        // ============= /인증서 허용 코드 =================
			
	    	StringBuilder urlBuilder = new StringBuilder(REQUEST_URL); /*URL*/
			urlBuilder.append("?" + "serviceKey=" + KEY);
			urlBuilder.append("&" + "LAWD_CD=" + LAWD_CD); 
			urlBuilder.append("&" + "DEAL_YMD=" + DEAL_YMD);
			
			System.out.println(urlBuilder);
			
			URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            System.out.println("Response code: " + conn.getResponseCode());
//            
            if (conn.getResponseCode() < 200 || conn.getResponseCode() > 300) {
            	System.out.println("페이지가 잘못되었습니다.");
            	return list;
            }
			
			// 3. 페이지 Parsing(해석)
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			 
			Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("======================================================");

			NodeList nList = doc.getElementsByTagName("item"); // !!
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;
						
						
						int RealEstateDealNo = 0;
						String Build_Year = getStrData(eElement, "건축년도");
						String Contract_Type = getStrData(eElement, "계약구분");
						String Term_Contract = getStrData(eElement, "계약기간");
						String Deal_Year = getStrData(eElement, "년");
						String Dong = getStrData(eElement, "법정동");
						String Deposit = getStrData(eElement, "보증금액");
						String Apartment_Name = getStrData(eElement, "아파트");
						String Deal_Month = getStrData(eElement, "월");
						int Monthly_Rent = getIntData(eElement, "월세금액");
						String Deal_Day = getStrData(eElement, "일");
						String  Area= getStrData(eElement, "전용면적");
						String  Jibun= getStrData(eElement, "지번");
						String Regional_Code = getStrData(eElement, "지역코드");
						String Floor = getStrData(eElement, "층");
						Double x = getDoubleData(eElement, "x");
						Double y = getDoubleData(eElement, "y");
						
						//새로운 re 객체 생성
						RealEstate re = new RealEstate(RealEstateDealNo,Build_Year,Contract_Type,Term_Contract,Deal_Year,Dong,Deposit,Apartment_Name,Deal_Month,Monthly_Rent,Deal_Day,Area,Jibun,Regional_Code,Floor);
						// list에 저장
						list.add(re);
						
						
						System.out.println(re.toString());
						System.out.println("삽입 완료!");
						
					} catch (Exception e){
						System.out.println("데이터가 잘못되었습니다!");
					}
				}
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return list;
	}
	
	private static String getStrData(Element eElement, String tagName){
		try {
			return eElement.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			return "-";
		}
	}
	
	private static int getIntData(Element eElement, String tagName){
		try {
			return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}
	
	private static long getLogData(Element eElement, String tagName){
		try {
			return Long.parseLong(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}
	
	private static double getDoubleData(Element eElement, String tagName){
		try {
			return Double.parseDouble(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0.0;
		}
	}
	
	private static Date getDateData(Element eElement, String tagName){
		try {
			System.out.println(eElement.getElementsByTagName(tagName).item(0).getTextContent());
			Date date = sdf2.parse(eElement.getElementsByTagName(tagName).item(0).getTextContent());
			System.out.println(date);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
}
