package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.BankDepositDao;
import com.multifin.model.vo.BankDeposit;

public class BankDepositService {
	private BankDepositDao dao = new BankDepositDao();
	private Connection conn = null;
	
	public BankDepositService() {
		conn = openConnection();
	}
	
	public List<BankDeposit> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(BankDeposit bankDeposit) {
		int result = dao.insert(conn,  bankDeposit);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result; 
	}
	
}
