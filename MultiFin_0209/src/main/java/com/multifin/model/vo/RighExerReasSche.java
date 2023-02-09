package com.multifin.model.vo;

import java.util.Date;

public class RighExerReasSche {
	private int rersno                    ;
	private Date basDt                    ;
	private String crno                   ;
	private String issuCmpyKsdCustNo      ;
	private Date nmlsLckEdDt              ;
	private Date nmlsLckSttgDt            ;
	private Date rgtExertEdDt             ;
	private String rgtExertRcd            ;
	private String rgtExertRcdNm          ;
	private Date rgtExertSttgDt           ;
	private String scrsIssuMnbdCd         ;
	private String scrsIssuMnbdCdNm       ;
	private String stckIssuCmpyNm         ;
	private String stckIssuRcd            ;
	private String stckIssuRcdNm          ;
	private String stckParPrc             ;
	private String stckStacMd             ;
	private String trsnmDptyDcd           ;
	private String trsnmDptyDcdNm         ;
	
	public RighExerReasSche() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RighExerReasSche(int rersno, Date basDt, String crno, String issuCmpyKsdCustNo, Date nmlsLckEdDt,
			Date nmlsLckSttgDt, Date rgtExertEdDt, String rgtExertRcd, String rgtExertRcdNm, Date rgtExertSttgDt,
			String scrsIssuMnbdCd, String scrsIssuMnbdCdNm, String stckIssuCmpyNm, String stckIssuRcd,
			String stckIssuRcdNm, String stckParPrc, String stckStacMd, String trsnmDptyDcd, String trsnmDptyDcdNm) {
		super();
		this.rersno = rersno;
		this.basDt = basDt;
		this.crno = crno;
		this.issuCmpyKsdCustNo = issuCmpyKsdCustNo;
		this.nmlsLckEdDt = nmlsLckEdDt;
		this.nmlsLckSttgDt = nmlsLckSttgDt;
		this.rgtExertEdDt = rgtExertEdDt;
		this.rgtExertRcd = rgtExertRcd;
		this.rgtExertRcdNm = rgtExertRcdNm;
		this.rgtExertSttgDt = rgtExertSttgDt;
		this.scrsIssuMnbdCd = scrsIssuMnbdCd;
		this.scrsIssuMnbdCdNm = scrsIssuMnbdCdNm;
		this.stckIssuCmpyNm = stckIssuCmpyNm;
		this.stckIssuRcd = stckIssuRcd;
		this.stckIssuRcdNm = stckIssuRcdNm;
		this.stckParPrc = stckParPrc;
		this.stckStacMd = stckStacMd;
		this.trsnmDptyDcd = trsnmDptyDcd;
		this.trsnmDptyDcdNm = trsnmDptyDcdNm;
	}

	@Override
	public String toString() {
		return "RighExerReasSche [rersno=" + rersno + ", basDt=" + basDt + ", crno=" + crno + ", issuCmpyKsdCustNo="
				+ issuCmpyKsdCustNo + ", nmlsLckEdDt=" + nmlsLckEdDt + ", nmlsLckSttgDt=" + nmlsLckSttgDt
				+ ", rgtExertEdDt=" + rgtExertEdDt + ", rgtExertRcd=" + rgtExertRcd + ", rgtExertRcdNm=" + rgtExertRcdNm
				+ ", rgtExertSttgDt=" + rgtExertSttgDt + ", scrsIssuMnbdCd=" + scrsIssuMnbdCd + ", scrsIssuMnbdCdNm="
				+ scrsIssuMnbdCdNm + ", stckIssuCmpyNm=" + stckIssuCmpyNm + ", stckIssuRcd=" + stckIssuRcd
				+ ", stckIssuRcdNm=" + stckIssuRcdNm + ", stckParPrc=" + stckParPrc + ", stckStacMd=" + stckStacMd
				+ ", trsnmDptyDcd=" + trsnmDptyDcd + ", trsnmDptyDcdNm=" + trsnmDptyDcdNm + "]";
	}

	public int getRersno() {
		return rersno;
	}

	public void setRersno(int rersno) {
		this.rersno = rersno;
	}

	public Date getBasDt() {
		return basDt;
	}

	public void setBasDt(Date basDt) {
		this.basDt = basDt;
	}

	public String getCrno() {
		return crno;
	}

	public void setCrno(String crno) {
		this.crno = crno;
	}

	public String getIssuCmpyKsdCustNo() {
		return issuCmpyKsdCustNo;
	}

	public void setIssuCmpyKsdCustNo(String issuCmpyKsdCustNo) {
		this.issuCmpyKsdCustNo = issuCmpyKsdCustNo;
	}

	public Date getNmlsLckEdDt() {
		return nmlsLckEdDt;
	}

	public void setNmlsLckEdDt(Date nmlsLckEdDt) {
		this.nmlsLckEdDt = nmlsLckEdDt;
	}

	public Date getNmlsLckSttgDt() {
		return nmlsLckSttgDt;
	}

	public void setNmlsLckSttgDt(Date nmlsLckSttgDt) {
		this.nmlsLckSttgDt = nmlsLckSttgDt;
	}

	public Date getRgtExertEdDt() {
		return rgtExertEdDt;
	}

	public void setRgtExertEdDt(Date rgtExertEdDt) {
		this.rgtExertEdDt = rgtExertEdDt;
	}

	public String getRgtExertRcd() {
		return rgtExertRcd;
	}

	public void setRgtExertRcd(String rgtExertRcd) {
		this.rgtExertRcd = rgtExertRcd;
	}

	public String getRgtExertRcdNm() {
		return rgtExertRcdNm;
	}

	public void setRgtExertRcdNm(String rgtExertRcdNm) {
		this.rgtExertRcdNm = rgtExertRcdNm;
	}

	public Date getRgtExertSttgDt() {
		return rgtExertSttgDt;
	}

	public void setRgtExertSttgDt(Date rgtExertSttgDt) {
		this.rgtExertSttgDt = rgtExertSttgDt;
	}

	public String getScrsIssuMnbdCd() {
		return scrsIssuMnbdCd;
	}

	public void setScrsIssuMnbdCd(String scrsIssuMnbdCd) {
		this.scrsIssuMnbdCd = scrsIssuMnbdCd;
	}

	public String getScrsIssuMnbdCdNm() {
		return scrsIssuMnbdCdNm;
	}

	public void setScrsIssuMnbdCdNm(String scrsIssuMnbdCdNm) {
		this.scrsIssuMnbdCdNm = scrsIssuMnbdCdNm;
	}

	public String getStckIssuCmpyNm() {
		return stckIssuCmpyNm;
	}

	public void setStckIssuCmpyNm(String stckIssuCmpyNm) {
		this.stckIssuCmpyNm = stckIssuCmpyNm;
	}

	public String getStckIssuRcd() {
		return stckIssuRcd;
	}

	public void setStckIssuRcd(String stckIssuRcd) {
		this.stckIssuRcd = stckIssuRcd;
	}

	public String getStckIssuRcdNm() {
		return stckIssuRcdNm;
	}

	public void setStckIssuRcdNm(String stckIssuRcdNm) {
		this.stckIssuRcdNm = stckIssuRcdNm;
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
