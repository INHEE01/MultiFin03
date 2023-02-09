package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.BankDeposit;

public class BankDepositDao {
	// 전체 조회
	public List<BankDeposit> selectAll(Connection conn) {
		List<BankDeposit> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM BANKDEPOSIT";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int bankDepositNo = rs.getInt(count++);
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
				String save_trm = rs.getString(count++);
				long intr_rate = rs.getLong(count++);
				long intr_rate2 = rs.getLong(count++);

				BankDeposit info = new BankDeposit(bankDepositNo, dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,
						fin_prdt_nm, join_way, mtrt_int, spcl_cnd, join_deny, join_member, etc_note, max_limit,
						dcls_strt_day, dcls_end_day, fin_co_subm_day, intr_rate_type, intr_rate_type_nm, save_trm,
						intr_rate, intr_rate2);

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

	public int insert(Connection conn, BankDeposit bankDeposit) {
		try {
			String sql = "insert into bankdeposit(bankDepositNo,"
					+ "dcls_month, fin_co_no, kor_co_nm, fin_prdt_cd,"
					+ "fin_prdt_nm, join_way, mtrt_int, spcl_cnd,"
					+ "join_deny, join_member, etc_note, max_limit,"
					+ "dcls_strt_day, dcls_end_day, fin_co_subm_day,"
					+ "intr_rate_type, intr_rate_type_nm, save_trm,"
					+ "intr_rate, intr_rate2) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, bankDeposit.getBankDepositNo());
			pstmt.setString(cnt++, bankDeposit.getDcls_month());
			pstmt.setString(cnt++, bankDeposit.getFin_co_no());
			pstmt.setString(cnt++, bankDeposit.getKor_co_nm());
			pstmt.setString(cnt++, bankDeposit.getFin_prdt_cd());
			pstmt.setString(cnt++, bankDeposit.getFin_prdt_nm());
			pstmt.setString(cnt++, bankDeposit.getJoin_way());
			pstmt.setString(cnt++, bankDeposit.getMtrt_int());
			pstmt.setString(cnt++, bankDeposit.getSpcl_cnd());
			pstmt.setString(cnt++, bankDeposit.getJoin_deny());
			pstmt.setString(cnt++, bankDeposit.getJoin_member());
			pstmt.setString(cnt++, bankDeposit.getEtc_note());
			pstmt.setLong(cnt++, bankDeposit.getMax_limit());
			pstmt.setDate(cnt++, new Date(bankDeposit.getDcls_strt_day().getTime()));
			pstmt.setString(cnt++, bankDeposit.getDcls_end_day());
			pstmt.setDate(cnt++, new Date(bankDeposit.getFin_co_subm_day().getTime()));
			
			pstmt.setString(cnt++, bankDeposit.getIntr_rate_type());
			pstmt.setString(cnt++, bankDeposit.getIntr_rate_type_nm());
			pstmt.setString(cnt++, bankDeposit.getSave_trm());
			pstmt.setLong(cnt++, bankDeposit.getIntr_rate());
			pstmt.setLong(cnt++, bankDeposit.getIntr_rate2());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
