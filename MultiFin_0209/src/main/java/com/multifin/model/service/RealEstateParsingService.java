package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.MarkerDao;
import com.multifin.model.vo.MarkerParsing;
import com.multifin.model.vo.RealEstate;

public class RealEstateParsingService {
	private MarkerDao dao = new MarkerDao();
	private Connection conn = null;
	
	public RealEstateParsingService() {
		conn = openConnection();
	}
	
	public List<RealEstate> selectAll() {
		return dao.selectAll(conn);
	}
	
	public List<RealEstate> selectAllName() {
		return dao.selectAllName(conn);
	}
	public List<MarkerParsing> selectAllXY() {
		return dao.selectAllXY(conn);
	}
	
	public int insert(MarkerParsing markerParsing) {
		int result = dao.insert(conn,  markerParsing);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
