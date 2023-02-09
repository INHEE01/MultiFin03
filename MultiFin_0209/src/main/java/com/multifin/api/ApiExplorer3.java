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

import com.multifin.model.vo.StockDiviInfo;

public class ApiExplorer3 {
// [증권] 금융위원회_주식 배당 정보
	public static final String KEY = "o0rmsAr3lo90ag1GrkQl6Kiy5BOwZwkfgkaqJ8t2JbG5y%2F9FFPMF%2Bg9Xd1YEb6D6UOVWLFm9Ls438M2dify3fQ%3D%3D"; // API KEY
	public static final String REQUEST_URL  = "https://apis.data.go.kr/1160100/service/GetStocDiviInfoService/getDiviInfo";
	public static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
	public static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws IOException {
		getStockDiviInfo();
	}
	
	public static List<StockDiviInfo> getStockDiviInfo() throws IOException {
		List<StockDiviInfo> list = new ArrayList<>();
		
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
			urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("50", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("resultType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("crno","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* API KEY 입력 부분 */
			urlBuilder.append("&" + URLEncoder.encode("stckIssuCmpyNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /* API KEY 입력 부분 */
			
			
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
						
						int sdno = 0;
						Date basDt = getDateData(eElement, "basDt");
						Date cashDvdnPayDt = getDateData(eElement, "cashDvdnPayDt");
						String cashGrdnDvdnRt = getStrData(eElement, "cashGrdnDvdnRt"); 
						String crno = getStrData(eElement, "crno");
						Date dvdnBasDt = getDateData(eElement, "dvdnBasDt");
						String isinCd = getStrData(eElement, "isinCd");
						String isinCdNm = getStrData(eElement, "isinCdNm");
						String scrsItmsKcd = getStrData(eElement, "scrsItmsKcd");
						String scrsItmsKcdNm = getStrData(eElement, "scrsItmsKcdNm");
						String stckDvdnRcd = getStrData(eElement, "stckDvdnRcd");
						String stckDvdnRcdNm = getStrData(eElement, "stckDvdnRcdNm");
						String stckGenrCashDvdnRt = getStrData(eElement, "stckGenrCashDvdnRt");
						String stckGenrDvdnAmt = getStrData(eElement, "stckGenrDvdnAmt");
						String stckGenrDvdnRt = getStrData(eElement, "stckGenrDvdnRt");
						String stckGrdnDvdnAmt = getStrData(eElement, "stckGrdnDvdnAmt");
						String stckGrdnDvdnRt = getStrData(eElement, "stckGrdnDvdnRt");
						Date stckHndvDt = getDateData(eElement, "stckHndvDt");
						String stckIssuCmpyNm = getStrData(eElement, "stckIssuCmpyNm");
						String stckParPrc = getStrData(eElement, "stckParPrc");
						String stckStacMd = getStrData(eElement, "stckStacMd");
						String trsnmDptyDcd = getStrData(eElement, "trsnmDptyDcd");
						String trsnmDptyDcdNm = getStrData(eElement, "trsnmDptyDcdNm");
						
						StockDiviInfo sdi = new StockDiviInfo(sdno, basDt, cashDvdnPayDt, cashGrdnDvdnRt,
								crno, dvdnBasDt, isinCd, isinCdNm, scrsItmsKcd, scrsItmsKcdNm,
								stckDvdnRcd, stckDvdnRcdNm, stckGenrCashDvdnRt, stckGenrDvdnAmt,
								stckGenrDvdnRt, stckGrdnDvdnAmt, stckGrdnDvdnRt, stckHndvDt, 
								stckIssuCmpyNm, stckParPrc, stckStacMd, trsnmDptyDcd, trsnmDptyDcdNm);
						
						list.add(sdi);
						
						System.out.println(sdi.toString());
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
			Date date = sdf1.parse(eElement.getElementsByTagName(tagName).item(0).getTextContent());
			System.out.println(date);
			return date;
		} catch (Exception e) {
			return null;
		}
	}
}
