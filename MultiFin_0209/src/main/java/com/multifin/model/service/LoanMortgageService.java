package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.multifin.model.dao.LoanMortgageDao;
import com.multifin.model.vo.LoanMortgage;

public class LoanMortgageService {
	private LoanMortgageDao dao = new LoanMortgageDao();
	private Connection conn = null;
	
	public LoanMortgageService() {
		conn = openConnection();
	}

	public int insert(LoanMortgage loanMortgage) {
		int result = dao.insert(conn,  loanMortgage);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
