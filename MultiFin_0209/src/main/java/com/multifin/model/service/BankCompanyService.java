package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.BankCompanyDao;
import com.multifin.model.vo.BankCompany;

public class BankCompanyService {
	private BankCompanyDao dao = new BankCompanyDao();
	private Connection conn = null;
	
	public BankCompanyService() {
		conn = openConnection();
	}
	
	public List<BankCompany> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(BankCompany bankCompany) {
		int result = dao.insert(conn,  bankCompany);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}

}
