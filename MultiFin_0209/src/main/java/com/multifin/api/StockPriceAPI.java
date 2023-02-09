package com.multifin.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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

import com.multifin.model.vo.StockPrice;

public class StockPriceAPI {
//[증권] 금융위원회_주식 시세 정보

	public static final String KEY = "o0rmsAr3lo90ag1GrkQl6Kiy5BOwZwkfgkaqJ8t2JbG5y%2F9FFPMF%2Bg9Xd1YEb6D6UOVWLFm9Ls438M2dify3fQ%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://apis.data.go.kr/1160100/service/GetStockSecuritiesInfoService/getStockPriceInfo"; // 요청 URL
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static List<StockPrice> getStockPriceInfo(Date searchDate, int pageNum) {
		List<StockPrice> list = new ArrayList<>();
		String dateStr = sdf1.format(searchDate);
		
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
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + KEY); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=100"); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + pageNum); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("basDt","UTF-8") + "=" + dateStr); /* API KEY 입력 부분 */
			
			
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
//				System.out.println("\nCurrent Element : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;
						
						int sno = 0;
						Date basDt = getDateData(eElement, "basDt");
						int srtnCd = getIntData(eElement, "srtnCd");
						int isinCd = getIntData(eElement, "isinCd");
						String itmsNm = getStrData(eElement, "itmsNm");
						String mrktCtg = getStrData(eElement, "mrktCtg");
						String clpr = getStrData(eElement, "clpr");
						String vs = getStrData(eElement, "vs");
						String fltRt = getStrData(eElement, "fltRt");
						int mkp = getIntData(eElement, "mkp");
						int hipr = getIntData(eElement, "hipr");
						int lopr = getIntData(eElement, "lopr");
						int trqu = getIntData(eElement, "trqu");
						long trPrc = getLongData(eElement, "trPrc");
						long lstgStCnt = getLongData(eElement, "lstgStCnt");
						long mrktTotAmt = getLongData(eElement, "mrktTotAmt");
						
						StockPrice sp = new StockPrice(sno, basDt, srtnCd, isinCd, 
								itmsNm, mrktCtg, clpr, vs, 
								fltRt, mkp, hipr, lopr, 
								trqu, trPrc, lstgStCnt, mrktTotAmt);
						
						list.add(sp);
						
						System.out.println(sp.toString());
//						System.out.println("삽입 완료!");
						
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
	
	public static int getPageNum(Date searchDate) {
		String dateStr = sdf1.format(searchDate);
		int totalCount = 0;
		
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
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + KEY); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=100"); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("basDt","UTF-8") + "=" + dateStr); /* API KEY 입력 부분 */
			
			
			System.out.println(urlBuilder);
			
			URL url = new URL(urlBuilder.toString());
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/xml");
            System.out.println("Response code: " + conn.getResponseCode());
//            
            if (conn.getResponseCode() < 200 || conn.getResponseCode() > 300) {
            	System.out.println("페이지가 잘못되었습니다.");
            	return 0;
            }
			
			// 3. 페이지 Parsing(해석)
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			 
			Document doc = db.parse(conn.getInputStream()); // xml 부를 파싱하여 객체화
			
			doc.getDocumentElement().normalize();
			
			System.out.println("Root Element : " + doc.getDocumentElement().getNodeName());
			System.out.println("======================================================");

			NodeList nList = doc.getElementsByTagName("body"); // !!
			System.out.println(nList.getLength());
			
			Node node = nList.item(0);
			Element eElement = (Element) node;
			totalCount = getIntData(eElement, "totalCount"); 		
		} catch (Exception e) {
			System.out.println("데이터가 잘못되었습니다!");
		}
		
		int endPageNum = (totalCount/100) + 1;
		return endPageNum;
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
	
	private static long getLongData(Element eElement, String tagName){
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
			Date date = sdf1.parse(eElement.getElementsByTagName(tagName).item(0).getTextContent());
			System.out.println(date);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args) {
		Calendar cal = new GregorianCalendar(2023, 0, 5); // 2023년 1월 1일
		Calendar today = Calendar.getInstance();
		
		System.out.println(StockPriceAPI.getPageNum(cal.getTime()));
	}
}
