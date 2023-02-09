package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.RealEstateSvcOffiRentDao;
import com.multifin.model.vo.RealEstateSvcOffiRent;

public class RealEstateSvcOffiRentService {
	private RealEstateSvcOffiRentDao dao = new RealEstateSvcOffiRentDao();
	private Connection conn = null;
	
	public RealEstateSvcOffiRentService() {
		conn = openConnection();
	}
	
	public List<RealEstateSvcOffiRent> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(RealEstateSvcOffiRent RealEstateSvcOffiRent) {
		int result = dao.insert(conn,  RealEstateSvcOffiRent);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
