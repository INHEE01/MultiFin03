package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.LoanCreditDao;
import com.multifin.model.vo.LoanCredit;



public class LoanCreditService {
	private LoanCreditDao dao = new LoanCreditDao();
	private Connection conn = null;
	
	public LoanCreditService() {
		conn = openConnection();
	}

	public int insert(LoanCredit loanCredit) {
		int result = dao.insert(conn,  loanCredit);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}

}
