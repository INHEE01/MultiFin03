package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.RealEstateDealDao;
import com.multifin.model.vo.RealEstate;

public class RealEstateDealService {
	private RealEstateDealDao dao = new RealEstateDealDao();
	private Connection conn = null;
	
	public RealEstateDealService() {
		conn = openConnection();
	}
	
	public List<RealEstate> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(RealEstate RealEstate) {
		int result = dao.insert(conn,  RealEstate);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
