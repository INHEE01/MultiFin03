package com.multifin.model.vo;

import java.util.Date;

public class RealEstateSvcOffiRent {
	private int RealEstateDealNo;
	private String Build_Year; // 건축년도
	private String Deal_Year; // 년도
	private String Offi_Name; // 단지
	private String Dong; // 법정동
	private String Deposit; // 보증금액
	private String Sigungu; // 시군구
	private String Deal_Month; // 월
	private int Monthly_Rent; // 월세 금액
	private String Deal_Day; // 일
	private String area; // 전용면적
	private String Regional_Code; // 지역코드
	private String Floor; // 층
	
	
	public RealEstateSvcOffiRent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RealEstateSvcOffiRent(int realEstateDealNo, String build_Year, String deal_Year, String offi_Name,
			String dong, String deposit, String sigungu, String deal_Month, int monthly_Rent, String deal_Day,
			String area, String regional_Code, String floor) {
		super();
		RealEstateDealNo = realEstateDealNo;
		Build_Year = build_Year;
		Deal_Year = deal_Year;
		Offi_Name = offi_Name;
		Dong = dong;
		Deposit = deposit;
		Sigungu = sigungu;
		Deal_Month = deal_Month;
		Monthly_Rent = monthly_Rent;
		Deal_Day = deal_Day;
		this.area = area;
		Regional_Code = regional_Code;
		Floor = floor;
	}
	@Override
	public String toString() {
		return "RealEstateSvcOffiRent [RealEstateDealNo=" + RealEstateDealNo + ", Build_Year=" + Build_Year
				+ ", Deal_Year=" + Deal_Year + ", Offi_Name=" + Offi_Name + ", Dong=" + Dong + ", Deposit=" + Deposit
				+ ", Sigungu=" + Sigungu + ", Deal_Month=" + Deal_Month + ", Monthly_Rent=" + Monthly_Rent
				+ ", Deal_Day=" + Deal_Day + ", area=" + area + ", Regional_Code=" + Regional_Code + ", Floor=" + Floor
				+ "]";
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
	public String getDeal_Year() {
		return Deal_Year;
	}
	public void setDeal_Year(String deal_Year) {
		Deal_Year = deal_Year;
	}
	public String getOffi_Name() {
		return Offi_Name;
	}
	public void setOffi_Name(String offi_Name) {
		Offi_Name = offi_Name;
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
	public String getSigungu() {
		return Sigungu;
	}
	public void setSigungu(String sigungu) {
		Sigungu = sigungu;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getRegional_Code() {
		return Regional_Code;
	}
	public void setRegional_Code(String regional_Code) {
		Regional_Code = regional_Code;
	}
	public String getFloor() {
		return Floor;
	}
	public void setFloor(String floor) {
		Floor = floor;
	}

	

}
