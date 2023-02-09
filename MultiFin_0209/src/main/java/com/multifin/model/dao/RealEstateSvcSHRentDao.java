package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.RealEstateSvcSHRent;

public class RealEstateSvcSHRentDao {
	// 전체 조회
	public List<RealEstateSvcSHRent> selectAll(Connection conn) {
		List<RealEstateSvcSHRent> list = new ArrayList<>();
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
				String deal_Year = rs.getString(count++);
				String dong = rs.getString(count++);
				String deposit = rs.getString(count++);
				String deal_Month = rs.getString(count++);
				int monthly_Rent = rs.getInt(count++);
				String deal_Day = rs.getString(count++);
				String area = rs.getString(count++);
				String regional_Code = rs.getString(count++);

				RealEstateSvcSHRent info = new RealEstateSvcSHRent(realEstateDealNo, build_Year, area, deal_Year,
						dong, deposit,  deal_Month, monthly_Rent, deal_Day,regional_Code);

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

	public int insert(Connection conn, RealEstateSvcSHRent realEstate) {
		try {
			String sql = "insert into realEstate(realEstateDealNo,"
					+ "build_Year, area, deal_Year,"
					+ "dong, deposit, deal_Month,"
					+ "monthly_Rent, deal_Day,"
					+ "regional_Code)"
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, realEstate.getRealEstateDealNo());
			pstmt.setString(cnt++, realEstate.getBuild_Year());
			pstmt.setString(cnt++, realEstate.getDeal_Year());
			pstmt.setString(cnt++, realEstate.getDong());
			pstmt.setString(cnt++, realEstate.getDeposit());
			pstmt.setString(cnt++, realEstate.getDeal_Month());
			pstmt.setInt(cnt++, realEstate.getMonthly_Rent());
			pstmt.setString(cnt++, realEstate.getDeal_Day());
			pstmt.setString(cnt++, realEstate.getArea());
			pstmt.setString(cnt++, realEstate.getRegional_Code());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
