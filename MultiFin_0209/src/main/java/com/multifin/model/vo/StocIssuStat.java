package com.multifin.model.vo;

import java.util.Date;

public class StocIssuStat {
	private int sisno; // 일련번호
	private Date basDt             ; // 기준일자
	private long crno            ; // 법인등록번호
	private long onskTisuCnt     ; // 주식발행회사명
	private int pfstTisuCnt     ; // 보통주총발행수
	private String stckIssuCmpyNm  ; // 우선주총발행수
	
	public StocIssuStat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StocIssuStat(int sisno, Date basDt, long crno, long onskTisuCnt, int pfstTisuCnt, String stckIssuCmpyNm) {
		super();
		this.sisno = sisno;
		this.basDt = basDt;
		this.crno = crno;
		this.onskTisuCnt = onskTisuCnt;
		this.pfstTisuCnt = pfstTisuCnt;
		this.stckIssuCmpyNm = stckIssuCmpyNm;
	}

	public int getSisno() {
		return sisno;
	}



	public void setSisno(int sisno) {
		this.sisno = sisno;
	}

	@Override
	public String toString() {
		return "StockPublishStatus [basDt=" + basDt + ", crno=" + crno + ", onskTisuCnt=" + onskTisuCnt
				+ ", pfstTisuCnt=" + pfstTisuCnt + ", stckIssuCmpyNm=" + stckIssuCmpyNm + "]";
	}

	public Date getBasDt() {
		return basDt;
	}

	public void setBasDt(Date basDt) {
		this.basDt = basDt;
	}

	public long getCrno() {
		return crno;
	}

	public void setCrno(long crno) {
		this.crno = crno;
	}

	public long getOnskTisuCnt() {
		return onskTisuCnt;
	}

	public void setOnskTisuCnt(long onskTisuCnt) {
		this.onskTisuCnt = onskTisuCnt;
	}

	public int getPfstTisuCnt() {
		return pfstTisuCnt;
	}

	public void setPfstTisuCnt(int pfstTisuCnt) {
		this.pfstTisuCnt = pfstTisuCnt;
	}

	public String getStckIssuCmpyNm() {
		return stckIssuCmpyNm;
	}

	public void setStckIssuCmpyNm(String stckIssuCmpyNm) {
		this.stckIssuCmpyNm = stckIssuCmpyNm;
	}
	
	
}
