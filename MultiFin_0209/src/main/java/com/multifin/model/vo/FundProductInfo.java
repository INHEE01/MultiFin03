package com.multifin.model.vo;

import java.util.Date;

public class FundProductInfo {
	private int fpino          ; // 일련번호
	private Date basDt         ; // 기준일자
	private String srtnCd      ; // 단축코드
	private String fndNm       ; // 펀드명
	private String ctg         ; // 구분
	private Date setpDt        ; // 설정일  (펀드의 탄생일)
	private String fndTp       ; // 펀드유형 
	private String prdClsfCd   ; // 상품분류코드
	private String asoStdCd    ; // 협회표준코드
	public FundProductInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FundProductInfo(int fpino, Date basDt, String srtnCd, String fndNm, String ctg, Date setpDt, String fndTp,
			String prdClsfCd, String asoStdCd) {
		super();
		this.fpino = fpino;
		this.basDt = basDt;
		this.srtnCd = srtnCd;
		this.fndNm = fndNm;
		this.ctg = ctg;
		this.setpDt = setpDt;
		this.fndTp = fndTp;
		this.prdClsfCd = prdClsfCd;
		this.asoStdCd = asoStdCd;
	}
	@Override
	public String toString() {
		return "FundProductInfo [fpino=" + fpino + ", basDt=" + basDt + ", srtnCd=" + srtnCd + ", fndNm=" + fndNm
				+ ", ctg=" + ctg + ", setpDt=" + setpDt + ", fndTp=" + fndTp + ", prdClsfCd=" + prdClsfCd
				+ ", asoStdCd=" + asoStdCd + "]";
	}
	public int getFpino() {
		return fpino;
	}
	public void setFpino(int fpino) {
		this.fpino = fpino;
	}
	public Date getBasDt() {
		return basDt;
	}
	public void setBasDt(Date basDt) {
		this.basDt = basDt;
	}
	public String getSrtnCd() {
		return srtnCd;
	}
	public void setSrtnCd(String srtnCd) {
		this.srtnCd = srtnCd;
	}
	public String getFndNm() {
		return fndNm;
	}
	public void setFndNm(String fndNm) {
		this.fndNm = fndNm;
	}
	public String getCtg() {
		return ctg;
	}
	public void setCtg(String ctg) {
		this.ctg = ctg;
	}
	public Date getSetpDt() {
		return setpDt;
	}
	public void setSetpDt(Date setpDt) {
		this.setpDt = setpDt;
	}
	public String getFndTp() {
		return fndTp;
	}
	public void setFndTp(String fndTp) {
		this.fndTp = fndTp;
	}
	public String getPrdClsfCd() {
		return prdClsfCd;
	}
	public void setPrdClsfCd(String prdClsfCd) {
		this.prdClsfCd = prdClsfCd;
	}
	public String getAsoStdCd() {
		return asoStdCd;
	}
	public void setAsoStdCd(String asoStdCd) {
		this.asoStdCd = asoStdCd;
	}
}
