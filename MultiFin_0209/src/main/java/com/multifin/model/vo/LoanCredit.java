package com.multifin.model.vo;

import java.util.Date;

public class LoanCredit {
	private int loanCreditNo;	// 일련번호
	private String dcls_month; // 공시 제출월 [YYYYMM]
	private String fin_co_no; // 금융회사코드
	private String kor_co_nm; // 금융회사 명
	private String fin_prdt_cd; // 금융상품코드
	private String fin_prdt_nm; // 금융상품명
	private String join_way; // 가입방법
	private int crdt_prdt_type; // 	대출종류 코드
	private String crdt_prdt_type_nm; // 	대출종류명	
	private String cb_name; // 	CB 회사명
	private Date dcls_strt_day; // 공시 시작일
	private String dcls_end_day; // 공시 종료일
	private Date fin_co_subm_day; // 금융회사 제출일 [YYYYMMDDHH24MI]
	
	
	private String crdt_lend_rate_type; // 금리구분 코드
	private String crdt_lend_rate_type_nm; // 금리구분
	private double crdt_grad_1; // 900점 초과 [소수점 2자리]
	private double crdt_grad_4; // 801~900점 [소수점 2자리]
	private double crdt_grad_5; // 701~800점 [소수점 2자리]
	private double crdt_grad_6; // 601~700점 [소수점 2자리]
	private double crdt_grad_avg; // 평균 금리 [소수점 2자리]


	public LoanCredit() {
		super();
		// TODO Auto-generated constructor stub
	}


	public LoanCredit(int loanCreditNo, String dcls_month, String fin_co_no, String kor_co_nm, String fin_prdt_cd,
			String fin_prdt_nm, String join_way, int crdt_prdt_type, String crdt_prdt_type_nm, String cb_name,
			Date dcls_strt_day, String dcls_end_day, Date fin_co_subm_day, String crdt_lend_rate_type,
			String crdt_lend_rate_type_nm, double crdt_grad_1, double crdt_grad_4, double crdt_grad_5,
			double crdt_grad_6, double crdt_grad_avg) {
		super();
		this.loanCreditNo = loanCreditNo;
		this.dcls_month = dcls_month;
		this.fin_co_no = fin_co_no;
		this.kor_co_nm = kor_co_nm;
		this.fin_prdt_cd = fin_prdt_cd;
		this.fin_prdt_nm = fin_prdt_nm;
		this.join_way = join_way;
		this.crdt_prdt_type = crdt_prdt_type;
		this.crdt_prdt_type_nm = crdt_prdt_type_nm;
		this.cb_name = cb_name;
		this.dcls_strt_day = dcls_strt_day;
		this.dcls_end_day = dcls_end_day;
		this.fin_co_subm_day = fin_co_subm_day;
		this.crdt_lend_rate_type = crdt_lend_rate_type;
		this.crdt_lend_rate_type_nm = crdt_lend_rate_type_nm;
		this.crdt_grad_1 = crdt_grad_1;
		this.crdt_grad_4 = crdt_grad_4;
		this.crdt_grad_5 = crdt_grad_5;
		this.crdt_grad_6 = crdt_grad_6;
		this.crdt_grad_avg = crdt_grad_avg;
	}


	public int getLoanCreditNo() {
		return loanCreditNo;
	}


