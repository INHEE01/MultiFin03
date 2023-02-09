package com.multifin.model.service;

import static com.multifin.common.JDBCTemplate.commit;
import static com.multifin.common.JDBCTemplate.openConnection;
import static com.multifin.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.multifin.model.dao.ExchangeRateDao;
import com.multifin.model.vo.ExchangeRate;

public class ExchangeRateService {
	private ExchangeRateDao dao = new ExchangeRateDao();
	private Connection conn = null;
	
	public ExchangeRateService() {
		conn = openConnection();
	}
	
	public List<ExchangeRate> selectAll() {
		return dao.selectAll(conn);
	}
	
	public int insert(ExchangeRate exchangeRate) {
		int result = dao.insert(conn,  exchangeRate);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

}
