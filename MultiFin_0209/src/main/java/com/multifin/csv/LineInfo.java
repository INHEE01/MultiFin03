package com.multifin.csv;

import java.util.List;

//순번,	법무법인명,		주소
//1,	법무법인(유한)정진,"서울특별시 서초구 서초대로 396 (서초동, 강남빌딩) 20층"
public class LineInfo {
	private List<String> header;
	private List<String> info;

	public LineInfo() {
		super();
	}

	public LineInfo(List<String> header, List<String> info) {
		super();
		this.header = header;
		this.info = info;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<String> getInfo() {
		return info;
	}

	public void setInfo(List<String> info) {
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i =0; i<header.size(); i++) {
			sb.append(header.get(i) + ":" + info.get(i)+", ");
		}
		return sb.toString();
	}
	
	public String getData(String key) {
		int index = header.indexOf(key);
		if (index > -1) {
			return info.get(index);
		} else {
			return null;
		}
	}
}