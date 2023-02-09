package com.multifin.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.NameList;

public class LawFirm {

	private List<LineInfo> LawFirmList = new ArrayList<>();
	private List<LineInfo> nameList = new ArrayList<>();
	
	// 법인ID - 법인 정보
	private Map<String, List<LineInfo>> LawFirmIDToNameListMap 
									= new HashMap<String, List<LineInfo>>();
	
//	// 법인ID - 법인 Line 정보
	private Map<String, LineInfo> nameIDToLineInfoMap 
											= new HashMap<String, LineInfo>();
//	
	public static void main(String[] args) {
		LawFirm Firm = new LawFirm();
		Firm.fileReadForLawFirm("법인정보.csv");
		Firm.makeMap(); // map 초기화 함수
		Firm.searchName("세계");
	}

	private void searchName(String nameKeyword) {
		int count = 0;
		for(LineInfo nameInfo : nameList) {
			String LawName = nameInfo.getData("법인명");
			if(LawName.contains(nameKeyword) == false) {
				continue;
			}
			count++;
			String nameId = nameInfo.getData("순번");
			System.out.println(nameInfo.toString());
			System.out.println(nameIDToLineInfoMap.get(nameId));
			System.out.println();
		}
		System.out.println("총 " + count+"번 탐색되었습니다.");
	}

	private void printLawFirmListAndName() {
		for(LineInfo info : LawFirmList) {
			System.out.println(info.toString());
			String id = info.getData("순번");
			List<LineInfo> NameList = LawFirmIDToNameListMap.get(id);
			for(LineInfo info2 : NameList) {
				System.out.println(info2);
			}
			System.out.println("--------------------------------------------------");
		}
	}
	
//	private void printLawFirmList(String lawName) {
//		for(LineInfo info : LawFirmList) {
//			String name = info.getData("법인명");
//			if(lawName.equals(name) == false) {
//				continue;
//			}
//			System.out.println(info.toString());
//			String id = info.getData("법인명");
//			List<LineInfo> nameList = LawFirmIDToNameListMap.get(id);
//			for(LineInfo info2 : nameList) {
//				System.out.println(info2);
//			}
//			System.out.println("--------------------------------------------------");
//		}
//	}
	private void printLawFirmListAndName(String lawName) {
		for(LineInfo info : LawFirmList) {
			String name = info.getData("법인명");
			if(lawName.equals(name) == false) {
				continue;
			}
			System.out.println(info.toString());
			String id = info.getData("법인명");
			List<LineInfo> nameList = LawFirmIDToNameListMap.get(id);
			for(LineInfo info2 : nameList) {
				System.out.println(info2);
			}
			System.out.println("--------------------------------------------------");
		}
	}

	void printLawFirmList() {
		for (int i = 0; i < LawFirmList.size(); i++) {
			System.out.println(LawFirmList.get(i).toString());
		}
	}

	void printNameList() {
		for (int i = 0; i < nameList.size(); i++) {
			System.out.println(nameList.get(i).toString());
		}
	}
	
	private void makeMap() {
		//법인 Line 정보
		// nameIDToLineInfoMap 
		// Java에서의 map은 DB 주키로 조회하는 것과 동일한 원리를 갖는다.
		for(int i = 0; i < nameList.size(); i++) {
			String id = nameList.get(i).getData("순번");
			nameIDToLineInfoMap.put(id, nameList.get(i));
		}
		//법인 리스트
		// LawFirmIDToNameListMap 생성
		for(int i = 0; i < LawFirmList.size(); i++) {
			LineInfo nameInfo = LawFirmList.get(i);
			String nameId = nameInfo.getData("순번");
			List<LineInfo> list = LawFirmIDToNameListMap.get(nameId);
			if(list == null) {
				list = new ArrayList<LineInfo>();
				LawFirmIDToNameListMap.put(nameId, list);
			}
			list.add(nameInfo);
		}
	}

	private void fileReadForName(String path) {
		nameList = makeCSVList(path, "UTF-8");
		for(LineInfo info : nameList) {
			System.out.println(info);
		}
	}

	private void fileReadForLawFirm(String path) {
		LawFirmList = makeCSVList(path, "EUC-KR");
		for(LineInfo info : LawFirmList) {
			System.out.println(info);
		}
	}
    
	// 이게 공통적으로 파싱하는 코드!
	private List<LineInfo> makeCSVList(String path, String charSet) {
		List<LineInfo> list = new ArrayList<>();
		
		try( FileReader fr = new FileReader(path, Charset.forName(charSet));
			 BufferedReader br = new BufferedReader(fr);
				) {
			String headerLine = br.readLine();
			List<String> headerList = csvLineToList(headerLine);
			
			String str = null;
			while((str = br.readLine()) != null) {
				List<String> lineList = csvLineToList(str);
				if(lineList == null) {
					continue;
				}
				LineInfo info = new LineInfo(headerList, lineList);
				list.add(info);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//34,법무법인새천년,"전라남도 목포시 용해동 807-1 1,2,3층"
	private List<String> csvLineToList(String csvLine) {
		try {
			String delemeter = ",";


			if (csvLine.contains(",\"") == true) {
				csvLine = filter(csvLine);
			}
	// 34,법무법인새천년,"전라남도 목포시 용해동 807-1 1,2,3층"
			
			List<String> list = new ArrayList<String>();
			String[] array = csvLine.split(delemeter);
			for(int i = 0; i<array.length; i++) {
				String str = array[i].replace("\"", "").strip().replace("_", ",").strip();
				if (str.contains("주소")) {
					str = str.substring(1, str.length());
				}
				list.add(str);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private String filter(String str) {
		StringBuffer sb = new StringBuffer(str);
		StringBuffer newsb = new StringBuffer();
		
		boolean in = false;
		for(int i = 0; i < sb.length(); i++) {
			char value = sb.charAt(i);
			if(value == '\"') {
				in = !in;
			}
			if(in == true) {
				if(value == ',') {
					value = '_';
				}
			}
			newsb.append(value);
		}
		return newsb.toString();
	}
	
}
