package com.multifin.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import com.multifin.model.vo.LoanCredit;

public class LoanCreditDao {

	public int insert(Connection conn, LoanCredit loanCredit) {
		try {
			String sql = "insert into loanCredit(loanCreditNo,"
					+ "dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,"
					+ "fin_prdt_nm, join_way, crdt_prdt_type, crdt_prdt_type_nm,"
					+ "cb_name, "
					+ "dcls_strt_day, dcls_end_day, fin_co_subm_day,"
					+ "crdt_lend_rate_type, crdt_lend_rate_type_nm, crdt_grad_1,"
					+ "crdt_grad_4, crdt_grad_5, crdt_grad_6, crdt_grad_avg) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, loanCredit.getLoanCreditNo());
			pstmt.setString(cnt++, loanCredit.getDcls_month());
			pstmt.setString(cnt++, loanCredit.getFin_co_no());
			pstmt.setString(cnt++, loanCredit.getKor_co_nm());
			pstmt.setString(cnt++, loanCredit.getFin_prdt_cd());
			pstmt.setString(cnt++, loanCredit.getFin_prdt_nm());
			pstmt.setString(cnt++, loanCredit.getJoin_way());
			pstmt.setInt(cnt++, loanCredit.getCrdt_prdt_type());
			pstmt.setString(cnt++, loanCredit.getCrdt_prdt_type_nm());
			pstmt.setString(cnt++, loanCredit.getCb_name());
			pstmt.setDate(cnt++, new Date(loanCredit.getDcls_strt_day().getTime()));
			pstmt.setString(cnt++, loanCredit.getDcls_end_day());
			pstmt.setDate(cnt++, new Date(loanCredit.getFin_co_subm_day().getTime()));
			
			pstmt.setString(cnt++, loanCredit.getCrdt_lend_rate_type());
			pstmt.setString(cnt++, loanCredit.getCrdt_lend_rate_type_nm());
			pstmt.setDouble(cnt++, loanCredit.getCrdt_grad_1());
			pstmt.setDouble(cnt++, loanCredit.getCrdt_grad_4());
			pstmt.setDouble(cnt++, loanCredit.getCrdt_grad_5());
			pstmt.setDouble(cnt++, loanCredit.getCrdt_grad_6());
			pstmt.setDouble(cnt++, loanCredit.getCrdt_grad_avg());
			
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
