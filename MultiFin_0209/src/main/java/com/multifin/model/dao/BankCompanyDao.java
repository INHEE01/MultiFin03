package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.multifin.model.vo.BankCompany;

public class BankCompanyDao {
	// 전체 조회
	public List<BankCompany> selectAll(Connection conn) {
		List<BankCompany> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM BANKCOMPANY";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				int bankCompanyNo = rs.getInt(count++);
				String dcls_month = rs.getString(count++);
				String fin_co_no = rs.getString(count++);
				String kor_co_nm = rs.getString(count++);
				String dcls_chrg_man = rs.getString(count++);
				String homp_url = rs.getString(count++);
				String cal_tel = rs.getString(count++);
				
				int area_cd = rs.getInt(count++);
				String area_nm = rs.getString(count++);
				String exis_yn = rs.getString(count++);
				
				BankCompany info = new BankCompany(bankCompanyNo, dcls_month, fin_co_no, 
						kor_co_nm, dcls_chrg_man, homp_url,
						cal_tel, area_cd, area_nm, exis_yn);
				
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
	
	// 데이터 삽입
	public int insert(Connection conn, BankCompany bankCompany) {
		try {
			String sql = "insert into bankcompany(bankCompanyNo, dcls_month, fin_co_no,"
					+ "kor_co_nm, dcls_chrg_man, homp_url, cal_tel, area_cd, area_nm, exis_yn) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, bankCompany.getBankCompanyNo());
			pstmt.setString(cnt++, bankCompany.getDcls_month());
			pstmt.setString(cnt++, bankCompany.getFin_co_no());
			pstmt.setString(cnt++, bankCompany.getKor_co_nm());
			pstmt.setString(cnt++, bankCompany.getDcls_chrg_man());
			pstmt.setString(cnt++, bankCompany.getHomp_url());
			pstmt.setString(cnt++, bankCompany.getCal_tel());

			pstmt.setInt(cnt++, bankCompany.getArea_cd());
			pstmt.setString(cnt++, bankCompany.getArea_nm());
			pstmt.setString(cnt++, bankCompany.getExis_yn());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
