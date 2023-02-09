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

import com.multifin.model.vo.MarkerParsing;

public class ApiExplorer9 {

	public static final String KEY = "CrQAeD%2BSU82YAfpqJhPuqvkm%2BhNCaipkTLAWETUU0KrHmXwnLGqIazEIG7uayc0m6UcHEotPHCgEiFH0hxZ53A%3D%3D";
	public static final String REQUEST_URL = "https://api.vworld.kr/req/address?service=address&request=getcoord&version=2.0&crs=epsg:4326&address=%EB%82%B4%EC%88%98%EB%8F%9915-1&refine=true&simple=false&format=xml&type=PARCEL&key=8DF94013-FA81-3765-9A06-CA75A42DAAFC";
	
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws IOException {
		parsing();
	}
	
	public static List<MarkerParsing> parsing() throws IOException {
		List<MarkerParsing> list = new ArrayList<>();
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

			NodeList nList = doc.getElementsByTagName("response"); // !!
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);
				System.out.println("\nCurrent Element : " + node.getNodeName());
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					try {
						Element eElement = (Element) node;
						
						
						int rno = 0;
						String text = getStrData(eElement, "text");
						Double x = getDoubleData(eElement, "x");
						Double y = getDoubleData(eElement, "y");
						
						
						
						//새로운 re 객체 생성
						MarkerParsing re = new MarkerParsing(rno,text,x,y);
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
