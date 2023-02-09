package com.multifin.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.multifin.model.vo.MarkerParsing;

public class RealEstateDealAPI2 {
	
public static void main(String[] args) throws org.json.simple.parser.ParseException, IOException {
//	MarkerParsing("삼평동 624");
}
	
public static List<MarkerParsing> MarkerParsing(String address) throws IOException, ParseException {
	List<MarkerParsing> list = new ArrayList<>();

	String apikey = "8DF94013-FA81-3765-9A06-CA75A42DAAFC";
	String searchType = "parcel";
	String searchAddr = address;
	String epsg = "epsg:4326";

	StringBuilder sb = new StringBuilder("https://api.vworld.kr/req/address");
	sb.append("?service=address");
	sb.append("&request=getCoord");
	sb.append("&format=json");
	sb.append("&crs=" + epsg);
	sb.append("&key=" + apikey);
	sb.append("&type=" + searchType);
	sb.append("&address=" + URLEncoder.encode(searchAddr, StandardCharsets.UTF_8));

	try{
	    URL url = new URL(sb.toString());
	    BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8));

	    JSONParser jspa = new JSONParser();
	    JSONObject jsob = (JSONObject) jspa.parse(reader);
	    JSONObject jsrs = (JSONObject) jsob.get("response");
	    JSONObject jsResult = (JSONObject) jsrs.get("result");
	    Object x = "127.07539274753";
		Object y = "37.4941970687363";
	    try {
	    	JSONObject jspoint = (JSONObject) jsResult.get("point");
	    	x = jspoint.get("x");
	    	y = jspoint.get("y");
		} catch (Exception e) {
			 MarkerParsing mp= new MarkerParsing(0,searchAddr,x, y);
			 System.out.println(""+mp.toString());
			 e.printStackTrace();
		}
	    
	    int rno = 0;
	    MarkerParsing mp= new MarkerParsing(rno,searchAddr,x, y);
	    list.add(mp);
	    System.out.println(list);
	} catch (IOException e) {
	    throw new RuntimeException(e);
	}
	
	return list;
}
}
