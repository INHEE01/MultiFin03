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

import com.multifin.model.vo.LawQna;
import com.multifin.model.vo.RighExerReasSche;
import com.multifin.model.vo.StocIssuStat;

public class ApiExplorer8 {
// [법률] 법무부_생활법률지식 정보
//	(https://www.data.go.kr/tcs/dss/selectApiDataDetailView.do?publicDataPk=15028606)
	public static final String KEY = "ybDycPaBDlFSgOQQDME9WM%2BSVi%2F3uA3fa5fXxQ8KUb6218kP9KGys5J3HvLNIKvmpewZ7SrKF6aAQGOOnYTGhw%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://apis.data.go.kr/1270000/lawedu/lawqna";
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws IOException {
		getLawdu();	
	}
	
	public static List<LawQna> getLawdu() throws IOException {
		List<LawQna> list = new ArrayList<>();
		
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
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey","UTF-8") + "=" + KEY); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("mainCategory","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("middleCategory","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("smallCategory","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("articleNo","UTF-8") + "=" + URLEncoder.encode("11", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("question","UTF-8") + "=" + URLEncoder.encode("255", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("answer","UTF-8") + "=" + URLEncoder.encode("Mediumtext", "UTF-8")); /* API KEY 입력 부분 */

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

			NodeList nList = doc.getElementsByTagName("items"); // !!
			
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					
					try {
						
						Element eElement = (Element) node;
						
						 int LQno  = 0;
						 String middleCategory = getStrData(eElement, "middleCategory");	
						 String articleNo	= getStrData(eElement, "articleNo");
						 String answer	= getStrData(eElement, "answer");
						 String mainCategory	= getStrData(eElement, "mainCategory");
						 String question	= getStrData(eElement, "question");
						 String smallCategory	= getStrData(eElement, "smallCategory");
						
						 LawQna LQ = new LawQna(LQno,middleCategory,articleNo,answer,mainCategory,question,smallCategory);
						
						list.add(LQ);
						
						System.out.println(LQ.toString());
						
						
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
