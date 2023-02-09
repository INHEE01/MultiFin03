package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.model.dao.LoanRentHouseDao;
import com.multifin.model.vo.LoanRentHouse;

public class LoanRentHouseService {
	private LoanRentHouseDao dao = new LoanRentHouseDao();
	private Connection conn = null;
	
	public LoanRentHouseService() {
		conn = openConnection();
	}

	public int insert(LoanRentHouse loanRentHouse) {
		int result = dao.insert(conn,  loanRentHouse);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
