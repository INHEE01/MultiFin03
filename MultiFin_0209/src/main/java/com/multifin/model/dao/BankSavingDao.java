package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.multifin.model.vo.BankSaving;

public class BankSavingDao {
	// 전체 조회
	public List<BankSaving> selectAll(Connection conn) {
		List<BankSaving> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM BANKSAVING";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				int bankSavingNo = rs.getInt(count++);
				String dcls_month = rs.getString(count++);
				String fin_co_no = rs.getString(count++);
				String kor_co_nm = rs.getString(count++);
				String fin_prdt_cd = rs.getString(count++);
				String fin_prdt_nm = rs.getString(count++);
				String join_way = rs.getString(count++);
				String mtrt_int = rs.getString(count++);
				String spcl_cnd = rs.getString(count++);
				String join_deny = rs.getString(count++);
				String join_member = rs.getString(count++);
				String etc_note = rs.getString(count++);
				long max_limit = rs.getLong(count++);
				Date dcls_strt_day = rs.getDate(count++);
				String dcls_end_day = rs.getString(count++);
				Date fin_co_subm_day = rs.getDate(count++);
				
				String intr_rate_type = rs.getString(count++);
				String intr_rate_type_nm = rs.getString(count++);
				String rsrv_type = rs.getString(count++);
				String rsrv_type_nm = rs.getString(count++);
				String save_trm = rs.getString(count++);
				long intr_rate = rs.getLong(count++);
				long intr_rate2 = rs.getLong(count++);
				
				BankSaving info = new BankSaving(bankSavingNo,
						dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,
						fin_prdt_nm, join_way, mtrt_int, spcl_cnd,
						join_deny, join_member, etc_note, max_limit, 
						dcls_strt_day, dcls_end_day, fin_co_subm_day,
						intr_rate_type, intr_rate_type_nm, rsrv_type,
						rsrv_type_nm, save_trm, intr_rate, intr_rate2);
				
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

	public int insert(Connection conn, BankSaving bankSaving) {
		try {
			String sql = "insert into bankSaving(bankSavingNo,"
					+ "dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,"
					+ "fin_prdt_nm, join_way, mtrt_int, spcl_cnd,"
					+ "join_deny, join_member, etc_note, max_limit,"
					+ "dcls_strt_day, dcls_end_day, fin_co_subm_day,"
					+ "intr_rate_type, intr_rate_type_nm, rsrv_type,"
					+ "rsrv_type_nm, save_trm,"
					+ "intr_rate, intr_rate2) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?"
					+ ")";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, bankSaving.getBankSavingNo());
			pstmt.setString(cnt++, bankSaving.getDcls_month());
			pstmt.setString(cnt++, bankSaving.getFin_co_no());
			pstmt.setString(cnt++, bankSaving.getKor_co_nm());
			pstmt.setString(cnt++, bankSaving.getFin_prdt_cd());
			pstmt.setString(cnt++, bankSaving.getFin_prdt_nm());
			pstmt.setString(cnt++, bankSaving.getJoin_way());
			pstmt.setString(cnt++, bankSaving.getMtrt_int());
			pstmt.setString(cnt++, bankSaving.getSpcl_cnd());
			pstmt.setString(cnt++, bankSaving.getJoin_deny());
			pstmt.setString(cnt++, bankSaving.getJoin_member());
			pstmt.setString(cnt++, bankSaving.getEtc_note());
			pstmt.setLong(cnt++, bankSaving.getMax_limit());
			pstmt.setDate(cnt++, new Date(bankSaving.getDcls_strt_day().getTime()));
			pstmt.setString(cnt++, bankSaving.getDcls_end_day());
			pstmt.setDate(cnt++, new Date(bankSaving.getFin_co_subm_day().getTime()));
			
			pstmt.setString(cnt++, bankSaving.getIntr_rate_type());
			pstmt.setString(cnt++, bankSaving.getIntr_rate_type_nm());
			pstmt.setString(cnt++, bankSaving.getRsrv_type());
			pstmt.setString(cnt++, bankSaving.getRsrv_type_nm());
			pstmt.setString(cnt++, bankSaving.getSave_trm());
			pstmt.setLong(cnt++, bankSaving.getIntr_rate());
			pstmt.setLong(cnt++, bankSaving.getIntr_rate2());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	
}
