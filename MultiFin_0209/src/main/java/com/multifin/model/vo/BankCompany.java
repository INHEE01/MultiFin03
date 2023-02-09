package com.multifin.model.vo;

public class BankCompany {
	private int bankCompanyNo;			// 일련번호 (PK)
	private String dcls_month; 			// 공시 제출월 [YYYYMM]
	private String fin_co_no; 			// 금융회사코드
	private String kor_co_nm; 			// 금융회사 명
	private String dcls_chrg_man;		// 공시담당자
	private String homp_url; 			// 홈페이지주소
	private String cal_tel; 			// 콜센터전화번호

	private int area_cd; 				// 지역구분 | 01~17
	private String area_nm; 			// 지역이름 | 서울, 부산, 대구, 인천, 광주, 대전, 울산, 세종, 경기, 강원, 충북, 충남, 전북, 전남, 경북, 경남, 제주
	private String exis_yn; 			// 점포소재여부

	public BankCompany() {
		super();
	}

	public BankCompany(int bankCompanyNo, String dcls_month, String fin_co_no, String kor_co_nm, String dcls_chrg_man,
			String homp_url, String cal_tel, int area_cd, String area_nm, String exis_yn) {
		super();
		this.bankCompanyNo = bankCompanyNo;
		this.dcls_month = dcls_month;
		this.fin_co_no = fin_co_no;
		this.kor_co_nm = kor_co_nm;
		this.dcls_chrg_man = dcls_chrg_man;
		this.homp_url = homp_url;
		this.cal_tel = cal_tel;
		this.area_cd = area_cd;
		this.area_nm = area_nm;
		this.exis_yn = exis_yn;
	}

	@Override
	public String toString() {
		return "BankCompany [bankCompanyNo=" + bankCompanyNo + ", dcls_month=" + dcls_month + ", fin_co_no=" + fin_co_no
				+ ", kor_co_nm=" + kor_co_nm + ", dcls_chrg_man=" + dcls_chrg_man + ", homp_url=" + homp_url
				+ ", cal_tel=" + cal_tel + ", area_cd=" + area_cd + ", area_nm=" + area_nm + ", exis_yn=" + exis_yn
				+ "]";
	}

	public int getBankCompanyNo() {
		return bankCompanyNo;
	}

	public void setBankCompanyNo(int bankCompanyNo) {
		this.bankCompanyNo = bankCompanyNo;
	}

	public String getDcls_month() {
		return dcls_month;
	}

	public void setDcls_month(String dcls_month) {
		this.dcls_month = dcls_month;
	}

	public String getFin_co_no() {
		return fin_co_no;
	}

	public void setFin_co_no(String fin_co_no) {
		this.fin_co_no = fin_co_no;
	}

	public String getKor_co_nm() {
		return kor_co_nm;
	}

	public void setKor_co_nm(String kor_co_nm) {
		this.kor_co_nm = kor_co_nm;
	}

	public String getDcls_chrg_man() {
		return dcls_chrg_man;
	}

	public void setDcls_chrg_man(String dcls_chrg_man) {
		this.dcls_chrg_man = dcls_chrg_man;
	}

	public String getHomp_url() {
		return homp_url;
	}

	public void setHomp_url(String homp_url) {
		this.homp_url = homp_url;
	}

	public String getCal_tel() {
		return cal_tel;
	}

	public void setCal_tel(String cal_tel) {
		this.cal_tel = cal_tel;
	}

	public int getArea_cd() {
		return area_cd;
	}

	public void setArea_cd(int area_cd) {
		this.area_cd = area_cd;
	}

	public String getArea_nm() {
		return area_nm;
	}

	public void setArea_nm(String area_nm) {
		this.area_nm = area_nm;
	}

	public String getExis_yn() {
		return exis_yn;
	}

	public void setExis_yn(String exis_yn) {
		this.exis_yn = exis_yn;
	}
	
	
}
