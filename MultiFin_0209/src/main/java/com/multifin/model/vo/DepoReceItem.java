package com.multifin.model.vo;

import java.util.Date;

public class DepoReceItem {
	private int drino                   ;
	private Date basDt                  ;
	private long crno                   ;
	private int drCnvrOrshCnt           ;
	private long drCnvrPsblLmtTsumCnt   ;
	private long drCnvrPsblStckCnt      ;
	private String drDcd                ;
	private String drDcdNm              ;
	private String drDpsgInstNm         ;
	private String drIssuCmpyNm         ;
	private String drXchgDcd            ;
	private String drXchgDcdNm          ;
	private String isinCd               ;
	private String isinCdNm             ;
	private String itmsShrtnCd          ;
	private String itmsShrtnCdNm        ;
	private String orshDrRto            ;
	private String orshIsinCd           ;
	private String orshIsinCdNm         ;
	private String stckKcd              ;
	private String stckKcdNm            ;
	
	public DepoReceItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DepoReceItem(int drino, Date basDt, long crno, int drCnvrOrshCnt, long drCnvrPsblLmtTsumCnt,
			long drCnvrPsblStckCnt, String drDcd, String drDcdNm, String drDpsgInstNm, String drIssuCmpyNm,
			String drXchgDcd, String drXchgDcdNm, String isinCd, String isinCdNm, String itmsShrtnCd,
			String itmsShrtnCdNm, String orshDrRto, String orshIsinCd, String orshIsinCdNm, String stckKcd,
			String stckKcdNm) {
		super();
		this.drino = drino;
		this.basDt = basDt;
		this.crno = crno;
		this.drCnvrOrshCnt = drCnvrOrshCnt;
		this.drCnvrPsblLmtTsumCnt = drCnvrPsblLmtTsumCnt;
		this.drCnvrPsblStckCnt = drCnvrPsblStckCnt;
		this.drDcd = drDcd;
		this.drDcdNm = drDcdNm;
		this.drDpsgInstNm = drDpsgInstNm;
		this.drIssuCmpyNm = drIssuCmpyNm;
		this.drXchgDcd = drXchgDcd;
		this.drXchgDcdNm = drXchgDcdNm;
		this.isinCd = isinCd;
		this.isinCdNm = isinCdNm;
		this.itmsShrtnCd = itmsShrtnCd;
		this.itmsShrtnCdNm = itmsShrtnCdNm;
		this.orshDrRto = orshDrRto;
		this.orshIsinCd = orshIsinCd;
		this.orshIsinCdNm = orshIsinCdNm;
		this.stckKcd = stckKcd;
		this.stckKcdNm = stckKcdNm;
	}
	
	@Override
	public String toString() {
		return "DepoReceItem [drino=" + drino + ", crno=" + crno + ", drCnvrOrshCnt=" + drCnvrOrshCnt
				+ ", drCnvrPsblLmtTsumCnt=" + drCnvrPsblLmtTsumCnt + ", drCnvrPsblStckCnt=" + drCnvrPsblStckCnt
				+ ", drDcd=" + drDcd + ", drDcdNm=" + drDcdNm + ", drDpsgInstNm=" + drDpsgInstNm + ", drIssuCmpyNm="
				+ drIssuCmpyNm + ", drXchgDcd=" + drXchgDcd + ", drXchgDcdNm=" + drXchgDcdNm + ", isinCd=" + isinCd
				+ ", isinCdNm=" + isinCdNm + ", itmsShrtnCd=" + itmsShrtnCd + ", itmsShrtnCdNm=" + itmsShrtnCdNm
				+ ", orshDrRto=" + orshDrRto + ", orshIsinCd=" + orshIsinCd + ", orshIsinCdNm=" + orshIsinCdNm
				+ ", stckKcd=" + stckKcd + ", stckKcdNm=" + stckKcdNm + "]";
	}
	
	public int getDrino() {
		return drino;
	}
	public void setDrino(int drino) {
		this.drino = drino;
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
	public int getDrCnvrOrshCnt() {
		return drCnvrOrshCnt;
	}
	public void setDrCnvrOrshCnt(int drCnvrOrshCnt) {
		this.drCnvrOrshCnt = drCnvrOrshCnt;
	}
	public long getDrCnvrPsblLmtTsumCnt() {
		return drCnvrPsblLmtTsumCnt;
	}
	public void setDrCnvrPsblLmtTsumCnt(long drCnvrPsblLmtTsumCnt) {
		this.drCnvrPsblLmtTsumCnt = drCnvrPsblLmtTsumCnt;
	}
	public long getDrCnvrPsblStckCnt() {
		return drCnvrPsblStckCnt;
	}
	public void setDrCnvrPsblStckCnt(long drCnvrPsblStckCnt) {
		this.drCnvrPsblStckCnt = drCnvrPsblStckCnt;
	}
	public String getDrDcd() {
		return drDcd;
	}
	public void setDrDcd(String drDcd) {
		this.drDcd = drDcd;
	}
	public String getDrDcdNm() {
		return drDcdNm;
	}
	public void setDrDcdNm(String drDcdNm) {
		this.drDcdNm = drDcdNm;
	}
	public String getDrDpsgInstNm() {
		return drDpsgInstNm;
	}
	public void setDrDpsgInstNm(String drDpsgInstNm) {
		this.drDpsgInstNm = drDpsgInstNm;
	}
	public String getDrIssuCmpyNm() {
		return drIssuCmpyNm;
	}
	public void setDrIssuCmpyNm(String drIssuCmpyNm) {
		this.drIssuCmpyNm = drIssuCmpyNm;
	}
	public String getDrXchgDcd() {
		return drXchgDcd;
	}
	public void setDrXchgDcd(String drXchgDcd) {
		this.drXchgDcd = drXchgDcd;
	}
	public String getDrXchgDcdNm() {
		return drXchgDcdNm;
	}
	public void setDrXchgDcdNm(String drXchgDcdNm) {
		this.drXchgDcdNm = drXchgDcdNm;
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
	public String getItmsShrtnCd() {
		return itmsShrtnCd;
	}
	public void setItmsShrtnCd(String itmsShrtnCd) {
		this.itmsShrtnCd = itmsShrtnCd;
	}
	public String getItmsShrtnCdNm() {
		return itmsShrtnCdNm;
	}
	public void setItmsShrtnCdNm(String itmsShrtnCdNm) {
		this.itmsShrtnCdNm = itmsShrtnCdNm;
	}
	public String getOrshDrRto() {
		return orshDrRto;
	}
	public void setOrshDrRto(String orshDrRto) {
		this.orshDrRto = orshDrRto;
	}
	public String getOrshIsinCd() {
		return orshIsinCd;
	}
	public void setOrshIsinCd(String orshIsinCd) {
		this.orshIsinCd = orshIsinCd;
	}
	public String getOrshIsinCdNm() {
		return orshIsinCdNm;
	}
	public void setOrshIsinCdNm(String orshIsinCdNm) {
		this.orshIsinCdNm = orshIsinCdNm;
	}
	public String getStckKcd() {
		return stckKcd;
	}
	public void setStckKcd(String stckKcd) {
		this.stckKcd = stckKcd;
	}
	public String getStckKcdNm() {
		return stckKcdNm;
	}
	public void setStckKcdNm(String stckKcdNm) {
		this.stckKcdNm = stckKcdNm;
	}
}
