package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.StockPrice;

public class StockPriceDao {
	// 전체 조회
	public List<StockPrice> selectAll(Connection conn) {
		List<StockPrice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "SELECT * FROM STOCKPRICE";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int count = 1;
				int sno = rs.getInt(count++);
				Date basDt = rs.getDate(count++);
				int srtnCd = rs.getInt(count++);
				int isinCd = rs.getInt(count++);
				String itmsNm = rs.getString(count++);
				String mrktCtg = rs.getString(count++);
				String clpr = rs.getString(count++);
				String vs = rs.getString(count++);
				String fltRt = rs.getString(count++);
				int mkp = rs.getInt(count++);
				int hipr = rs.getInt(count++);
				int lopr = rs.getInt(count++);
				int trqu = rs.getInt(count++);
				long trPrc = rs.getLong(count++);
				long lstgStCnt = rs.getLong(count++);
				long mrktTotAmt = rs.getLong(count++);
				
				
				StockPrice info = new StockPrice(sno, basDt, srtnCd, isinCd, 
						itmsNm, mrktCtg, clpr, vs, fltRt,
						mkp, hipr, lopr, trqu, 
						trPrc, lstgStCnt, mrktTotAmt);
				
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
	public int insert(Connection conn, StockPrice stockPrice) {
		try {
			String sql = "insert into stockPrice(sno, basDt, srtnCd, isinCd, itmsNm, mrktCtg, clpr, vs, fltRt, mkp, hipr, lopr, trqu, trPrc, lstgStCnt, mrktTotAmt) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, stockPrice.getSno());
			pstmt.setDate(cnt++, new Date(stockPrice.getBasDt().getTime()));
			pstmt.setInt(cnt++, stockPrice.getSrtnCd());
			pstmt.setInt(cnt++, stockPrice.getIsinCd());
			pstmt.setString(cnt++, stockPrice.getItmsNm());
			pstmt.setString(cnt++, stockPrice.getMrktCtg());
			pstmt.setString(cnt++, stockPrice.getClpr());
			pstmt.setString(cnt++, stockPrice.getVs());
			pstmt.setString(cnt++, stockPrice.getFltRt());
			pstmt.setInt(cnt++, stockPrice.getMkp());
			pstmt.setInt(cnt++, stockPrice.getHipr());
			pstmt.setInt(cnt++, stockPrice.getLopr());
			pstmt.setInt(cnt++, stockPrice.getTrqu());
			pstmt.setLong(cnt++, stockPrice.getTrPrc());
			pstmt.setLong(cnt++, stockPrice.getLstgStCnt());
			pstmt.setLong(cnt++, stockPrice.getMrktTotAmt());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}

}
