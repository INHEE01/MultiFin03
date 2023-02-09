package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.ExchangeRate;

public class ExchangeRateDao {
	
	// 전체 조회
	public List<ExchangeRate> selectAll(Connection conn) {
		List<ExchangeRate> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM EXCHANGERATE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				int rno = rs.getInt(count++);
				Date recordDate = rs.getDate(count++);
				String cur_unit = rs.getString(count++);
				String ttb = rs.getString(count++);
				String tts = rs.getString(count++);
				String deal_bas_r = rs.getString(count++);
				String bkpr = rs.getString(count++);
				String yy_efee_r = rs.getString(count++);
				String ten_dd_efee_r = rs.getString(count++);
				String kftc_bkpr = rs.getString(count++);
				String kftc_deal_bas_r = rs.getString(count++);
				String cur_nm = rs.getString(count++);
				
				ExchangeRate info = new ExchangeRate(rno, recordDate, cur_unit, ttb, tts, deal_bas_r, bkpr, yy_efee_r, ten_dd_efee_r, kftc_bkpr, kftc_deal_bas_r, cur_nm);
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
	public int insert(Connection conn, ExchangeRate exchangeRate) {
		try {
			String sql = "insert into exchangeRate(rno, recordDate, cur_unit, ttb, tts, deal_bas_r, bkpr, yy_efee_r, ten_dd_efee_r, kftc_bkpr, kftc_deal_bas_r, cur_nm) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, exchangeRate.getRno());
			pstmt.setDate(cnt++, new Date(exchangeRate.getRecorddate().getTime()));
			pstmt.setString(cnt++, exchangeRate.getCur_unit());
			pstmt.setString(cnt++, exchangeRate.getTtb());
			pstmt.setString(cnt++, exchangeRate.getTts());
			pstmt.setString(cnt++, exchangeRate.getDeal_bas_r());
			pstmt.setString(cnt++, exchangeRate.getBkpr());
			pstmt.setString(cnt++, exchangeRate.getYy_efee_r());
			pstmt.setString(cnt++, exchangeRate.getTen_dd_efee_r());
			pstmt.setString(cnt++, exchangeRate.getKftc_bkpr());
			pstmt.setString(cnt++, exchangeRate.getKftc_deal_bas_r());
			pstmt.setString(cnt++, exchangeRate.getCur_nm());
			
			int result = pstmt.executeUpdate(); // 업데이트 쿼리
			
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
}
