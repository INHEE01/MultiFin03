package com.multifin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.multifin.model.vo.LoanRentHouse;

public class LoanRentHouseDao {
	public int insert(Connection conn, LoanRentHouse loanRentHouse) {
		
		try {
			String sql = "insert into loanRentHouse(loanRentHouseNo,"
					+ "dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,"
					+ "fin_prdt_nm, join_way, loan_inci_expn, erly_rpay_fee,"
					+ "dly_rate, loan_lmt, "
					+ "dcls_strt_day, dcls_end_day, fin_co_subm_day,"
					+ "rpay_type, rpay_type_nm, "
					+ "lend_rate_type, lend_rate_type_nm, lend_rate_min, "
					+ "lend_rate_max, lend_rate_avg) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, loanRentHouse.getLoanRentHouseNo());
			pstmt.setString(cnt++, loanRentHouse.getDcls_month());
			pstmt.setString(cnt++, loanRentHouse.getFin_co_no());
			pstmt.setString(cnt++, loanRentHouse.getKor_co_nm());
			pstmt.setString(cnt++, loanRentHouse.getFin_prdt_cd());
			pstmt.setString(cnt++, loanRentHouse.getFin_prdt_nm());
			pstmt.setString(cnt++, loanRentHouse.getJoin_way());
			
			pstmt.setString(cnt++, loanRentHouse.getLoan_inci_expn());
			pstmt.setString(cnt++, loanRentHouse.getErly_rpay_fee());
			pstmt.setString(cnt++, loanRentHouse.getDly_rate());

			pstmt.setString(cnt++, loanRentHouse.getLoan_lmt());
			pstmt.setDate(cnt++, new Date(loanRentHouse.getDcls_strt_day().getTime()));
			pstmt.setString(cnt++, loanRentHouse.getDcls_end_day());
			pstmt.setDate(cnt++, new Date(loanRentHouse.getFin_co_subm_day().getTime()));
			

			pstmt.setString(cnt++, loanRentHouse.getRpay_type());
			pstmt.setString(cnt++, loanRentHouse.getRpay_type_nm());
			pstmt.setString(cnt++, loanRentHouse.getLend_rate_type());
			pstmt.setString(cnt++, loanRentHouse.getLend_rate_type_nm());
			pstmt.setDouble(cnt++, loanRentHouse.getLend_rate_min());
			pstmt.setDouble(cnt++, loanRentHouse.getLend_rate_max());
			pstmt.setDouble(cnt++, loanRentHouse.getLend_rate_avg());

			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
