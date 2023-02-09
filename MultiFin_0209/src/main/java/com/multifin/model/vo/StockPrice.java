package com.multifin.model.vo;

import java.util.Date;
//[증권] 금융위원회_주식 시세 정보
public class StockPrice {
	private int sno                 ;	// 일련번호
	private Date basDt               ;	// 기준일. 기준 일자 
	private int srtnCd              ;	// 단축코드. 종목 코드보다 짧으면서 유일성이 보장되는 코드(6자리)
	private int isinCd              ; 	// 국제 채권 식별 번호. 유가증권(채권)의 국제인증 고유번호
	private String itmsNm           ; 	// 종목의 명칭
	private String mrktCtg          ; 	// 주식의 시장 구분 (KOSPI/KOSDAQ/KONEX 중 1)
	private String clpr             ; 	// 정규시장의 매매시간 종료시까지 형성되는 최종가격
	private String vs               ; 	// 전일 대비 등락
	private String fltRt            ; 	// 전일 대비 등락에 따른 비율
	private int mkp              ; 		// 정규시장의 매매시간 개시 후 형성되는 최초가격
	private int hipr             ; 		// 하루 중 가격의 최고치
	private int lopr             ; 		// 하루 중 가격의 최저치
	private int trqu             ;		// 거래량. 체결수량의 누적 합계
	private long trPrc            ;		// 거래대금. 거래건 별 체결가격 * 체결수량의 누적 합계
	private long lstgStCnt        ;	// 상장주식수. 종목의 상장주식수
	private long mrktTotAmt       ;	// 시가총액. 종가 * 상장주식수
	
	public StockPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockPrice(int sno, Date basDt, int srtnCd, int isinCd, String itmsNm, String mrktCtg, String clpr,
			String vs, String fltRt, int mkp, int hipr, int lopr, int trqu, long trPrc, long lstgStCnt,
			long mrktTotAmt) {
		super();
		this.sno = sno;
		this.basDt = basDt;
		this.srtnCd = srtnCd;
		this.isinCd = isinCd;
		this.itmsNm = itmsNm;
		this.mrktCtg = mrktCtg;
		this.clpr = clpr;
		this.vs = vs;
		this.fltRt = fltRt;
		this.mkp = mkp;
		this.hipr = hipr;
		this.lopr = lopr;
		this.trqu = trqu;
		this.trPrc = trPrc;
		this.lstgStCnt = lstgStCnt;
		this.mrktTotAmt = mrktTotAmt;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public Date getBasDt() {
		return basDt;
	}

	public void setBasDt(Date basDt) {
		this.basDt = basDt;
	}

	public int getSrtnCd() {
		return srtnCd;
	}

	public void setSrtnCd(int srtnCd) {
		this.srtnCd = srtnCd;
	}

	public int getIsinCd() {
		return isinCd;
	}

	public void setIsinCd(int isinCd) {
		this.isinCd = isinCd;
	}

	public String getItmsNm() {
		return itmsNm;
	}

	public void setItmsNm(String itmsNm) {
		this.itmsNm = itmsNm;
	}

	public String getMrktCtg() {
		return mrktCtg;
	}

	public void setMrktCtg(String mrktCtg) {
		this.mrktCtg = mrktCtg;
	}

	public String getClpr() {
		return clpr;
	}

	public void setClpr(String clpr) {
		this.clpr = clpr;
	}

	public String getVs() {
		return vs;
	}

	public void setVs(String vs) {
		this.vs = vs;
	}

	public String getFltRt() {
		return fltRt;
	}

	public void setFltRt(String fltRt) {
		this.fltRt = fltRt;
	}

	public int getMkp() {
		return mkp;
	}

	public void setMkp(int mkp) {
		this.mkp = mkp;
	}

	public int getHipr() {
		return hipr;
	}

	public void setHipr(int hipr) {
		this.hipr = hipr;
	}

	public int getLopr() {
		return lopr;
	}

	public void setLopr(int lopr) {
		this.lopr = lopr;
	}

	public int getTrqu() {
		return trqu;
	}

	public void setTrqu(int trqu) {
		this.trqu = trqu;
	}

	public long getTrPrc() {
		return trPrc;
	}

	public void setTrPrc(long trPrc) {
		this.trPrc = trPrc;
	}

	public long getLstgStCnt() {
		return lstgStCnt;
	}

	public void setLstgStCnt(long lstgStCnt) {
		this.lstgStCnt = lstgStCnt;
	}

	public long getMrktTotAmt() {
		return mrktTotAmt;
	}

	public void setMrktTotAmt(long mrktTotAmt) {
		this.mrktTotAmt = mrktTotAmt;
	}

	@Override
	public String toString() {
		return "StockPrice [sno=" + sno + ", srtnCd=" + srtnCd + ", isinCd=" + isinCd + ", itmsNm=" + itmsNm
				+ ", mrktCtg=" + mrktCtg + ", clpr=" + clpr + ", vs=" + vs + ", fltRt=" + fltRt + ", mkp=" + mkp
				+ ", hipr=" + hipr + ", lopr=" + lopr + ", trqu=" + trqu + ", trPrc=" + trPrc + ", lstgStCnt="
				+ lstgStCnt + ", mrktTotAmt=" + mrktTotAmt + "]";
	}

}
