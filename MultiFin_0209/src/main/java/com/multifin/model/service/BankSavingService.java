package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.BankSavingDao;
import com.multifin.model.vo.BankSaving;

public class BankSavingService {
	private BankSavingDao dao = new BankSavingDao();
	private Connection conn = null;

	public BankSavingService() {
		conn = openConnection();
	}

	public List<BankSaving> selectAll() {
		return dao.selectAll(conn);
	}

	public int insert(BankSaving bankSaving) {
		int result = dao.insert(conn, bankSaving);
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
