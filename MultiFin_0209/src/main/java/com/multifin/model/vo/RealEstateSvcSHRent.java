package com.multifin.model.vo;

import java.util.Date;

public class RealEstateSvcSHRent {
	private int RealEstateDealNo;
	private String Build_Year; // 건축년도
	private String Area; // 계약면적
	private String Deal_Year; // 년도
	private String Dong; // 법정동
	private String Deposit; // 보증금액
	private String Deal_Month; // 월
	private int Monthly_Rent; // 월세 금액
	private String Deal_Day; // 일
	private String Regional_Code; // 지역코드

	public RealEstateSvcSHRent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealEstateSvcSHRent(int realEstateDealNo, String build_Year, String area, String deal_Year, String dong,
			String deposit, String deal_Month, int monthly_Rent, String deal_Day, String regional_Code) {
		super();
		RealEstateDealNo = realEstateDealNo;
		Build_Year = build_Year;
		Area = area;
		Deal_Year = deal_Year;
		Dong = dong;
		Deposit = deposit;
		Deal_Month = deal_Month;
		Monthly_Rent = monthly_Rent;
		Deal_Day = deal_Day;
		Regional_Code = regional_Code;
	}

	@Override
	public String toString() {
		return "RealEstateSvcSHRent [RealEstateDealNo=" + RealEstateDealNo + ", Build_Year=" + Build_Year + ", Area="
				+ Area + ", Deal_Year=" + Deal_Year + ", Dong=" + Dong + ", Deposit=" + Deposit + ", Deal_Month="
				+ Deal_Month + ", Monthly_Rent=" + Monthly_Rent + ", Deal_Day=" + Deal_Day + ", Regional_Code="
				+ Regional_Code + "]";
	}

	public int getRealEstateDealNo() {
		return RealEstateDealNo;
	}

	public void setRealEstateDealNo(int realEstateDealNo) {
		RealEstateDealNo = realEstateDealNo;
	}

	public String getBuild_Year() {
		return Build_Year;
	}

	public void setBuild_Year(String build_Year) {
		Build_Year = build_Year;
	}

	public String getArea() {
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getDeal_Year() {
		return Deal_Year;
	}

	public void setDeal_Year(String deal_Year) {
		Deal_Year = deal_Year;
	}

	public String getDong() {
		return Dong;
	}

	public void setDong(String dong) {
		Dong = dong;
	}

	public String getDeposit() {
		return Deposit;
	}

	public void setDeposit(String deposit) {
		Deposit = deposit;
	}

	public String getDeal_Month() {
		return Deal_Month;
	}

	public void setDeal_Month(String deal_Month) {
		Deal_Month = deal_Month;
	}

	public int getMonthly_Rent() {
		return Monthly_Rent;
	}

	public void setMonthly_Rent(int monthly_Rent) {
		Monthly_Rent = monthly_Rent;
	}

	public String getDeal_Day() {
		return Deal_Day;
	}

	public void setDeal_Day(String deal_Day) {
		Deal_Day = deal_Day;
	}

	public String getRegional_Code() {
		return Regional_Code;
	}

	public void setRegional_Code(String regional_Code) {
		Regional_Code = regional_Code;
	}

}
