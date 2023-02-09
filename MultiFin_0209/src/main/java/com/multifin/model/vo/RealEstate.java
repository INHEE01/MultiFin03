package com.multifin.model.vo;

public class RealEstate {
	private int RealEstateDealNo ;
	private String Build_Year; 		// 
	private String Contract_Type; 	// 
	private String Term_Contract; 	// 
	private String Deal_Year;		// 
	private String Dong; 			// 
	private String Deposit; 			// 
	private String Apartment_Name; 	// 
	private String Deal_Month; 	// 
	private int Monthly_Rent; 	// 
	private String Deal_Day; 		//
	private String Area; 		//
	private String Jibun; // 
	private String Regional_Code; 	// 
	private String Floor; 	//
	private double x;
	private double y;
	
	
	public RealEstate() {
		super();
	}
	
	public RealEstate(int RealEstateDealNo, String build_Year, String contract_Type, String term_Contract, String deal_Year,
			String dong, String deposit, String apartment_Name, String deal_Month, int monthly_Rent, String deal_Day,
			String area, String jibun, String regional_Code, String floor) {
		super();
		this.RealEstateDealNo = RealEstateDealNo;
		Build_Year = build_Year;
		Contract_Type = contract_Type;
		Term_Contract = term_Contract;
		Deal_Year = deal_Year;
		Dong = dong;
		Deposit = deposit;
		Apartment_Name = apartment_Name;
		Deal_Month = deal_Month;
		Monthly_Rent = monthly_Rent;
		Deal_Day = deal_Day;
		Area = area;
		Jibun = jibun;
		Regional_Code = regional_Code;
		Floor = floor;
	}
	public RealEstate(int RealEstateDealNo, String build_Year,
			String apartment_Name, 
			String area, String floor) {
		super();
		this.RealEstateDealNo = RealEstateDealNo;
		Build_Year = build_Year;
		Apartment_Name = apartment_Name;
		Area = area;
		Floor = floor;
	}
	
	public RealEstate(int RealEstateDealNo,String dong, String jibun) {
		this.RealEstateDealNo = RealEstateDealNo;
		Dong = dong;
		Jibun = jibun;

	}
	
	public RealEstate(int RealEstateDealNo, String dong,String apartment_Name, String jibun) {
		this.RealEstateDealNo = RealEstateDealNo;
		Dong = dong;
		Apartment_Name =apartment_Name;
		Jibun = jibun;

	}
	public int getRealEstateDealNo() {
		return RealEstateDealNo;
	}


	public void setRealEstateDealNo(int RealEstateDealNo) {
		this.RealEstateDealNo = RealEstateDealNo;
	}

	public String getBuild_Year() {
		return Build_Year;
	}

	public void setBuild_Year(String build_Year) {
		Build_Year = build_Year;
	}

	public String getContract_Type() {
		return Contract_Type;
	}

	public void setContract_Type(String contract_Type) {
		Contract_Type = contract_Type;
	}

	public String getTerm_Contract() {
		return Term_Contract;
	}

	public void setTerm_Contract(String term_Contract) {
		Term_Contract = term_Contract;
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

	public String getApartment_Name() {
		return Apartment_Name;
	}

	public void setApartment_Name(String apartment_Name) {
		Apartment_Name = apartment_Name;
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
		return Area;
	}

	public void setArea(String area) {
		Area = area;
	}

	public String getJibun() {
		return Jibun;
	}

	public void setJibun(String jibun) {
		Jibun = jibun;
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

	
	
	@Override
	public String toString() {
		return "RealEstate [RealEstateDealNo=" + RealEstateDealNo + ", Build_Year=" + Build_Year + ", Contract_Type=" + Contract_Type
				+ ", Term_Contract=" + Term_Contract + ", Deal_Year=" + Deal_Year + ", Dong=" + Dong + ", Deposit="
				+ Deposit + ", Apartment_Name=" + Apartment_Name + ", Deal_Month=" + Deal_Month + ", Monthly_Rent="
				+ Monthly_Rent + ", Deal_Day=" + Deal_Day + ", Area=" + Area + ", Jibun=" + Jibun + ", Regional_Code="
				+ Regional_Code + ", Floor=" + Floor + "]";
	}

	
}
