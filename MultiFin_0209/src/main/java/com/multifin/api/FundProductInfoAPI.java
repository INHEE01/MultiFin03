package com.multifin.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

import com.multifin.model.vo.FundProductInfo;

public class FundProductInfoAPI {
// [증권] 금융위원회_펀드상품기본정보
//	(https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15094792)
	public static final String KEY = "o0rmsAr3lo90ag1GrkQl6Kiy5BOwZwkfgkaqJ8t2JbG5y%2F9FFPMF%2Bg9Xd1YEb6D6UOVWLFm9Ls438M2dify3fQ%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://apis.data.go.kr/1160100/service/GetFundProductInfoService/getStandardCodeInfo";
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

	public static List<FundProductInfo> getFundProductInfo(Date searchDate) {
		List<FundProductInfo> list = new ArrayList<>();
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
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("100", "UTF-8")); /* API KEY 입력 부분 */
//			urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /* API KEY 입력 부분 */
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
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					
					try {
						
						Element eElement = (Element) node;
						
						int fpino = 0;
						Date basDt = getDateData(eElement, "basDt");
						String srtnCd = getStrData(eElement, "srtnCd");					
						String fndNm = getStrData(eElement, "fndNm");
						String ctg = getStrData(eElement, "ctg");
						Date setpDt = getDateData(eElement, "setpDt");
						String fndTp = getStrData(eElement, "fndTp");
						String prdClsfCd = getStrData(eElement, "prdClsfCd");
						String asoStdCd = getStrData(eElement, "asoStdCd");
						
						FundProductInfo fpi = new FundProductInfo(fpino, basDt, srtnCd,
								fndNm, ctg, setpDt,
								fndTp, prdClsfCd, asoStdCd);
						
						list.add(fpi);
						
						System.out.println(fpi.toString());
						
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
}
