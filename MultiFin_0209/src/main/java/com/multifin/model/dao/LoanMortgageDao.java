package com.multifin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.multifin.model.vo.LoanMortgage;

public class LoanMortgageDao {
	
	public int insert(Connection conn, LoanMortgage loanMortgage) {
		
		try {
			String sql = "insert into LoanMortgage(loanMortgageNo,"
					+ "dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,"
					+ "fin_prdt_nm, join_way, loan_inci_expn, erly_rpay_fee,"
					+ "dly_rate, loan_lmt, "
					+ "dcls_strt_day, dcls_end_day, fin_co_subm_day,"
					+ "mrtg_type, mrtg_type_nm, rpay_type, rpay_type_nm, "
					+ "lend_rate_type, lend_rate_type_nm, lend_rate_min, "
					+ "lend_rate_max, lend_rate_avg) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, loanMortgage.getLoanMortgageNo());
			pstmt.setString(cnt++, loanMortgage.getDcls_month());
			pstmt.setString(cnt++, loanMortgage.getFin_co_no());
			pstmt.setString(cnt++, loanMortgage.getKor_co_nm());
			pstmt.setString(cnt++, loanMortgage.getFin_prdt_cd());
			pstmt.setString(cnt++, loanMortgage.getFin_prdt_nm());
			pstmt.setString(cnt++, loanMortgage.getJoin_way());
			
			pstmt.setString(cnt++, loanMortgage.getLoan_inci_expn());
			pstmt.setString(cnt++, loanMortgage.getErly_rpay_fee());
			pstmt.setString(cnt++, loanMortgage.getDly_rate());

			pstmt.setLong(cnt++, loanMortgage.getLoan_lmt());
			pstmt.setDate(cnt++, new Date(loanMortgage.getDcls_strt_day().getTime()));
			pstmt.setString(cnt++, loanMortgage.getDcls_end_day());
			pstmt.setDate(cnt++, new Date(loanMortgage.getFin_co_subm_day().getTime()));
			
			pstmt.setString(cnt++, loanMortgage.getMrtg_type());
			pstmt.setString(cnt++, loanMortgage.getMrtg_type_nm());
			pstmt.setString(cnt++, loanMortgage.getRpay_type());
			pstmt.setString(cnt++, loanMortgage.getRpay_type_nm());
			pstmt.setString(cnt++, loanMortgage.getLend_rate_type());
			pstmt.setString(cnt++, loanMortgage.getLend_rate_type_nm());
			pstmt.setDouble(cnt++, loanMortgage.getLend_rate_min());
			pstmt.setDouble(cnt++, loanMortgage.getLend_rate_max());
			pstmt.setDouble(cnt++, loanMortgage.getLend_rate_avg());

			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
