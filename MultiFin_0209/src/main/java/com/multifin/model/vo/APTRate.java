package com.multifin.model.vo;

public class APTRate {

	private int aptRateNo;
	private int house_manage_no ; //주택관리번호
	private int pblanc_no ; //공고번호
	private String house_ty; //주택형
	private String reside_senm   ; //거주지역
	private int subscrpt_rank_code   ; //순위
	private int suply_hshldco  ; //공급세대수
	private String req_cnt    ; //접수건수
	private String cmpet_rate ; //경쟁률
	private int lwet_score ; //최저당첨가점
	private int top_score  ; //최고당첨가점
	private int avrg_score; //평균당첨가점
	public APTRate() {
		super();
		// TODO Auto-generated constructor stub
	}
	public APTRate(int aptRateNo, int house_manage_no, int pblanc_no, String house_ty, String reside_senm,
			int subscrpt_rank_code, int suply_hshldco, String req_cnt, String cmpet_rate, int lwet_score,
			int top_score, int avrg_score) {
		super();
		this.aptRateNo = aptRateNo;
		this.house_manage_no = house_manage_no;
		this.pblanc_no = pblanc_no;
		this.house_ty = house_ty;
		this.reside_senm = reside_senm;
		this.subscrpt_rank_code = subscrpt_rank_code;
		this.suply_hshldco = suply_hshldco;
		this.req_cnt = req_cnt;
		this.cmpet_rate = cmpet_rate;
		this.lwet_score = lwet_score;
		this.top_score = top_score;
		this.avrg_score = avrg_score;
	}
	@Override
	public String toString() {
		return "APTRate [aptRateNo=" + aptRateNo + ", house_manage_no=" + house_manage_no + ", pblanc_no=" + pblanc_no
				+ ", house_ty=" + house_ty + ", reside_senm=" + reside_senm + ", subscrpt_rank_code="
				+ subscrpt_rank_code + ", suply_hshldco=" + suply_hshldco + ", req_cnt=" + req_cnt + ", cmpet_rate="
				+ cmpet_rate + ", lwet_score=" + lwet_score + ", top_score=" + top_score + ", avrg_score=" + avrg_score
				+ "]";
	}
	public int getAptRateNo() {
		return aptRateNo;
	}
	public void setAptRateNo(int aptRateNo) {
		this.aptRateNo = aptRateNo;
	}
	public int getHouse_manage_no() {
		return house_manage_no;
	}
	public void setHouse_manage_no(int house_manage_no) {
		this.house_manage_no = house_manage_no;
	}
	public int getPblanc_no() {
		return pblanc_no;
	}
	public void setPblanc_no(int pblanc_no) {
		this.pblanc_no = pblanc_no;
	}
	public String getHouse_ty() {
		return house_ty;
	}
	public void setHouse_ty(String house_ty) {
		this.house_ty = house_ty;
	}
	public String getReside_senm() {
		return reside_senm;
	}
	public void setReside_senm(String reside_senm) {
		this.reside_senm = reside_senm;
	}
	public int getSubscrpt_rank_code() {
		return subscrpt_rank_code;
	}
	public void setSubscrpt_rank_code(int subscrpt_rank_code) {
		this.subscrpt_rank_code = subscrpt_rank_code;
	}
	public int getSuply_hshldco() {
		return suply_hshldco;
	}
	public void setSuply_hshldco(int suply_hshldco) {
		this.suply_hshldco = suply_hshldco;
	}
	public String getReq_cnt() {
		return req_cnt;
	}
	public void setReq_cnt(String req_cnt) {
		this.req_cnt = req_cnt;
	}
	public String getCmpet_rate() {
		return cmpet_rate;
	}
	public void setCmpet_rate(String cmpet_rate) {
		this.cmpet_rate = cmpet_rate;
	}
	public int getLwet_score() {
		return lwet_score;
	}
	public void setLwet_score(int lwet_score) {
		this.lwet_score = lwet_score;
	}
	public int getTop_score() {
		return top_score;
	}
	public void setTop_score(int top_score) {
		this.top_score = top_score;
	}
	public int getAvrg_score() {
		return avrg_score;
	}
	public void setAvrg_score(int avrg_score) {
		this.avrg_score = avrg_score;
	}
	
	


}
