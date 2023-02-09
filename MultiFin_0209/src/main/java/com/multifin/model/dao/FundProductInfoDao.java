package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.multifin.model.vo.FundProductInfo;

public class FundProductInfoDao {
	// 전체 조회
	public List<FundProductInfo> selectAll(Connection conn) {
		List<FundProductInfo> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}
	// 데이터 삽입
	public int insert(Connection conn, FundProductInfo fundProductInfo) {
		try {
			String sql = "insert into fundProductInfo(fpino, basDt, srtnCd, fndNm, ctg, setpDt, fndTp, prdClsfCd, asoStdCd) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, fundProductInfo.getFpino());
			pstmt.setDate(cnt++, new Date(fundProductInfo.getBasDt().getTime()));
			pstmt.setString(cnt++, fundProductInfo.getSrtnCd());
			pstmt.setString(cnt++, fundProductInfo.getFndNm());
			pstmt.setString(cnt++, fundProductInfo.getCtg());
			pstmt.setDate(cnt++, new Date(fundProductInfo.getSetpDt().getTime()));
			pstmt.setString(cnt++, fundProductInfo.getFndTp());
			pstmt.setString(cnt++, fundProductInfo.getPrdClsfCd());
			pstmt.setString(cnt++, fundProductInfo.getAsoStdCd());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return -1;
	}

}