	public void setLoanCreditNo(int loanCreditNo) {
		this.loanCreditNo = loanCreditNo;
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


	public String getFin_prdt_cd() {
		return fin_prdt_cd;
	}


	public void setFin_prdt_cd(String fin_prdt_cd) {
		this.fin_prdt_cd = fin_prdt_cd;
	}


	public String getFin_prdt_nm() {
		return fin_prdt_nm;
	}


	public void setFin_prdt_nm(String fin_prdt_nm) {
		this.fin_prdt_nm = fin_prdt_nm;
	}


	public String getJoin_way() {
		return join_way;
	}


	public void setJoin_way(String join_way) {
		this.join_way = join_way;
	}


	public int getCrdt_prdt_type() {
		return crdt_prdt_type;
	}


	public void setCrdt_prdt_type(int crdt_prdt_type) {
		this.crdt_prdt_type = crdt_prdt_type;
	}


	public String getCrdt_prdt_type_nm() {
		return crdt_prdt_type_nm;
	}


	public void setCrdt_prdt_type_nm(String crdt_prdt_type_nm) {
		this.crdt_prdt_type_nm = crdt_prdt_type_nm;
	}


	public String getCb_name() {
		return cb_name;
	}


	public void setCb_name(String cb_name) {
		this.cb_name = cb_name;
	}


	public Date getDcls_strt_day() {
		return dcls_strt_day;
	}


	public void setDcls_strt_day(Date dcls_strt_day) {
		this.dcls_strt_day = dcls_strt_day;
	}


	public String getDcls_end_day() {
		return dcls_end_day;
	}


	public void setDcls_end_day(String dcls_end_day) {
		this.dcls_end_day = dcls_end_day;
	}


	public Date getFin_co_subm_day() {
		return fin_co_subm_day;
	}


	public void setFin_co_subm_day(Date fin_co_subm_day) {
		this.fin_co_subm_day = fin_co_subm_day;
	}


	public String getCrdt_lend_rate_type() {
		return crdt_lend_rate_type;
	}


	public void setCrdt_lend_rate_type(String crdt_lend_rate_type) {
		this.crdt_lend_rate_type = crdt_lend_rate_type;
	}


	public String getCrdt_lend_rate_type_nm() {
		return crdt_lend_rate_type_nm;
	}


	public void setCrdt_lend_rate_type_nm(String crdt_lend_rate_type_nm) {
		this.crdt_lend_rate_type_nm = crdt_lend_rate_type_nm;
	}


	public double getCrdt_grad_1() {
		return crdt_grad_1;
	}


	public void setCrdt_grad_1(double crdt_grad_1) {
		this.crdt_grad_1 = crdt_grad_1;
	}


	public double getCrdt_grad_4() {
		return crdt_grad_4;
	}


	public void setCrdt_grad_4(double crdt_grad_4) {
		this.crdt_grad_4 = crdt_grad_4;
	}


	public double getCrdt_grad_5() {
		return crdt_grad_5;
	}


	public void setCrdt_grad_5(double crdt_grad_5) {
		this.crdt_grad_5 = crdt_grad_5;
	}


	public double getCrdt_grad_6() {
		return crdt_grad_6;
	}


	public void setCrdt_grad_6(double crdt_grad_6) {
		this.crdt_grad_6 = crdt_grad_6;
	}


	public double getCrdt_grad_avg() {
		return crdt_grad_avg;
	}


	public void setCrdt_grad_avg(double crdt_grad_avg) {
		this.crdt_grad_avg = crdt_grad_avg;
	}


	@Override
	public String toString() {
		return "LoanCredit [loanCreditNo=" + loanCreditNo + ", dcls_month=" + dcls_month + ", fin_co_no=" + fin_co_no
				+ ", kor_co_nm=" + kor_co_nm + ", fin_prdt_cd=" + fin_prdt_cd + ", fin_prdt_nm=" + fin_prdt_nm
				+ ", join_way=" + join_way + ", crdt_prdt_type=" + crdt_prdt_type + ", crdt_prdt_type_nm="
				+ crdt_prdt_type_nm + ", cb_name=" + cb_name + ", dcls_strt_day=" + dcls_strt_day + ", dcls_end_day="
				+ dcls_end_day + ", fin_co_subm_day=" + fin_co_subm_day + ", crdt_lend_rate_type=" + crdt_lend_rate_type
				+ ", crdt_lend_rate_type_nm=" + crdt_lend_rate_type_nm + ", crdt_grad_1=" + crdt_grad_1
				+ ", crdt_grad_4=" + crdt_grad_4 + ", crdt_grad_5=" + crdt_grad_5 + ", crdt_grad_6=" + crdt_grad_6
				+ ", crdt_grad_avg=" + crdt_grad_avg + "]";
	}
	
	
}
