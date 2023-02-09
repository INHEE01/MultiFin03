package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.RealEstate;

public class RealEstateDealDao {
	// 전체 조회
	public List<RealEstate> selectAll(Connection conn) {
		List<RealEstate> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM RealEstate";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int realEstateDealNo = rs.getInt(count++);
				String build_Year = rs.getString(count++);
				String contract_Type = rs.getString(count++);
				String term_Contract = rs.getString(count++);
				String deal_Year = rs.getString(count++);
				String dong = rs.getString(count++);
				String deposit = rs.getString(count++);
				String apartment_Name = rs.getString(count++);
				String deal_Month = rs.getString(count++);
				int monthly_Rent = rs.getInt(count++);
				String deal_Day = rs.getString(count++);
				String area = rs.getString(count++);
				String jibun = rs.getString(count++);
				String regional_Code = rs.getString(count++);
				String floor = rs.getString(count++);

				RealEstate info = new RealEstate(realEstateDealNo, build_Year, contract_Type, term_Contract, deal_Year,
						dong, deposit, apartment_Name, deal_Month, monthly_Rent, deal_Day, area, jibun,
						regional_Code, floor);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int insert(Connection conn, RealEstate realEstate) {
		try {
			String sql = "insert into realEstate(realEstateDealNo,"
					+ "build_Year, contract_Type, term_Contract, deal_Year,"
					+ "dong, deposit, apartment_Name, deal_Month,"
					+ "monthly_Rent, deal_Day, area, jibun,"
					+ "regional_Code, floor)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, realEstate.getRealEstateDealNo());
			pstmt.setString(cnt++, realEstate.getBuild_Year());
			pstmt.setString(cnt++, realEstate.getContract_Type());
			pstmt.setString(cnt++, realEstate.getTerm_Contract());
			pstmt.setString(cnt++, realEstate.getDeal_Year());
			pstmt.setString(cnt++, realEstate.getDong());
			pstmt.setString(cnt++, realEstate.getDeposit());
			pstmt.setString(cnt++, realEstate.getApartment_Name());
			pstmt.setString(cnt++, realEstate.getDeal_Month());
			pstmt.setInt(cnt++, realEstate.getMonthly_Rent());
			pstmt.setString(cnt++, realEstate.getDeal_Day());
			pstmt.setString(cnt++, realEstate.getArea());
			pstmt.setString(cnt++, realEstate.getJibun());
			pstmt.setString(cnt++, realEstate.getRegional_Code());
			pstmt.setString(cnt++, realEstate.getFloor());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
