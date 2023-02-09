package com.multifin.model.vo;

import java.util.Date;

public class StockDiviInfo {
	private int sdno                      ; // 일련번호
	private Date basDt                    ; // 기준일자	
	private Date cashDvdnPayDt            ; // 현금배당지급일자
	private String cashGrdnDvdnRt         ; // 현금차등배당률
	private String crno                   ; // 법인등록번호
	private Date dvdnBasDt                ; // 배당기준일자
	private String isinCd                 ; // ISIN코드
	private String isinCdNm               ; // ISIN코드명
	private String scrsItmsKcd            ; // 유가증권종목종류코드
	private String scrsItmsKcdNm          ; // 유가증권종목종류코드명
	private String stckDvdnRcd            ; // 주식배당사유코드
	private String stckDvdnRcdNm          ; // 주식배당사유코드명
	private String stckGenrCashDvdnRt     ; // 주식일반현금배당률
	private String stckGenrDvdnAmt        ; // 주식일반배당금액
	private String stckGenrDvdnRt         ; // 주식일반배당률
	private String stckGrdnDvdnAmt        ; // 주식차등배당금액	
	private String stckGrdnDvdnRt         ; // 주식차등배당률
	private Date stckHndvDt               ; // 주식교부일자	
	private String stckIssuCmpyNm         ; // 주식발행회사명	
	private String stckParPrc             ; // 주식액면가	
	private String stckStacMd             ; // 주식결산월일
	private String trsnmDptyDcd           ; // 명의개서대리인구분코드
	private String trsnmDptyDcdNm         ; // 명의개서대리인구분코드명
	
	public StockDiviInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StockDiviInfo(int sdno, Date basDt, Date cashDvdnPayDt, String cashGrdnDvdnRt, String crno, Date dvdnBasDt,
			String isinCd, String isinCdNm, String scrsItmsKcd, String scrsItmsKcdNm, String stckDvdnRcd,
			String stckDvdnRcdNm, String stckGenrCashDvdnRt, String stckGenrDvdnAmt, String stckGenrDvdnRt,
			String stckGrdnDvdnAmt, String stckGrdnDvdnRt, Date stckHndvDt, String stckIssuCmpyNm, String stckParPrc,
			String stckStacMd, String trsnmDptyDcd, String trsnmDptyDcdNm) {
		super();
		this.sdno = sdno;
		this.basDt = basDt;
		this.cashDvdnPayDt = cashDvdnPayDt;
		this.cashGrdnDvdnRt = cashGrdnDvdnRt;
		this.crno = crno;
		this.dvdnBasDt = dvdnBasDt;
		this.isinCd = isinCd;
		this.isinCdNm = isinCdNm;
		this.scrsItmsKcd = scrsItmsKcd;
		this.scrsItmsKcdNm = scrsItmsKcdNm;
		this.stckDvdnRcd = stckDvdnRcd;
		this.stckDvdnRcdNm = stckDvdnRcdNm;
		this.stckGenrCashDvdnRt = stckGenrCashDvdnRt;
		this.stckGenrDvdnAmt = stckGenrDvdnAmt;
		this.stckGenrDvdnRt = stckGenrDvdnRt;
		this.stckGrdnDvdnAmt = stckGrdnDvdnAmt;
		this.stckGrdnDvdnRt = stckGrdnDvdnRt;
		this.stckHndvDt = stckHndvDt;
		this.stckIssuCmpyNm = stckIssuCmpyNm;
		this.stckParPrc = stckParPrc;
		this.stckStacMd = stckStacMd;
		this.trsnmDptyDcd = trsnmDptyDcd;
		this.trsnmDptyDcdNm = trsnmDptyDcdNm;
	}

	@Override
	public String toString() {
		return "StockDiviInfo [sdno=" + sdno + ", basDt=" + basDt + ", cashDvdnPayDt=" + cashDvdnPayDt
				+ ", cashGrdnDvdnRt=" + cashGrdnDvdnRt + ", crno=" + crno + ", dvdnBasDt=" + dvdnBasDt + ", isinCd="
				+ isinCd + ", isinCdNm=" + isinCdNm + ", scrsItmsKcd=" + scrsItmsKcd + ", scrsItmsKcdNm="
				+ scrsItmsKcdNm + ", stckDvdnRcd=" + stckDvdnRcd + ", stckDvdnRcdNm=" + stckDvdnRcdNm
				+ ", stckGenrCashDvdnRt=" + stckGenrCashDvdnRt + ", stckGenrDvdnAmt=" + stckGenrDvdnAmt
				+ ", stckGenrDvdnRt=" + stckGenrDvdnRt + ", stckGrdnDvdnAmt=" + stckGrdnDvdnAmt + ", stckGrdnDvdnRt="
				+ stckGrdnDvdnRt + ", stckHndvDt=" + stckHndvDt + ", stckIssuCmpyNm=" + stckIssuCmpyNm + ", stckParPrc="
				+ stckParPrc + ", stckStacMd=" + stckStacMd + ", trsnmDptyDcd=" + trsnmDptyDcd + ", trsnmDptyDcdNm="
				+ trsnmDptyDcdNm + "]";
	}

