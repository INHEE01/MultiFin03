package com.multifin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class New {

	    public static void main(String[] args) throws IOException {
	    	
	    	
	        StringBuilder urlBuilder = new StringBuilder("http://www.easylaw.go.kr/OPENAPI/soap/LifeLawSearchService/getSearchAadminRefereeList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=o0rmsAr3lo90ag1GrkQl6Kiy5BOwZwkfgkaqJ8t2JbG5y%2F9FFPMF%2Bg9Xd1YEb6D6UOVWLFm9Ls438M2dify3fQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("RequestMsgID","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*요청메세지ID-조회 시 필요 없는 파라미터입니다.*/
	        urlBuilder.append("&" + URLEncoder.encode("RequestTime","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*요청시간-조회 시 필요 없는 파라미터입니다.*/
	        urlBuilder.append("&" + URLEncoder.encode("CallBackURI","UTF-8") + "=" + URLEncoder.encode("-", "UTF-8")); /*콜백URI-조회 시 필요 없는 파라미터입니다.*/
	        urlBuilder.append("&" + URLEncoder.encode("section","UTF-8") + "=" + URLEncoder.encode("5", "UTF-8")); /*검색그룹번호는 ‘5’를 입력합니다.*/
	        urlBuilder.append("&" + URLEncoder.encode("txtQuery","UTF-8") + "=" + URLEncoder.encode("행정심판", "UTF-8")); /*내용 검색 입니다.*/
	        urlBuilder.append("&" + URLEncoder.encode("nowPageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*현재페이지번호기본 1*/
	        urlBuilder.append("&" + URLEncoder.encode("pageMg","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*한페이지에 보여줄 목록의 개수 기본 10*/
	        System.out.println(urlBuilder);
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/xml");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();
	        System.out.println(sb.toString());
	    }
	}
