package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.RealEstateSvcSHRentDao;
import com.multifin.model.vo.RealEstateSvcSHRent;

public class RealEstateSvcSHRentService {
	private RealEstateSvcSHRentDao dao = new RealEstateSvcSHRentDao();
	private Connection conn = null;
	
	public RealEstateSvcSHRentService() {
		conn = openConnection();
	}
	
	public List<RealEstateSvcSHRent> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(RealEstateSvcSHRent RealEstateSvcSHRent) {
		int result = dao.insert(conn,  RealEstateSvcSHRent);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