	public int getSdno() {
		return sdno;
	}

	public void setSdno(int sdno) {
		this.sdno = sdno;
	}

	public Date getBasDt() {
		return basDt;
	}

	public void setBasDt(Date basDt) {
		this.basDt = basDt;
	}

	public Date getCashDvdnPayDt() {
		return cashDvdnPayDt;
	}

	public void setCashDvdnPayDt(Date cashDvdnPayDt) {
		this.cashDvdnPayDt = cashDvdnPayDt;
	}

	public String getCashGrdnDvdnRt() {
		return cashGrdnDvdnRt;
	}

	public void setCashGrdnDvdnRt(String cashGrdnDvdnRt) {
		this.cashGrdnDvdnRt = cashGrdnDvdnRt;
	}

	public String getCrno() {
		return crno;
	}

	public void setCrno(String crno) {
		this.crno = crno;
	}

	public Date getDvdnBasDt() {
		return dvdnBasDt;
	}

	public void setDvdnBasDt(Date dvdnBasDt) {
		this.dvdnBasDt = dvdnBasDt;
	}

	public String getIsinCd() {
		return isinCd;
	}

	public void setIsinCd(String isinCd) {
		this.isinCd = isinCd;
	}

	public String getIsinCdNm() {
		return isinCdNm;
	}

	public void setIsinCdNm(String isinCdNm) {
		this.isinCdNm = isinCdNm;
	}

	public String getScrsItmsKcd() {
		return scrsItmsKcd;
	}

	public void setScrsItmsKcd(String scrsItmsKcd) {
		this.scrsItmsKcd = scrsItmsKcd;
	}

	public String getScrsItmsKcdNm() {
		return scrsItmsKcdNm;
	}

	public void setScrsItmsKcdNm(String scrsItmsKcdNm) {
		this.scrsItmsKcdNm = scrsItmsKcdNm;
	}

	public String getStckDvdnRcd() {
		return stckDvdnRcd;
	}

	public void setStckDvdnRcd(String stckDvdnRcd) {
		this.stckDvdnRcd = stckDvdnRcd;
	}

	public String getStckDvdnRcdNm() {
		return stckDvdnRcdNm;
	}

	public void setStckDvdnRcdNm(String stckDvdnRcdNm) {
		this.stckDvdnRcdNm = stckDvdnRcdNm;
	}

	public String getStckGenrCashDvdnRt() {
		return stckGenrCashDvdnRt;
	}

	public void setStckGenrCashDvdnRt(String stckGenrCashDvdnRt) {
		this.stckGenrCashDvdnRt = stckGenrCashDvdnRt;
	}

	public String getStckGenrDvdnAmt() {
		return stckGenrDvdnAmt;
	}

	public void setStckGenrDvdnAmt(String stckGenrDvdnAmt) {
		this.stckGenrDvdnAmt = stckGenrDvdnAmt;
	}

	public String getStckGenrDvdnRt() {
		return stckGenrDvdnRt;
	}

	public void setStckGenrDvdnRt(String stckGenrDvdnRt) {
		this.stckGenrDvdnRt = stckGenrDvdnRt;
	}

	public String getStckGrdnDvdnAmt() {
		return stckGrdnDvdnAmt;
	}

	public void setStckGrdnDvdnAmt(String stckGrdnDvdnAmt) {
		this.stckGrdnDvdnAmt = stckGrdnDvdnAmt;
	}

	public String getStckGrdnDvdnRt() {
		return stckGrdnDvdnRt;
	}

	public void setStckGrdnDvdnRt(String stckGrdnDvdnRt) {
		this.stckGrdnDvdnRt = stckGrdnDvdnRt;
	}

	public Date getStckHndvDt() {
		return stckHndvDt;
	}

	public void setStckHndvDt(Date stckHndvDt) {
		this.stckHndvDt = stckHndvDt;
	}

	public String getStckIssuCmpyNm() {
		return stckIssuCmpyNm;
	}

	public void setStckIssuCmpyNm(String stckIssuCmpyNm) {
		this.stckIssuCmpyNm = stckIssuCmpyNm;
	}

	public String getStckParPrc() {
		return stckParPrc;
	}

	public void setStckParPrc(String stckParPrc) {
		this.stckParPrc = stckParPrc;
	}

	public String getStckStacMd() {
		return stckStacMd;
	}

	public void setStckStacMd(String stckStacMd) {
		this.stckStacMd = stckStacMd;
	}

	public String getTrsnmDptyDcd() {
		return trsnmDptyDcd;
	}

	public void setTrsnmDptyDcd(String trsnmDptyDcd) {
		this.trsnmDptyDcd = trsnmDptyDcd;
	}

	public String getTrsnmDptyDcdNm() {
		return trsnmDptyDcdNm;
	}

	public void setTrsnmDptyDcdNm(String trsnmDptyDcdNm) {
		this.trsnmDptyDcdNm = trsnmDptyDcdNm;
	}
}
