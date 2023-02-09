package com.multifin.model.dao;

import static com.multifin.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.multifin.model.vo.MarkerParsing;
import com.multifin.model.vo.RealEstate;
public class MarkerDao {
	// 전체 조회
	public List<RealEstate> selectAll(Connection conn) {
		List<RealEstate> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT realEstateDealNo,dong,jibun FROM RealEstate";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int realEstateDealNo = rs.getInt(count++);
				String dong = rs.getString(count++);
				String jibun = rs.getString(count++);

				RealEstate info = new RealEstate(realEstateDealNo, dong, jibun);
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
	
	public List<RealEstate> selectAllName(Connection conn) {
		List<RealEstate> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT realEstateDealNo,build_Year,apartment_Name,area,floor FROM RealEstate";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;

				int realEstateDealNo = rs.getInt(count++);
				String build_Year = rs.getString(count++);
				String apartment_Name = rs.getString(count++);
				String area = rs.getString(count++);
				String floor = rs.getString(count++);

				RealEstate info = new RealEstate(realEstateDealNo, build_Year,apartment_Name, area,floor);
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
	
	
	
	public List<MarkerParsing> selectAllXY(Connection conn) {
		List<MarkerParsing> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT searchAddr,x,y FROM Marker";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				String searchAddr = rs.getString(count++);
				String x = rs.getString(count++);
				String y = rs.getString(count++);

				MarkerParsing info = new MarkerParsing(searchAddr, x, y);
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
	
	
	public int insert(Connection conn, MarkerParsing markerParsing) {
		try {
			String sql = "insert into Marker(realEstateDealNo,"
					+ "searchAddr,"
					+ "x,y)"
					+ "values(?, ?, ?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int cnt = 1;
			pstmt.setInt(cnt++, markerParsing.getRno());
			pstmt.setString(cnt++, markerParsing.getText());
			pstmt.setObject(cnt++, markerParsing.getX());
			pstmt.setObject(cnt++, markerParsing.getY());
			
			int result = pstmt.executeUpdate();
			
			pstmt.close();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
