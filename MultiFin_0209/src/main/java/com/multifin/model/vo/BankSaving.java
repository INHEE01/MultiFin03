package com.multifin.model.vo;

import java.util.Date;

public class BankSaving {
	private int bankSavingNo;	// 일련번호
	private String dcls_month; // 공시 제출월 [YYYYMM]
	private String fin_co_no; // 금융회사 코드
	private String kor_co_nm; // 금융회사명
	private String fin_prdt_cd; // 금융상품 코드
	private String fin_prdt_nm; // 금융 상품명
	private String join_way; // 가입 방법
	private String mtrt_int; // 만기 후 이자율
	private String spcl_cnd; // 우대조건
	private String join_deny; // 가입제한 Ex) 1:제한없음, 2:서민전용, 3:일부제한"
	private String join_member; // 가입대상
	private String etc_note; // 기타 유의사항
	private long max_limit; // 최고한도
	private Date dcls_strt_day; // 공시 시작일
	private String dcls_end_day; // 공시 종료일
	private Date fin_co_subm_day; // 금융회사 제출일 [YYYYMMDDHH24MI]

	private String intr_rate_type; // 저축 금리 유형
	private String intr_rate_type_nm; // 저축 금리 유형명
	private String rsrv_type; // 적립 유형
	private String rsrv_type_nm; // 적립 유형명
	private String save_trm; // 저축 기간 [단위: 개월]
	private long intr_rate; // 저축 금리 [소수점 2자리]
	private long intr_rate2; // 최고 우대금리 [소수점 2자리]

	public BankSaving() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BankSaving(int bankSavingNo, String dcls_month, String fin_co_no, String kor_co_nm, String fin_prdt_cd,
			String fin_prdt_nm, String join_way, String mtrt_int, String spcl_cnd, String join_deny, String join_member,
			String etc_note, long max_limit, Date dcls_strt_day, String dcls_end_day, Date fin_co_subm_day,
			String intr_rate_type, String intr_rate_type_nm, String rsrv_type, String rsrv_type_nm, String save_trm,
			long intr_rate, long intr_rate2) {
		super();
		this.bankSavingNo = bankSavingNo;
		this.dcls_month = dcls_month;
		this.fin_co_no = fin_co_no;
		this.kor_co_nm = kor_co_nm;
		this.fin_prdt_cd = fin_prdt_cd;
		this.fin_prdt_nm = fin_prdt_nm;
		this.join_way = join_way;
		this.mtrt_int = mtrt_int;
		this.spcl_cnd = spcl_cnd;
		this.join_deny = join_deny;
		this.join_member = join_member;
		this.etc_note = etc_note;
		this.max_limit = max_limit;
		this.dcls_strt_day = dcls_strt_day;
		this.dcls_end_day = dcls_end_day;
		this.fin_co_subm_day = fin_co_subm_day;
		this.intr_rate_type = intr_rate_type;
		this.intr_rate_type_nm = intr_rate_type_nm;
		this.rsrv_type = rsrv_type;
		this.rsrv_type_nm = rsrv_type_nm;
		this.save_trm = save_trm;
		this.intr_rate = intr_rate;
		this.intr_rate2 = intr_rate2;
	}

	@Override
	public String toString() {
		return "BankSaving [bankSavingNo=" + bankSavingNo + ", dcls_month=" + dcls_month + ", fin_co_no=" + fin_co_no
				+ ", kor_co_nm=" + kor_co_nm + ", fin_prdt_cd=" + fin_prdt_cd + ", fin_prdt_nm=" + fin_prdt_nm
				+ ", join_way=" + join_way + ", mtrt_int=" + mtrt_int + ", spcl_cnd=" + spcl_cnd + ", join_deny="
				+ join_deny + ", join_member=" + join_member + ", etc_note=" + etc_note + ", max_limit=" + max_limit
				+ ", dcls_strt_day=" + dcls_strt_day + ", dcls_end_day=" + dcls_end_day + ", fin_co_subm_day="
				+ fin_co_subm_day + ", intr_rate_type=" + intr_rate_type + ", intr_rate_type_nm=" + intr_rate_type_nm
				+ ", rsrv_type=" + rsrv_type + ", rsrv_type_nm=" + rsrv_type_nm + ", save_trm=" + save_trm
				+ ", intr_rate=" + intr_rate + ", intr_rate2=" + intr_rate2 + "]";
	}

	public int getBankSavingNo() {
		return bankSavingNo;
	}

	public void setBankSavingNo(int bankSavingNo) {
		this.bankSavingNo = bankSavingNo;
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

	public String getMtrt_int() {
		return mtrt_int;
	}

	public void setMtrt_int(String mtrt_int) {
		this.mtrt_int = mtrt_int;
	}

	public String getSpcl_cnd() {
		return spcl_cnd;
	}

	public void setSpcl_cnd(String spcl_cnd) {
		this.spcl_cnd = spcl_cnd;
	}

	public String getJoin_deny() {
		return join_deny;
	}

	public void setJoin_deny(String join_deny) {
		this.join_deny = join_deny;
	}

	public String getJoin_member() {
		return join_member;
	}

	public void setJoin_member(String join_member) {
		this.join_member = join_member;
	}

	public String getEtc_note() {
		return etc_note;
	}

	public void setEtc_note(String etc_note) {
		this.etc_note = etc_note;
	}

	public long getMax_limit() {
		return max_limit;
	}

	public void setMax_limit(long max_limit) {
		this.max_limit = max_limit;
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

	public String getIntr_rate_type() {
		return intr_rate_type;
	}

	public void setIntr_rate_type(String intr_rate_type) {
		this.intr_rate_type = intr_rate_type;
	}

	public String getIntr_rate_type_nm() {
		return intr_rate_type_nm;
	}

	public void setIntr_rate_type_nm(String intr_rate_type_nm) {
		this.intr_rate_type_nm = intr_rate_type_nm;
	}

	public String getRsrv_type() {
		return rsrv_type;
	}

	public void setRsrv_type(String rsrv_type) {
		this.rsrv_type = rsrv_type;
	}

	public String getRsrv_type_nm() {
		return rsrv_type_nm;
	}

	public void setRsrv_type_nm(String rsrv_type_nm) {
		this.rsrv_type_nm = rsrv_type_nm;
	}

	public String getSave_trm() {
		return save_trm;
	}

	public void setSave_trm(String save_trm) {
		this.save_trm = save_trm;
	}

	public long getIntr_rate() {
		return intr_rate;
	}

	public void setIntr_rate(long intr_rate) {
		this.intr_rate = intr_rate;
	}

	public long getIntr_rate2() {
		return intr_rate2;
	}

	public void setIntr_rate2(long intr_rate2) {
		this.intr_rate2 = intr_rate2;
	}
	
}
